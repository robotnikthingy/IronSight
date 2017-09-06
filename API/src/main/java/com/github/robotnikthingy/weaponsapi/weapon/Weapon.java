package com.github.robotnikthingy.weaponsapi.weapon;

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
	
}