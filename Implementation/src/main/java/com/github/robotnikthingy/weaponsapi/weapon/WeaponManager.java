package com.github.robotnikthingy.weaponsapi.weapon;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.github.robotnikthingy.weaponsapi.WeaponsAPIPlugin;
import com.google.common.collect.ImmutableSet;

/**
 * Keeps track of and manages all weapons registered by the plugin
 * 
 * @author Robotnik
 * @since 8/9/2017
 */
public class WeaponManager {

    private final Set<Weapon> weapons = new HashSet<>();

    public WeaponManager() {
    	this.loadWeapons(WeaponsAPIPlugin.FOLDER_WEAPONS);
    }

    /**
     * Reloads all weapons and their configurations
     */
    public void reloadWeapons(){
        this.weapons.clear();
        this.loadWeapons(WeaponsAPIPlugin.FOLDER_WEAPONS);
    }
    
    /**
     * Registers a weapon to the weapon registry
     * 
     * @param weapon the weapon to register
     */
    public void registerWeapon(Weapon weapon) {
    	this.weapons.add(weapon);
    }
    
    /**
     * Unregisters a weapon from the weapon registry
     * 
     * @param weapon the weapon to unregister
     */
    public void unregisterWeapon(Weapon weapon) {
    	this.weapons.remove(weapon);
    }

    /**
     * Returns a WeaponItem from the manager if it exists. Will return null if the specified
     * weapon does not exist
     *
     * @param weaponName the name of the weapon as found in the configuration file
     * @return the resulting weapon. null if none exist
     */
    public Weapon getWeapon(String weaponName){
    	return weapons.stream()
    		.filter(w -> w.getName().equals(weaponName))
    		.findFirst().orElse(null);
    }
    
    /**
     * Check whether a weapon exists and is registered to the weapon manager
     * 
     * @param weaponName the name of the weapon as found in the configuration file
     * @return true if the weapon exists, false otherwise
     */
    public boolean weaponExists(String weaponName) {
    	return weapons.stream().anyMatch(w -> w.getName().equals(weaponName));
    }
    
    /**
     * Get an immutable collection of all registered weapons
     * 
     * @return all registered weapons
     */
    public Collection<Weapon> getWeapons() {
		return ImmutableSet.copyOf(weapons);
	}
    
    /**
     * Clear all weapons from the registry
     */
    public void clearWeapons() {
    	this.weapons.clear();
    }
    
    /**
     * Scans through all files in a folder and its children. Adds any weapons found to the
     * weapons list defined within {@link WeaponManager}
     * 
     * @param directory the directory to load weapons from
     */
	private void loadWeapons(File directory) {
		for (File file : directory.listFiles()) {
			// Scan through subfolder for weapons if its a directory
			if (file.isDirectory()) {
				loadWeapons(file);
			}
			
			String extension = "";
			int i = file.getName().lastIndexOf('.');
			if (i > 0) {
				extension = file.getName().substring(i + 1);
			}
			
			// It's a config file
			if (!extension.equals("yml")) continue;
			
			weapons.add(new ConfigurableWeapon(file));
		}
	}
    
}