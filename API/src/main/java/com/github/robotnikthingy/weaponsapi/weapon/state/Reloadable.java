package com.github.robotnikthingy.weaponsapi.weapon.state;

import com.github.robotnikthingy.weaponsapi.ammo.Ammunition;
import com.github.robotnikthingy.weaponsapi.mechanic.data.IMechanicDataHandler;

import org.bukkit.entity.Player;

/**
 * Represents a reloadable weapon with a limited amount of ammunition
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface Reloadable {
	
	/**
	 * Get the amount of ammunition that can be held in a clip
	 * 
	 * @return the clip size
	 */
	public int getClipSize();
	
	/**
	 * Get the maximum amount of ammunition capable of being held
	 * by a player whilst this weapon is in use
	 * 
	 * @return the maximum ammunition
	 */
	public int getMaxAmmo();
	
	/**
	 * Get the current amount of ammunition loaded into the weapon,
	 * ready to shoot
	 * 
	 * @return the amount of loaded ammunition
	 */
	public int getAmmo();
	
	/**
	 * Get the reload-related mechanic data handler
	 * 
	 * @return the reload data handler
	 */
	public IMechanicDataHandler getReloadDataHandler();
	
	/**
	 * Reload this weapon's ammunition clip
	 * 
	 * @param player the player that initiated the reload. Can be null
	 * @param ammo the ammunition used to reload this weapon
	 */
	public void reload(Player player, Ammunition ammo);
	
}