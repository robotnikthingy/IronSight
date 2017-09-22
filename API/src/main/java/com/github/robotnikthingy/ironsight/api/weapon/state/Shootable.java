package com.github.robotnikthingy.ironsight.api.weapon.state;

import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;

import org.bukkit.entity.Player;

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
	public MechanicDataHandler getShootingDataHandler();
	
	/**
	 * Shoot this weapon and create an ammunition entity
	 * 
	 * @param player the player that shot the weapon. Can be null
	 */
	public void shoot(Player player);
	
}