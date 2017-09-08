package com.github.robotnikthingy.weaponsapi.utils;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Represents a configuration file-based object with a name, as well
 * as a parent config file to modify its behaviour
 * 
 * @author Parker Hawke - 2008Choco
 */
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
    
    /**
     * Load any required configuration options into memory
     */
    public abstract void loadConfigurationOptions();
	
}