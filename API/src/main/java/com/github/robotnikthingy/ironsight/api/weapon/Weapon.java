package com.github.robotnikthingy.ironsight.api.weapon;

import org.bukkit.inventory.ItemStack;

/**
 * Represents a basic weapon without any state
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface Weapon {
	
	/**
	 * Get the name of this weapon
	 * 
	 * @return the weapon name
	 */
	public String getName();
	
	/**
	 * Get the amount of damage that this weapon will inflict
	 * 
	 * @return the weapon damage
	 */
	public double getDamage();
	
	/**
	 * Get the item representation of this weapon if any. If no
	 * item representation exists, this method will simply return null
	 * 
	 * @return the representing item. null if none
	 */
	public ItemStack getItem();
	
}