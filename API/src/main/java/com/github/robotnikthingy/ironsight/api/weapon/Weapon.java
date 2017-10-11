package com.github.robotnikthingy.ironsight.api.weapon;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;

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
	
	/**
	 * Get the shooting-related mechanic data handler
	 * 
	 * @return the shooting data handler
	 */
	public MechanicDataHandler getShootingDataHandler();
	
	/**
	 * Shoot this weapon and create an entity representing its bullet
	 * or respective type of ammunition
	 * 
	 * @param player the player that shot the weapon. Can be null
	 */
	public void shoot(Player player);
	
	/**
	 * Construct a new instance of this weapon implementation
	 * 
	 * @return a new instance of this class
	 */
	public Weapon newInstance();
	
}