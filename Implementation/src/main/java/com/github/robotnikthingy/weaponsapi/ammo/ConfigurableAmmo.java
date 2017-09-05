package com.github.robotnikthingy.weaponsapi.ammo;

import java.io.File;

import com.github.robotnikthingy.weaponsapi.utils.ConfigurableObject;
import com.github.robotnikthingy.weaponsapi.weapon.Weapon;

import org.bukkit.inventory.ItemStack;

/**
 * Represents a piece of ammunition created using configuration files
 * 
 * @author Parker Hawke - 2008Choco
 */
public class ConfigurableAmmo extends ConfigurableObject implements Ammunition {
	
    public ConfigurableAmmo(String name, File file){
    	super(name, file);
    }
    
    public void loadConfigurationOptions() {
    	// TODO: Load values from configuration file
    }
    
    @Override
    public String getName() {
    	return name;
    }

	@Override
	public boolean isUsableBy(Weapon weapon) {
		return false; // TODO: Usable by weapon
	}

	@Override
	public double getBulletSpeed() {
		return 0; // TODO: Bullet speed
	}

	@Override
	public ItemStack getItem() {
		return null; // TODO Create ammo item
	}
	
}