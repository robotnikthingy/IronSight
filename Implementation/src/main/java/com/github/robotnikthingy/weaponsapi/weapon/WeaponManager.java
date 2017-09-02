package com.github.robotnikthingy.weaponsapi.weapon;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.github.robotnikthingy.weaponsapi.WeaponsAPIPlugin;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Keeps track of and manages all weapons registered by the plugin
 * 
 * @author Robotnik
 * @since 8/9/2017
 */
public class WeaponManager {

    private final List<WeaponItem> weapons = new ArrayList<WeaponItem>();

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
     * Returns a WeaponItem from the manager if it exists. Will return null if the specified
     * weapon does not exist
     *
     * @param weaponName the name of the weapon as found in the configuration file
     * @return the resulting weapon. null if none exist
     */
    public WeaponItem getWeapon(String weaponName){
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
            
            // Try and find configuration section for the weapon
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            ConfigurationSection configSection = config.getDefaultSection();
            if (configSection == null) continue;
            
            for (String key : configSection.getKeys(false)) {
                // We found a weapon so lets add it
                weapons.add(new WeaponItem(key, file));
            }
        }
    }
    
}