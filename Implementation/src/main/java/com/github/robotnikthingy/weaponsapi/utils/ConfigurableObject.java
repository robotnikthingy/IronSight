package com.github.robotnikthingy.weaponsapi.utils;

import java.io.File;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public abstract class ConfigurableObject {
	
    protected final FileConfiguration parentConfig;
	protected final File parentFile;
	protected final ConfigurationSection weaponConfig;
    
    protected final String name;

    public ConfigurableObject(String name, File file) {
    	this.name = name;
        this.parentFile = file;
        this.parentConfig = YamlConfiguration.loadConfiguration(file);
        this.weaponConfig = parentConfig.getConfigurationSection(name);
        
        this.loadConfigurationOptions();
    }
    
    public abstract void loadConfigurationOptions();
	
}