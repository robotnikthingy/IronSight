package com.github.robotnikthingy.weaponsapi.manager;

import java.util.Collection;
import java.util.Iterator;

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
     * Returns a Weapon from the manager if it exists. Will return null if the specified
     * weapon does not exist
     *
     * @param weaponName the name of the weapon as found in the configuration file
     * @return the resulting weapon. null if none exist
     */
	public Weapon getWeapon(String weaponName);
	
	/**
	 * Returns a Weapon from the manager if it exists. Will return null if the specified
	 * class does not exist or has not yet been registered
	 * 
	 * @param weapon the resulting weapon. null if none exist
	 */
	public <T extends Weapon> T getWeapon(Class<T> weapon);
	
    /**
     * Check whether a weapon exists and is registered to the weapon manager
     * 
     * @param weaponName the name of the weapon as found in the configuration file
     * @return true if the weapon is registered, false otherwise
     */
	public boolean isRegisteredWeapon(String weaponName);
	
	/**
	 * Check whether a weapon exists and is registered to the weapon manager
	 * 
	 * @param weapon the weapon's class
	 * @return true if the weapon is registered, false otherwise
	 */
	public <T extends Weapon> boolean isRegisteredWeapon(Class<T> weapon);
	
    /**
     * Get an immutable collection of all registered weapons
     * 
     * @return all registered weapons
     */
	public Collection<Weapon> getWeapons();
	
	/**
	 * Get an instance of Iterator to iterate over all registered weapons
	 * 
	 * @return an iterator for all registered weapons
	 */
	public Iterator<Weapon> weaponIterator();
	
    /**
     * Clear all weapons from the registry
     */
	public void clearWeapons();
	
}