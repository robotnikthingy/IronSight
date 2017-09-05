package com.github.robotnikthingy.weaponsapi.projectile;

import java.io.File;

import com.github.robotnikthingy.weaponsapi.ammo.Ammunition;
import com.github.robotnikthingy.weaponsapi.utils.ConfigurableObject;
import com.github.robotnikthingy.weaponsapi.weapon.WeaponThrowable;

import org.bukkit.entity.Player;

/**
 * Represents a throwable projectile created using configuration files
 * 
 * @author Parker Hawke - 2008Choco
 */
public class ConfigurableProjectile extends ConfigurableObject implements WeaponThrowable {
	
	public ConfigurableProjectile(String name, File file) {
		super(name, file);
	}
	
	@Override
	public void loadConfigurationOptions() {
    	// TODO: Load values from configuration file
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getClipSize() {
		return 1;
	}

	@Override
	public int getMaxAmmo() {
		return 0; // TODO: Get maximum projectile count
	}

	@Override
	public int getAmmo() {
		return 0; // TODO: Get current ammo count
	}

	@Override
	public void reload(Player player, Ammunition ammo) {}

	@Override
	public int getFuse() {
		return 0; // TODO: Add fuse time
	}

	@Override
	public boolean activateOnImpact() {
		return false; // TODO Add impact result
	}

	@Override
	public void launch(Player player) {}
	
}