package ru.fleyer.ftest.commands.maptool;

import fr.zcraft.quartzlib.components.commands.CommandException;
import fr.zcraft.quartzlib.components.worker.WorkerCallback;
import fr.zcraft.quartzlib.tools.text.ActionBar;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.fleyer.ftest.MySQL.MysqlSetterGetter;
import ru.fleyer.ftest.image.ImageRendererExecutor;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestUrlCmd implements CommandExecutor {
    private MysqlSetterGetter setterGetter;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String arg, @NotNull String[] args) {
        URL url;
        int width = 0;
        int height = 0;
        if (sender instanceof Player){
            try {
                url = new URL(args[0]);



            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {


            } finally {
                ActionBar.removeMessage((Player) sender);
            }






            //String s = setterGetter.getUrl(((Player) sender).getUniqueId());
            //sender.sendMessage(s);

            if (cmd.getName().equalsIgnoreCase("tests")){

                // /tests NICK URL

                if (args.length != 3){
                    List<String> ss = setterGetter.getURL(((Player) sender).getUniqueId(),"picture#1");
                    //ArrayList<String> s = setterGetter.getUrl(((Player) sender).getUniqueId());
                    sender.sendMessage("аргументов нема" + ss);

                }else{
                    Player p = Bukkit.getPlayerExact(args[0]);
                    UUID uuid = p.getUniqueId();
                    setterGetter.createPlayer(uuid,p,args[1],"picture#1");
                }
            }else return false;


        }else sender.sendMessage("Your not player");

        return false;
    }
}
