/*
 * Copyright or © or Copr. Moribus (2013)
 * Copyright or © or Copr. ProkopyL <prokopylmc@gmail.com> (2015)
 * Copyright or © or Copr. Amaury Carrade <amaury@carrade.eu> (2016 – 2021)
 * Copyright or © or Copr. Vlammar <valentin.jabre@gmail.com> (2019 – 2021)
 *
 * This software is a computer program whose purpose is to allow insertion of
 * custom images in a Minecraft world.
 *
 * This software is governed by the CeCILL license under French law and
 * abiding by the rules of distribution of free software.  You can  use,
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability.
 *
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or
 * data to be ensured and,  more generally, to use and operate it in the
 * same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */

package ru.fleyer.ftest.commands.maptool;

import ru.fleyer.ftest.Permissions;
import ru.fleyer.ftest.commands.IoMCommand;
import ru.fleyer.ftest.image.ImageRendererExecutor;
import ru.fleyer.ftest.image.ImageUtils;
import ru.fleyer.ftest.map.ImageMap;
import ru.fleyer.ftest.map.MapManager;
import ru.fleyer.ftest.map.PosterMap;
import fr.zcraft.quartzlib.components.commands.CommandException;
import fr.zcraft.quartzlib.components.commands.CommandInfo;
import fr.zcraft.quartzlib.components.i18n.I;
import fr.zcraft.quartzlib.components.worker.WorkerCallback;
import fr.zcraft.quartzlib.tools.PluginLogger;
import fr.zcraft.quartzlib.tools.text.ActionBar;
import fr.zcraft.quartzlib.tools.text.MessageSender;
import java.net.MalformedURLException;
import java.net.URL;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "new", usageParameters = "{playername} <URL> [resize]")
public class NewCommand extends IoMCommand {

    private ImageUtils.ScalingType resizeMode() throws CommandException {
        switch (args[1]) {
            case "resize":
                return ImageUtils.ScalingType.CONTAINED;
            case "stretch":
            case "stretched":
            case "resize-stretched":
                return ImageUtils.ScalingType.STRETCHED;
            case "cover":
            case "covered":
            case "resize-covered":
                return ImageUtils.ScalingType.COVERED;
            default:
                throwInvalidArgument(I.t("Недопустимый режим растяжения."));
                return ImageUtils.ScalingType.NONE;
        }
    }

    @Override
    protected void run() throws CommandException {
        final Player player = playerSender();
        ImageUtils.ScalingType scaling = ImageUtils.ScalingType.NONE;
        URL url;
        int width = 0;
        int height = 0;

        if (args.length < 1) {
            throwInvalidArgument(I.t("Вы должны указать URL-адрес, чтобы взять изображение."));
        }
        //Проверка того, соответствует ли ограничение карты и ограничение изображения
        if (!Permissions.BYPASS_IMAGE_LIMIT.grantedTo(player)) {
            int imageLimit = Permissions.NEW.getLimitPermission(player, Permissions.LimitType.image);
            int imageCount = MapManager.getPlayerMapStore(player.getUniqueId()).getImagesCount();
            if (imageLimit <= imageCount) {
                throwInvalidArgument(
                        I.t("Ваш лимит изображения установлен на {0}, и в настоящее время у вас есть {1} загруженные изображения",
                                imageLimit,
                                imageCount));
            }
        }
        if (!Permissions.BYPASS_MAP_LIMIT.grantedTo(player)) {
            int mapLimit = Permissions.NEW.getLimitPermission(player, Permissions.LimitType.map);
            int mapCount = MapManager.getPlayerMapStore(player.getUniqueId()).getMapCount();
            if (mapLimit <= mapCount) {
                throwInvalidArgument(
                        I.t("Ваш лимит карты установлен на {0}, и в настоящее время у вас есть {1} загруженные карты (ы)",
                                mapLimit,
                                mapCount));
            }
        }
        try {
            url = new URL(args[0]);
            if (!Permissions.BYPASS_WHITELIST.grantedTo(player) && !checkHostnameWhitelist(url)) {
                throwInvalidArgument(I.t("Этому веб-сайту хостинга не доверяют, если вы считаете, что это ошибка "
                        + " , обратитесь к администратору вашего сервера"));
                return;
            }

        } catch (MalformedURLException ex) {
            throwInvalidArgument(I.t("Недопустимый URL-адрес."));
            return;
        }

        if (args.length >= 2) {
            if (args.length >= 3) {
                try {
                    if (args.length >= 4) {
                        width = Integer.parseInt(args[2]);
                        height = Integer.parseInt(args[3]);
                    } else {
                        String[] size;
                        if (args[2].contains("*") && !args[2].contains("x")) {
                            size = args[2].split("\\*");
                            width = Integer.parseInt(size[0]);
                            height = Integer.parseInt(size[1]);
                        }
                        if (!args[2].contains("*") && args[2].contains("x")) {
                            size = args[2].split("x");
                            width = Integer.parseInt(size[0]);
                            height = Integer.parseInt(size[1]);
                        }
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    throwInvalidArgument(I.t("измените размер так, чтобы он соответствовал формату <n m> or <nxm> or <n*m>."));
                    return;
                }
            }
            scaling = resizeMode();
        }
        if (width < 0 || height < 0) {
            throwInvalidArgument(I.t("Вам необходимо указать допустимый размер. например, изменить размер 4 на 5"));
            return;
        }
        try {
            ActionBar.sendPermanentMessage(player, ChatColor.DARK_GREEN + I.t("Визуализация..."));
            ImageRendererExecutor
                    .render(url, scaling, player.getUniqueId(), width, height, new WorkerCallback<ImageMap>() {
                        @Override
                        public void finished(ImageMap result) {
                            ActionBar.removeMessage(player);
                            MessageSender
                                    .sendActionBarMessage(player, ChatColor.DARK_GREEN + I.t("Рендеринг завершен!"));

                            if (result.give(player)
                                    && (result instanceof PosterMap && !((PosterMap) result).hasColumnData())) {
                                info(I.t("Отрисованная карта была слишком большой, чтобы поместиться в вашем инвентаре."));
                                info(I.t("Используйте '/maptool getremaining' чтобы получить оставшиеся карты."));
                            }
                        }

                        @Override
                        public void errored(Throwable exception) {
                            player.sendMessage(I.t("{ce}Сбой рендеринга карты: {0}", exception.getMessage()));

                            PluginLogger.warning("Сбой рендеринга из {0}: {1}: {2}",
                                    player.getName(),
                                    exception.getClass().getCanonicalName(),
                                    exception.getMessage());
                        }
                    });
        } finally {
            ActionBar.removeMessage(player);
        }
    }

    @Override
    public boolean canExecute(CommandSender sender) {
        return Permissions.NEW.grantedTo(sender);
    }
}
