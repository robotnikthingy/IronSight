package com.github.robotnikthingy.ironsight.manager;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.bukkit.configuration.file.YamlConfiguration;

import com.github.robotnikthingy.ironsight.IronSightPlugin;
import com.github.robotnikthingy.ironsight.api.manager.WeaponManager;
import com.github.robotnikthingy.ironsight.api.weapon.Weapon;
import com.github.robotnikthingy.ironsight.weapon.CustomWeapon;
import com.github.robotnikthingy.ironsight.weapon.CustomWeaponHardpoint;
import com.github.robotnikthingy.ironsight.weapon.CustomWeaponItem;
import com.github.robotnikthingy.ironsight.weapon.CustomWeaponThrowable;
import com.google.common.collect.ImmutableSet;

/**
 * Keeps track of and manages all weapons registered by the plugin
 * 
 * @author Robotnik
 * @since 8/9/2017
 */
public class IronWeaponManager implements WeaponManager {

    private final Set<Weapon> weapons = new HashSet<>();

    public IronWeaponManager() {
    	this.reloadWeapons();
    }

    @Override
    public void reloadWeapons() {
        this.weapons.clear();
        this.loadWeapons(IronSightPlugin.FOLDER_WEAPONS);
        this.loadWeapons(IronSightPlugin.FOLDER_HARDPOINTS);
        this.loadWeapons(IronSightPlugin.FOLDER_PROJECTILES);
    }
    
    @Override
    public void registerWeapon(Weapon weapon) {
    	if (weapon == null) return;
    	Validate.isTrue(!weapons.contains(weapon), "Cannot register identical weapons");
    	
    	this.weapons.add(weapon);
    }
    
    @Override
    public void unregisterWeapon(Weapon weapon) {
    	this.weapons.remove(weapon);
    }

    @Override
    public Weapon getWeapon(String weaponName) {
    	return weapons.stream()
    		.filter(w -> w.getName().equals(weaponName))
    		.findFirst().orElse(null);
    }
    
    @Override
    public <T extends Weapon> T getWeapon(Class<T> weapon) {
    	return (weapon != null 
    			? weapon.cast(weapons.stream()
    					.filter(w -> weapon.isInstance(w))
    					.findFirst().orElse(null)) 
    			: null);
    }
    
    @Override
    public boolean isRegisteredWeapon(String weaponName) {
    	return weapons.stream().anyMatch(w -> w.getName().equals(weaponName));
    }
    
    @Override
    public <T extends Weapon> boolean isRegisteredWeapon(Class<T> weapon) {
    	return (weapon != null ? weapons.stream().anyMatch(weapon::isInstance) : null);
    }
    
    @Override
    public Collection<Weapon> getWeapons() {
		return ImmutableSet.copyOf(weapons);
	}
    
    @Override
    public Iterator<Weapon> weaponIterator() {
    	return weapons.iterator();
    }
    
    @Override
    public void clearWeapons() {
    	this.weapons.clear();
    }
    
    /**
     * Scans through all files in a folder and its children. Adds any weapons found to the
     * weapons list defined within {@link WeaponManager}
     * 
     * @param parentDirectory the parent directory. Generally the same as the directory param
     * @param directory the directory to load weapons from
     */
	private void loadWeapons(File parentDirectory, File directory) {
		for (File file : directory.listFiles()) {
			// Scan through subfolder for weapons if its a directory
			if (file.isDirectory()) {
				this.loadWeapons(parentDirectory, file);
			}
			
			String extension = "";
			int i = file.getName().lastIndexOf('.');
			if (i > 0) {
				extension = file.getName().substring(i + 1);
			}
			
			// It's a config file
			if (!extension.equals("yml")) continue;
			
			CustomWeapon weapon = null;
			if (parentDirectory == IronSightPlugin.FOLDER_WEAPONS) weapon = new CustomWeaponItem();
			else if (parentDirectory == IronSightPlugin.FOLDER_HARDPOINTS) weapon = new CustomWeaponHardpoint();
			else if (parentDirectory == IronSightPlugin.FOLDER_PROJECTILES) weapon = new CustomWeaponThrowable();
			else break;
			
			weapon.loadConfigurationOptions(YamlConfiguration.loadConfiguration(file));
			this.weapons.add(weapon);
		}
	}
	
    /**
     * Scans through all files in a folder and its children. Adds any weapons found to the
     * weapons list defined within {@link WeaponManager}
     * 
     * @param directory the directory to load weapons from
     */
	private void loadWeapons(File directory) {
		this.loadWeapons(directory, directory);
	}
    
}