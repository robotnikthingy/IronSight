package com.github.robotnikthingy.weaponsapi.utils;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public abstract class ConfigurableObject {
	
	protected final File parentFile;
    protected final FileConfiguration parentConfig;
    
	protected final String name;

    public ConfigurableObject(File file) {
        this.parentFile = file;
        this.parentConfig = YamlConfiguration.loadConfiguration(file);
        this.name = file.getName().substring(0, file.getName().lastIndexOf('.'));
        
        this.loadConfigurationOptions();
    }
    
    public abstract void loadConfigurationOptions();
	
}