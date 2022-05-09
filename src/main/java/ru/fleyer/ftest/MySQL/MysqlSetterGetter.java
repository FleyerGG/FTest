package ru.fleyer.ftest.MySQL;

import com.google.common.collect.Maps;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.fleyer.ftest.FTest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

public class MysqlSetterGetter {



    static FTest plugin = FTest.getInstance();

    /*@EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        createPlayer(player.getUniqueId(), player,"https://sun9-38.userapi.com/s/v1/if2/oMPTUyI2Enjx5pYFCn_26ybpiJ9gM7V_BqEBEIuK6xL7lxKxr4IVOyR417QI6FvUGbr_GmL_GyDTDsagigtD1hka.jpg?size=500x500&quality=95&type=album");
    }

    @EventHandler
    public void hit(PlayerInteractEvent event) {
        updateCoins(event.getPlayer().getUniqueId());
       getUrl(event.getPlayer().getUniqueId());
    }*/
    public static boolean playerExists(UUID uuid) {
        try {
            PreparedStatement statement = FTest.mysql.getConnection()
                    .prepareStatement("SELECT * FROM `test` WHERE UUID=?");
            statement.setString(1, uuid.toString());

            ResultSet results = statement.executeQuery();
            if (results.next()) {
                plugin.getServer().broadcastMessage(ChatColor.YELLOW + "Player Found");
                return true;
            }
            plugin.getServer().broadcastMessage(ChatColor.RED + "Player NOT Found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void createPlayer(final UUID uuid, Player player, String url, String picture) {
        try {
            PreparedStatement statement = FTest.mysql.getConnection()
                    .prepareStatement("SELECT * FROM `test` WHERE UUID=?");
            statement.setString(1, uuid.toString());
            ResultSet results = statement.executeQuery();
            results.next();
            System.out.print(1);
            if (playerExists(uuid) == false) {
                PreparedStatement insert = FTest.mysql.getConnection()
                        .prepareStatement("INSERT INTO `test` (UUID,NAME,URL,PICTURES) VALUES (?,?,?,?)");
                insert.setString(1, uuid.toString());
                insert.setString(2, player.getName());
                insert.setString(3, url);
                insert.setString(4, picture);
                insert.executeUpdate();

                plugin.getServer().broadcastMessage(ChatColor.GREEN + "Player Inserted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public static void updateCoins(UUID uuid) {
        try {
            PreparedStatement statement = FTest.mysql.getConnection()
                    .prepareStatement("UPDATE `test` SET URL=? WHERE UUID=?");
            statement.setString(1, "https://sun9-38.userapi.com/s/v1/if2/oMPTUyI2Enjx5pYFCn_26ybpiJ9gM7V_BqEBEIuK6xL7lxKxr4IVOyR417QI6FvUGbr_GmL_GyDTDsagigtD1hka.jpg?size=500x500&quality=95&type=album");
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/


    public static List<String> getURL(UUID uuid, String picture){
        List<String> urllist = new ArrayList<>();
        String hystory = "SELECT * FROM test WHERE UUID = '"+ uuid + "' OR PICTURES = '" + picture + "';";

        try {
            PreparedStatement statement = FTest.mysql.getConnection().prepareStatement(hystory);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                urllist.add(resultSet.getString("URL"));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return urllist;
    }

}
