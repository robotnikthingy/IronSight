package com.github.robotnikthingy.weaponsapi.manager;

import java.util.Collection;

import com.github.robotnikthingy.weaponsapi.weapon.Weapon;

/**
 * Keeps track of and manages all weapons registered by the plugin
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface IWeaponManager {
	
    /**
     * Reloads all weapons and their configurations
     */
	public void reloadWeapons();
	
    /**
     * Registers a weapon to the weapon registry
     * 
     * @param weapon the weapon to register
     */
	public void registerWeapon(Weapon weapon);
	
    /**
     * Unregisters a weapon from the weapon registry
     * 
     * @param weapon the weapon to unregister
     */
	public void unregisterWeapon(Weapon weapon);
	
    /**
     * Returns a WeaponItem from the manager if it exists. Will return null if the specified
     * weapon does not exist
     *
     * @param weaponName the name of the weapon as found in the configuration file
     * @return the resulting weapon. null if none exist
     */
	public Weapon getWeapon(String weaponName);
	
    /**
     * Check whether a weapon exists and is registered to the weapon manager
     * 
     * @param weaponName the name of the weapon as found in the configuration file
     * @return true if the weapon exists, false otherwise
     */
	public boolean weaponExists(String weaponName);
	
    /**
     * Get an immutable collection of all registered weapons
     * 
     * @return all registered weapons
     */
	public Collection<Weapon> getWeapons();
	
    /**
     * Clear all weapons from the registry
     */
	public void clearWeapons();
	
}