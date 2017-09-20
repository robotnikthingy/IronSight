package com.github.robotnikthingy.weaponsapi.manager;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.github.robotnikthingy.weaponsapi.WeaponsPlugin;
import com.github.robotnikthingy.weaponsapi.manager.IWeaponManager;
import com.github.robotnikthingy.weaponsapi.weapon.ConfigurableWeapon;
import com.github.robotnikthingy.weaponsapi.weapon.Weapon;
import com.google.common.collect.ImmutableSet;

import org.apache.commons.lang.Validate;

/**
 * Keeps track of and manages all weapons registered by the plugin
 * 
 * @author Robotnik
 * @since 8/9/2017
 */
public class WeaponManager implements IWeaponManager {

    private final Set<Weapon> weapons = new HashSet<>();

    public WeaponManager() {
    	this.loadWeapons(WeaponsPlugin.FOLDER_WEAPONS);
    }

    @Override
    public void reloadWeapons() {
        this.weapons.clear();
        this.loadWeapons(WeaponsPlugin.FOLDER_WEAPONS);
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
     * weapons list defined within {@link IWeaponManager}
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