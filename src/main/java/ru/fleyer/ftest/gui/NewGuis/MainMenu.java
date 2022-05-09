package ru.fleyer.ftest.gui.NewGuis;

import com.rainchat.raingui.menus.ClickItem;
import com.rainchat.raingui.menus.PaginationMenu;
import com.rainchat.raingui.utils.general.Item;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import ru.fleyer.ftest.FTest;

import java.util.ArrayList;
import java.util.List;


public class MainMenu {




    public static void onMainMenu(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.main.nameGui"), settings.getInt("GUI.main.size"));

        int page = paginationMenu.getPage();
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.main.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.main.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture1.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture1.material"))).name(settings.getString("GUI.main.list.picture1.name")).lore(settings.getStringList("GUI.main.list.picture1.lore")), event -> { PlayerMapsGui.Picture1(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture2.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture2.material"))).name(settings.getString("GUI.main.list.picture2.name")).lore(settings.getStringList("GUI.main.list.picture2.lore")), event -> { PlayerMapsGui.Picture2(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture3.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture3.material"))).name(settings.getString("GUI.main.list.picture3.name")).lore(settings.getStringList("GUI.main.list.picture3.lore")), event -> { PlayerMapsGui.Picture3(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture4.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture4.material"))).name(settings.getString("GUI.main.list.picture4.name")).lore(settings.getStringList("GUI.main.list.picture4.lore")), event -> { PlayerMapsGui.Picture4(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture5.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture5.material"))).name(settings.getString("GUI.main.list.picture5.name")).lore(settings.getStringList("GUI.main.list.picture5.lore")), event -> { PlayerMapsGui.Picture5(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture6.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture6.material"))).name(settings.getString("GUI.main.list.picture6.name")).lore(settings.getStringList("GUI.main.list.picture6.lore")), event -> { PlayerMapsGui.Picture6(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture7.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture7.material"))).name(settings.getString("GUI.main.list.picture7.name")).lore(settings.getStringList("GUI.main.list.picture7.lore")), event -> { PlayerMapsGui.Picture7(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture8.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture8.material"))).name(settings.getString("GUI.main.list.picture8.name")).lore(settings.getStringList("GUI.main.list.picture8.lore")), event -> { PlayerMapsGui.Picture8(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture9.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture9.material"))).name(settings.getString("GUI.main.list.picture9.name")).lore(settings.getStringList("GUI.main.list.picture9.lore")), event -> { PlayerMapsGui.Picture9(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture10.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture10.material"))).name(settings.getString("GUI.main.list.picture10.name")).lore(settings.getStringList("GUI.main.list.picture10.lore")), event -> { PlayerMapsGui.Picture10(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture11.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture11.material"))).name(settings.getString("GUI.main.list.picture11.name")).lore(settings.getStringList("GUI.main.list.picture11.lore")), event -> { PlayerMapsGui.Picture11(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture12.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture12.material"))).name(settings.getString("GUI.main.list.picture12.name")).lore(settings.getStringList("GUI.main.list.picture12.lore")), event -> { PlayerMapsGui.Picture12(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture13.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture13.material"))).name(settings.getString("GUI.main.list.picture13.name")).lore(settings.getStringList("GUI.main.list.picture13.lore")), event -> { PlayerMapsGui.Picture13(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture14.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture14.material"))).name(settings.getString("GUI.main.list.picture14.name")).lore(settings.getStringList("GUI.main.list.picture14.lore")), event -> { PlayerMapsGui.Picture14(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture15.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture15.material"))).name(settings.getString("GUI.main.list.picture15.name")).lore(settings.getStringList("GUI.main.list.picture15.lore")), event -> { PlayerMapsGui.Picture15(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture16.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture16.material"))).name(settings.getString("GUI.main.list.picture16.name")).lore(settings.getStringList("GUI.main.list.picture16.lore")), event -> { PlayerMapsGui.Picture16(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture17.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture17.material"))).name(settings.getString("GUI.main.list.picture17.name")).lore(settings.getStringList("GUI.main.list.picture17.lore")), event -> { PlayerMapsGui.Picture17(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture18.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture18.material"))).name(settings.getString("GUI.main.list.picture18.name")).lore(settings.getStringList("GUI.main.list.picture18.lore")), event -> { PlayerMapsGui.Picture18(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture19.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture19.material"))).name(settings.getString("GUI.main.list.picture19.name")).lore(settings.getStringList("GUI.main.list.picture19.lore")), event -> { PlayerMapsGui.Picture19(uuid); }));
        paginationMenu.setItem(settings.getInt("GUI.main.list.picture20.slot"), new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list.picture20.material"))).name(settings.getString("GUI.main.list.picture20.name")).lore(settings.getStringList("GUI.main.list.picture20.lore")), event -> { PlayerMapsGui.Picture20(uuid); }));


        /*for (String s : settings.getConfigurationSection("GUI.main.list").getKeys(false)){

                ClickItem clickItem = new ClickItem(new Item().material(Material.valueOf(settings.getString("GUI.main.list." + s + ".material")))
                        .name(settings.getString("GUI.main.list." + s + ".name"))
                        .lore(settings.getStringList("GUI.main.list." + s + ".lore")), event -> {
                    //PlayerMapsGui.Picture1(uuid);
                    settings.get("test");


                    if (paginationMenu.getItem(13).getItemStack().getItemMeta().hasDisplayName() && settings.getBoolean("GUI.main.list." + s + ".enable")) {
                        PlayerMapsGui.Picture2(uuid);
                    }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + ".enable") && paginationMenu.getItem(10)){ PlayerMapsGui.Picture1(uuid); }else return;
                   //if (settings.getBoolean("GUI.main.list." + s + ".enable2")){ PlayerMapsGui.Picture2(uuid); }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + "enable")){ PlayerMapsGui.Picture3(uuid); }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + "enable")){ PlayerMapsGui.Picture4(uuid); }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + "enable")){ PlayerMapsGui.Picture5(uuid); }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + "enable")){ PlayerMapsGui.Picture6(uuid); }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + "enable")){ PlayerMapsGui.Picture7(uuid); }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + "enable"){ PlayerMapsGui.Picture8(uuid); }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + "enable")){ PlayerMapsGui.Picture9(uuid); }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + "enable")){ PlayerMapsGui.Picture10(uuid); }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + "enable")){ PlayerMapsGui.Picture11(uuid); }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + "enable")){ PlayerMapsGui.Picture12(uuid); }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + "enable")){ PlayerMapsGui.Picture13(uuid); }else return;
                    //if (settings.getBoolean("GUI.main.list." + s + "enable")){ PlayerMapsGui.Picture14(uuid); }else return;


                    //settings.getString("test");

                });

                paginationMenu.setItem(settings.getInt("GUI.main.list." + s + ".slot"),clickItem);

        }

        paginationMenu.setItems(clickItems);*/
        paginationMenu.open(uuid);
    }


}
