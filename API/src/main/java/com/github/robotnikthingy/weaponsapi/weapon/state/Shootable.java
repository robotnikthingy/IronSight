package com.github.robotnikthingy.weaponsapi.weapon.state;

import org.bukkit.entity.Player;

import com.github.robotnikthingy.weaponsapi.mechanic.data.IMechanicDataHandler;

/**
 * Represents a shootable weapon
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface Shootable {
	
	/**
	 * Get the shooting-related mechanic data handler
	 * 
	 * @return the shooting data handler
	 */
	public IMechanicDataHandler getShootingDataHandler();
	
	/**
	 * Shoot this weapon and create an ammunition entity
	 * 
	 * @param player the player that shot the weapon. Can be null
	 */
	public void shoot(Player player);
	
}