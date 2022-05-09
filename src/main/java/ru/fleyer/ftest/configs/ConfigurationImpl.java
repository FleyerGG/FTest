package ru.fleyer.ftest.configs;

import org.bukkit.configuration.file.FileConfiguration;

public interface ConfigurationImpl {
    //public FileConfiguration yaml();
    public FileConfiguration msg();

    public FileConfiguration yamlLoad();

    public void save();

    public void reloadConfiguration();
}
