package com.github.robotnikthingy.weaponsapi.weapon;

import com.github.robotnikthingy.weaponsapi.weapon.state.Reloadable;
import com.github.robotnikthingy.weaponsapi.weapon.state.Shootable;

import org.bukkit.inventory.ItemStack;

/**
 * Represents a weapon as an item
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface WeaponItem extends Weapon, Shootable, Reloadable {
	
	/**
	 * Get the item that represents this weapon
	 * 
	 * @return the associated item
	 */
	public ItemStack getItem();
	
}