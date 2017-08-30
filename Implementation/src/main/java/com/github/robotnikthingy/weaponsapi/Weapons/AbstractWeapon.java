package com.github.robotnikthingy.weaponsapi.Weapons;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Base class for a weapon
 */
public class AbstractWeapon {

    private String Name;
    private FileConfiguration ParentConfig;
    private File ParentFile;
    private ConfigurationSection WeaponConfig;

    AbstractWeapon(String name, File file){
        Name = name;
        ParentFile = file;
        ParentConfig = YamlConfiguration.loadConfiguration(file);
        WeaponConfig = ParentConfig.getConfigurationSection(name);
        LoadConfigOptions();
    }

    public void LoadConfigOptions(){

    }

    public String getName(){
        return Name;
    }
}
