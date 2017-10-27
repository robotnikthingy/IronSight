package com.github.robotnikthingy.ironsight.api.weapon;

import java.util.Collection;

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
	 * Get the item representation of this weapon if any. If no
	 * item representation exists, this method will simply return null
	 * 
	 * @return the representing item. null if none
	 */
	public ItemStack getItem();
	
	/**
	 * Set a new weapon loadout to be active on this weapon
	 * 
	 * @param loadout the new active loadout to set
	 * 
	 * @author Robotnik
	 */
	public void setLoadout(WeaponLoadout loadout);

	/**
	 * Get the current weapon loadout
	 *
	 * @return the active loadout. null if none
	 * 
	 * @author Robotnik
	 */
	public WeaponLoadout getLoadout();

	/**
	 * Get a collection of all weapon loadouts
	 *
	 * @return all weapon loadouts. Returned collection will be empty if no
	 * loadouts are available
	 * 
	 * @author Robotnik
	 */
	public Collection<WeaponLoadout> getLoadouts();
	
	/**
	 * Construct a new instance of this weapon implementation
	 * 
	 * @return a new instance of this class
	 */
	public Weapon newInstance();
	
}