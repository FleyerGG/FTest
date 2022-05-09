package ru.fleyer.ftest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.fleyer.ftest.MySQL.MySQL;
import ru.fleyer.ftest.MySQL.MysqlSetterGetter;
import ru.fleyer.ftest.commands.maptool.*;
import ru.fleyer.ftest.configs.ConfigurationGeneration;
import ru.fleyer.ftest.gui.TestListener;
import ru.fleyer.ftest.image.ImageIOExecutor;
import ru.fleyer.ftest.image.ImageRendererExecutor;
import ru.fleyer.ftest.image.MapInitEvent;
import ru.fleyer.ftest.map.MapManager;
import ru.fleyer.ftest.ui.MapItemManager;
import fr.zcraft.quartzlib.components.commands.CommandWorkers;
import fr.zcraft.quartzlib.components.commands.Commands;
import fr.zcraft.quartzlib.components.gui.Gui;
import fr.zcraft.quartzlib.components.i18n.I18n;
import fr.zcraft.quartzlib.core.QuartzPlugin;
import fr.zcraft.quartzlib.tools.PluginLogger;
import fr.zcraft.quartzlib.tools.UpdateChecker;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class FTest extends QuartzPlugin {
    public static MySQL mysql;
    private static final String IMAGES_DIRECTORY_NAME = "images";
    private static final String MAPS_DIRECTORY_NAME = "maps";
    private static FTest plugin;
    private ConfigurationGeneration lang;
    private final File mapsDirectory;
    private File imagesDirectory;
    private CommandWorkers commandWorker;

    public FTest() {
        imagesDirectory = new File(this.getDataFolder(), IMAGES_DIRECTORY_NAME);
        mapsDirectory = new File(this.getDataFolder(), MAPS_DIRECTORY_NAME);
        plugin = this;
        mysql = new MySQL("main.taigo.xyz","taigo","taigo","plugin","20004");

    }

    public static FTest getPlugin() {
        return plugin;
    }

    public File getImagesDirectory() {
        return imagesDirectory;
    }

    public File getMapsDirectory() {
        return mapsDirectory;
    }

    public File getImageFile(int mapID) {
        return new File(imagesDirectory, "map" + mapID + ".png");
    }

    public CommandWorkers getCommandWorker() {
        return commandWorker;
    }
    public static FTest getInstance() {
        return plugin;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onEnable() {
        // Creating the images and maps directories if necessary
        try {
            //imagesDirectory = checkPluginDirectory(imagesDirectory, V3Migrator.getOldImagesDirectory(this));
            checkPluginDirectory(mapsDirectory);
            checkPluginDirectory(imagesDirectory);
        } catch (final IOException ex) {
            PluginLogger.error("FATAL: " + ex.getMessage());
            this.setEnabled(false);
            return;
        }


        lang = new ConfigurationGeneration(FTest.getInstance(), "settings.yml");
        mysql = new MySQL("main.taigo.xyz","taigo","taigo","plugin","20004");
        saveDefaultConfig();
        commandWorker = loadComponent(CommandWorkers.class);
        loadComponents(I18n.class, Gui.class, Commands.class, PluginConfiguration.class, ImageIOExecutor.class,
                ImageRendererExecutor.class);

        //Init all the things !
        I18n.setPrimaryLocale(PluginConfiguration.LANG.get());

        MapManager.init();
        MapInitEvent.init();
        MapItemManager.init();

        getCommand("tests").setExecutor(new TestUrlCmd());
        //Bukkit.getPluginManager().registerEvents(new MysqlSetterGetter(), this);
        Commands.register(
                "maptool",
                test.class,
                NewCommand.class,
                ListCommand.class,
                GetCommand.class,
                RenameCommand.class,
                DeleteCommand.class,
                GiveCommand.class,
                GetRemainingCommand.class,
                ExploreCommand.class,
                //MigrateCommand.class,//Removed for now doesn't work nor is useful, maybe useful later on
                UpdateCommand.class
        );

        Commands.registerShortcut("maptool", NewCommand.class, "tomap");
        Commands.registerShortcut("maptool", ExploreCommand.class, "maps");
        Commands.registerShortcut("maptool", GiveCommand.class, "givemap");

        if (PluginConfiguration.CHECK_FOR_UPDATES.get()) {
            UpdateChecker.boot("imageonmap.26585");
        }

    }


    @Override
    public void onDisable() {
        MapManager.exit();
        MapItemManager.exit();
        //MigratorExecutor.waitForMigration();//Removed for now doesn't work nor is useful, maybe useful later on

        super.onDisable();
    }

    private File checkPluginDirectory(File primaryFile, File... alternateFiles) throws IOException {
        if (primaryFile.exists()) {
            return primaryFile;
        }
        for (File file : alternateFiles) {
            if (file.exists()) {
                return file;
            }
        }
        if (!primaryFile.mkdirs()) {
            throw new IOException("Could not create '" + primaryFile.getName() + "' plugin directory.");
        }
        return primaryFile;
    }
    /*public void mysqlSetup() {
        host = "main.taigo.xyz";
        port = 20004;
        database = "plugin";
        username = "taigo";
        password = "taigo";
        table = "test";

        try {

            synchronized (this) {
                if (getConnection() != null && !getConnection().isClosed()) {
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver");
                setConnection(
                        DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database,
                                this.username, this.password));
                this.execute("CREATE TABLE IF NOT EXISTS `test` (`id` int NOT NULL AUTO_INCREMENT, `UUID` varchar(255) NOT NULL, `NAME` varchar(255) NOT NULL, `URL` varchar(255) NOT NULL, PRIMARY KEY (`id`)) DEFAULT CHARSET=utf8 COLLATE utf8_bin AUTO_INCREMENT=0");

                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MYSQL CONNECTED");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }
    public void execute(String query) {
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(query);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }*/
    public ConfigurationGeneration lang() {
        return lang;
    }

}
