package ru.fleyer.ftest.gui.NewGuis;

import com.rainchat.raingui.menus.ClickItem;
import com.rainchat.raingui.menus.PaginationMenu;
import com.rainchat.raingui.utils.general.Item;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.fleyer.ftest.FTest;
import ru.fleyer.ftest.MySQL.MysqlSetterGetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerMapsGui {
    private MysqlSetterGetter mysqlSetterGetter;




    public static void Picture1(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture1.nameGui"), settings.getInt("GUI.picture1.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture1.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture1.nextPage.name"))
                .lore(settings.getStringList("GUI.picture1.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture1.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture1.backPage.name"))
                .lore(settings.getStringList("GUI.picture1.backPage.lore"
                                .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));

        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture1.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture1.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#1")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture1.display.name")).lore(settings.getStringList("GUI.picture1.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#1.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#1.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#1.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#1.lore")));

                uuid.sendMessage(settings.getString("GUI.picture1.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }


    public static void Picture2(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture2.nameGui"), settings.getInt("GUI.picture2.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture2.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture2.nextPage.name"))
                .lore(settings.getStringList("GUI.picture2.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture2.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture2.backPage.name"))
                .lore(settings.getStringList("GUI.picture2.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture2.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture2.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#2")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture2.display.name")).lore(settings.getStringList("GUI.picture2.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#2.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#2.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#2.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#2.lore")));

                uuid.sendMessage(settings.getString("GUI.picture2.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture3(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture3.nameGui"), settings.getInt("GUI.picture3.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture3.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture3.nextPage.name"))
                .lore(settings.getStringList("GUI.picture3.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture3.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture3.backPage.name"))
                .lore(settings.getStringList("GUI.picture3.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture3.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture3.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#3")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture3.display.name")).lore(settings.getStringList("GUI.picture3.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#3.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#3.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#3.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#3.lore")));

                uuid.sendMessage(settings.getString("GUI.picture3.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture4(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture4.nameGui"), settings.getInt("GUI.picture4.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture4.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture4.nextPage.name"))
                .lore(settings.getStringList("GUI.picture4.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture4.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture4.backPage.name"))
                .lore(settings.getStringList("GUI.picture4.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture4.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture4.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#4")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture4.display.name")).lore(settings.getStringList("GUI.picture4.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#4.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#4.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#4.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#4.lore")));

                uuid.sendMessage(settings.getString("GUI.picture4.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture5(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture5.nameGui"), settings.getInt("GUI.picture5.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture5.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture5.nextPage.name"))
                .lore(settings.getStringList("GUI.picture5.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture5.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture5.backPage.name"))
                .lore(settings.getStringList("GUI.picture5.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture5.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture5.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#5")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture5.display.name")).lore(settings.getStringList("GUI.picture5.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#5.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#5.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#5.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#5.lore")));

                uuid.sendMessage(settings.getString("GUI.picture5.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture6(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture6.nameGui"), settings.getInt("GUI.picture6.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture6.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture6.nextPage.name"))
                .lore(settings.getStringList("GUI.picture6.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture6.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture6.backPage.name"))
                .lore(settings.getStringList("GUI.picture6.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture6.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture6.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#6")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture6.display.name")).lore(settings.getStringList("GUI.picture6.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#6.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#6.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#6.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#6.lore")));

                uuid.sendMessage(settings.getString("GUI.picture6.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture7(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture7.nameGui"), settings.getInt("GUI.picture7.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture7.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture7.nextPage.name"))
                .lore(settings.getStringList("GUI.picture.nextPage7.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture7.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture7.backPage.name"))
                .lore(settings.getStringList("GUI.picture7.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture7.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture7.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#7")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture7.display.name")).lore(settings.getStringList("GUI.picture7.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#7.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#7.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#7.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#7.lore")));

                uuid.sendMessage(settings.getString("GUI.picture7.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture8(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture8.nameGui"), settings.getInt("GUI.picture8.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture8.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture8.nextPage.name"))
                .lore(settings.getStringList("GUI.picture8.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture8.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture8.backPage.name"))
                .lore(settings.getStringList("GUI.picture8.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture8.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture8.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#8")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture8.display.name")).lore(settings.getStringList("GUI.picture8.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#8.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#8.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#8.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#8.lore")));

                uuid.sendMessage(settings.getString("GUI.picture8.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture9(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture9.nameGui"), settings.getInt("GUI.picture9.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture9.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture9.nextPage.name"))
                .lore(settings.getStringList("GUI.picture9.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture9.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture9.backPage.name"))
                .lore(settings.getStringList("GUI.picture9.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture9.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture9.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#9")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture9.display.name")).lore(settings.getStringList("GUI.picture9.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#9.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#9.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#9.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#9.lore")));

                uuid.sendMessage(settings.getString("GUI.picture9.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture10(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture10.nameGui"), settings.getInt("GUI.picture10.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture10.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture10.nextPage.name"))
                .lore(settings.getStringList("GUI.picture.nextPage10.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture10.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture10.backPage.name"))
                .lore(settings.getStringList("GUI.picture10.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture10.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture10.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#10")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture10.display.name")).lore(settings.getStringList("GUI.picture10.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#10.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#10.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#10.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#10.lore")));

                uuid.sendMessage(settings.getString("GUI.picture10.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture11(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture11.nameGui"), settings.getInt("GUI.picture11.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture11.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture11.nextPage.name"))
                .lore(Arrays.asList("%page% dd".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));
        paginationMenu.setItem(settings.getInt("GUI.picture11.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture11.backPage.name"))
                .lore(settings.getStringList("GUI.picture11.backPage.lore"

                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture11.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture11.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#11")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture11.display.name"))
                    .lore(settings.getStringList("GUI.picture11.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#11.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#11.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#11.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#11.lore")));

                uuid.sendMessage(settings.getString("GUI.picture11.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture12(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture12.nameGui"), settings.getInt("GUI.picture12.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture12.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture12.nextPage.name"))
                .lore(settings.getStringList("GUI.picture12.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture12.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture12.backPage.name"))
                .lore(settings.getStringList("GUI.picture12.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture12.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture12.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#12")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture12.display.name")).lore(settings.getStringList("GUI.picture12.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#12.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#12.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#12.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#12.lore")));

                uuid.sendMessage(settings.getString("GUI.picture12.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture13(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture13.nameGui"), settings.getInt("GUI.picture13.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture13.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture13.nextPage.name"))
                .lore(settings.getStringList("GUI.picture13.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture13.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture13.backPage.name"))
                .lore(settings.getStringList("GUI.picture13.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture13.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture13.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#13")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture13.display.name")).lore(settings.getStringList("GUI.picture13.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#13.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#13.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#13.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#13.lore")));

                uuid.sendMessage(settings.getString("GUI.picture13.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture14(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture14.nameGui"), settings.getInt("GUI.picture14.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture14.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture14.nextPage.name"))
                .lore(settings.getStringList("GUI.picture14.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture14.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture14.backPage.name"))
                .lore(settings.getStringList("GUI.picture14.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture14.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture14.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#14")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture14.display.name")).lore(settings.getStringList("GUI.picture14.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#14.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#14.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#14.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#14.lore")));

                uuid.sendMessage(settings.getString("GUI.picture14.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture15(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture15.nameGui"), settings.getInt("GUI.picture15.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture15.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture15.nextPage.name"))
                .lore(settings.getStringList("GUI.picture15.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture15.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture15.backPage.name"))
                .lore(settings.getStringList("GUI.picture15.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture15.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture15.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#15")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture15.display.name")).lore(settings.getStringList("GUI.picture15.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#15.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#15.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#15.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#15.lore")));

                uuid.sendMessage(settings.getString("GUI.picture15.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture16(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture16.nameGui"), settings.getInt("GUI.picture16.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture16.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture16.nextPage.name"))
                .lore(settings.getStringList("GUI.picture16.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture16.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture16.backPage.name"))
                .lore(settings.getStringList("GUI.picture16.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture16.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture16.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#16")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture16.display.name")).lore(settings.getStringList("GUI.picture16.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#16.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#16.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#16.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#16.lore")));

                uuid.sendMessage(settings.getString("GUI.picture16.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture17(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture17.nameGui"), settings.getInt("GUI.picture17.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture17.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture17.nextPage.name"))
                .lore(settings.getStringList("GUI.picture17.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture17.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture17.backPage.name"))
                .lore(settings.getStringList("GUI.picture17.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture17.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture17.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#17")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture17.display.name")).lore(settings.getStringList("GUI.picture17.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#17.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#17.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#17.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#17.lore")));

                uuid.sendMessage(settings.getString("GUI.picture17.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture18(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture18.nameGui"), settings.getInt("GUI.picture18.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture18.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture18.nextPage.name"))
                .lore(settings.getStringList("GUI.picture18.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture18.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture18.backPage.name"))
                .lore(settings.getStringList("GUI.picture18.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture18.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture18.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#18")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture18.display.name")).lore(settings.getStringList("GUI.picture18.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#18.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#18.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#18.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#18.lore")));

                uuid.sendMessage(settings.getString("GUI.picture18.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture19(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture19.nameGui"), settings.getInt("GUI.picture19.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture19.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture19.nextPage.name"))
                .lore(settings.getStringList("GUI.picture19.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture19.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture19.backPage.name"))
                .lore(settings.getStringList("GUI.picture19.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture19.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture19.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#19")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture19.display.name")).lore(settings.getStringList("GUI.picture19.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#19.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#19.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#19.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#19.lore")));

                uuid.sendMessage(settings.getString("GUI.picture19.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }
    public static void Picture20(Player uuid){
        Configuration settings = FTest.getInstance().lang().msg();
        PaginationMenu paginationMenu = new PaginationMenu(FTest.getInstance(), settings.getString("GUI.picture20.nameGui"), settings.getInt("GUI.picture20.size"));

        int page = paginationMenu.getPage();


        paginationMenu.setItem(settings.getInt("GUI.picture20.nextPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture20.nextPage.name"))
                .lore(settings.getStringList("GUI.picture20.nextPage.lore".replace("%page%", String.valueOf(page + 2))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() + 1);
        }));

        paginationMenu.setItem(settings.getInt("GUI.picture20.backPage.slot"), new ClickItem(new Item().material(Material.ARROW).name(settings.getString("GUI.picture20.backPage.name"))
                .lore(settings.getStringList("GUI.picture20.backPage.lore"
                        .replace("%page%", String.valueOf(page + 1))
                )), event -> {
            paginationMenu.setPage(paginationMenu.getPage() - 1);
        }));
        paginationMenu.setItemSlots(settings.getIntegerList("GUI.picture20.fillSlots"));

        paginationMenu.guiFill(new ClickItem(new Item()
                .material(Material.valueOf(settings.getString("GUI.picture20.fillSlotsMaterial"))), inventoryClickEvent -> {
        }));

        List<ClickItem> clickItems = new ArrayList<>();
        for (String maps : MysqlSetterGetter.getURL(uuid.getUniqueId(),"picture#20")){


            ClickItem clickItem = new ClickItem(new Item().material(Material.FILLED_MAP).name(settings.getString("GUI.picture20.display.name")).lore(settings.getStringList("GUI.picture20.display.lore"))
                    , event -> {
                uuid.sendMessage(maps);
                uuid.getInventory().addItem(buildItem(Material.valueOf(FTest.getInstance().lang().msg().getString("getMaterials.picture#20.material")),1,FTest.getInstance().lang().msg().getInt("getMaterials.picture#20.amount"),FTest.getInstance().lang().msg().getString("getMaterials.picture#20.name"), FTest.getInstance().lang().msg().getStringList("getMaterials.picture#20.lore")));

                uuid.sendMessage(settings.getString("GUI.picture20.doneMsg"));
                Bukkit.dispatchCommand(uuid,"tomap " + maps);
            });
            clickItems.add(clickItem);

        }
        paginationMenu.setItems(clickItems);
        paginationMenu.open(uuid);
    }












    public static ItemStack buildItem(Material material, int data, int amount, String name, List<String> lore) {
        ItemStack stack = new ItemStack(material, amount, ((byte)data));
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        if (lore != null) {
            List<String> aslist = new ArrayList<>();
            for (String str : lore) {
                aslist.add(ChatColor.translateAlternateColorCodes('&', str));
            }

            meta.setLore(aslist);
        }

        stack.setItemMeta(meta);
        return stack;
    }



}
