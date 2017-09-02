package com.github.robotnikthingy.weaponsapi.weapon;

import java.io.File;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Represents a weapon and its item properties
 * 
 * @author Robotnik
 * @since 8/4/2017
 */
public class WeaponItem {

    private final String name;
    private String displayName;
    
    private FileConfiguration parentConfig;
    private File parentFile; // TODO: Unused
    private ConfigurationSection weaponConfig; // TODO: Unused

    /**
     * Construct a new WeaponItem object
     * 
     * @param name the name of the weapon
     * @param file the configuration file representing this item
     */
    public WeaponItem(String name, File file) {
        this.name = name;
        
        this.parentFile = file;
        this.parentConfig = YamlConfiguration.loadConfiguration(file);
        this.weaponConfig = parentConfig.getConfigurationSection(name);
        
        this.loadConfigOptions();
    }

    public void loadConfigOptions() {
    	// TODO: Stub
    }

    /**
     * Get the name of the weapon
     * 
     * @return the weapon's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the name to be displayed for this weapon
     * 
     * @return the weapon display name
     */
    public String getDisplayName() {
		return displayName;
	}
    
}