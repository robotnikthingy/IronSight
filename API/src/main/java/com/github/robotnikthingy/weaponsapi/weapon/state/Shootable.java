package com.github.robotnikthingy.weaponsapi.weapon.state;

import org.bukkit.entity.Player;

/**
 * Represents a shootable weapon
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface Shootable {
	
	/**
	 * Shoot this weapon and create an ammunition entity
	 * 
	 * @param player the player that shot the weapon. Can be null
	 */
	public void shoot(Player player);
	
}