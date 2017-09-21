package com.github.robotnikthingy.weaponsapi.weapon;

import java.io.File;

import com.github.robotnikthingy.weaponsapi.api.ammo.Ammunition;
import com.github.robotnikthingy.weaponsapi.api.mechanic.data.IMechanicDataHandler;
import com.github.robotnikthingy.weaponsapi.api.weapon.WeaponThrowable;
import com.github.robotnikthingy.weaponsapi.utils.ConfigurableObject;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Represents a throwable projectile created using configuration files
 * 
 * @author Parker Hawke - 2008Choco
 */
public class ConfigurableProjectile extends ConfigurableObject implements WeaponThrowable {
	
	public ConfigurableProjectile(File file) {
		super(file);
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
	public double getDamage() {
		return 0; // TODO Configurable damage values
	}
	
	@Override
	public ItemStack getItem() {
		return null; // TODO: Representing ItemStack
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
	public IMechanicDataHandler getReloadDataHandler() {
		return null; // TODO: Return a data handler implementation
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