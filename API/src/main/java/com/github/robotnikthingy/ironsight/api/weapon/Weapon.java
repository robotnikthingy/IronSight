package com.github.robotnikthingy.ironsight.api.weapon;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;

import java.util.ArrayList;

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
	 * Get the current weapon loadout
	 *
	 * @return the representing loadout. null if none
	 */
	public WeaponLoadout getLoadout();

	/**
	 * Get an ArrayList of all weapon loadouts, if the weapon has more than one
	 *
	 * @return ArrayList of all weapon loadouts. empty ArrayList if none.
	 */
	public ArrayList<WeaponLoadout> getLoadoutOuts();
	
	/**
	 * Construct a new instance of this weapon implementation
	 * 
	 * @return a new instance of this class
	 */
	public Weapon newInstance();
	
}