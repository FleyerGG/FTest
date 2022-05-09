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
import ru.fleyer.ftest.map.ImageMap;
import ru.fleyer.ftest.map.MapManager;
import fr.zcraft.quartzlib.components.commands.CommandException;
import fr.zcraft.quartzlib.components.commands.CommandInfo;
import fr.zcraft.quartzlib.components.i18n.I;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


@CommandInfo(name = "give", usageParameters = "<player name> [playerFrom]:<map name>")
public class GiveCommand extends IoMCommand {

    @Override
    protected void run() throws CommandException {

        if (args.length < 2) {
            throwInvalidArgument(I.t("You must give a valid player name and a map name."));
            return;
        }

        ArrayList<String> arguments = getArgs();

        if (arguments.size() > 3) {
            throwInvalidArgument(I.t("Too many parameters!"));
            return;
        }
        if (arguments.size() < 1) {
            throwInvalidArgument(I.t("Too few parameters!"));
            return;
        }
        final String mapName;
        final String from;
        final String playerName;
        final Player playerSender;
        Player playerSender1;
        try {
            playerSender1 = playerSender();
        } catch (CommandException ignored) {
            if (arguments.size() == 2) {
                throwInvalidArgument(I.t("Player name is required from the console"));
            }
            playerSender1 = null;
        }
        playerSender = playerSender1;
        if (arguments.size() == 2) {
            from = playerSender.getName();
            playerName = arguments.get(0);
            mapName = arguments.get(1);
        } else {
            if (arguments.size() == 3) {
                from = arguments.get(1);
                playerName = arguments.get(0);
                mapName = arguments.get(2);
            } else {
                from = "";
                playerName = "";
                mapName = "";
            }
        }

        final Player sender = playerSender();

        retrieveUUID(from, uuid -> {
            final ImageMap map = MapManager.getMap(uuid, mapName);

            if (map == null) {
                warning(sender, I.t("This map does not exist."));
                return;
            }

            retrieveUUID(playerName, uuid2 -> {
                if (Bukkit.getPlayer((uuid2)) != null && Bukkit.getPlayer((uuid2)).isOnline()
                        && map.give(Bukkit.getPlayer(uuid2))) {
                    info(I.t("The requested map was too big to fit in your inventory."));
                    info(I.t("Use '/maptool getremaining' to get the remaining maps."));
                }
            });
        });

    }

    @Override
    public boolean canExecute(CommandSender sender) {
        return Permissions.GIVE.grantedTo(sender);
    }
}
