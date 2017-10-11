package com.github.robotnikthingy.ironsight.weapon;

import org.bukkit.configuration.file.FileConfiguration;

import com.github.robotnikthingy.ironsight.api.weapon.Weapon;

/**
 * Represents a custom weapon capable of being loaded from a configuration file
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface CustomWeapon extends Weapon {
	
	/**
	 * Load any and all information from the configuration file
	 * 
	 * @param configFile the configuration file to load data from
	 */
	public void loadConfigurationOptions(FileConfiguration configFile);
	
}