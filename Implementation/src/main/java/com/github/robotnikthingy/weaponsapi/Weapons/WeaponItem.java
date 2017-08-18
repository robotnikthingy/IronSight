package com.github.robotnikthingy.weaponsapi.Weapons;

import com.github.robotnikthingy.weaponsapi.WeaponsAPIPlugin;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Created by Robotnik on 8/4/2017.
 * This represents a weapon and all its properties
 */
public class WeaponItem {

    public String Name;
    public String DisplayName;
    private FileConfiguration ParentConfig;
    private File ParentFile;
    private ConfigurationSection WeaponConfig;

    WeaponItem(String name, File file){
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
