package com.github.robotnikthingy.ironsight.api.weapon;

import com.github.robotnikthingy.ironsight.api.weapon.state.Reloadable;

import org.bukkit.entity.Player;

/**
 * Represents a weapon capable of being thrown as a projectile.
 * ex: Grenade, Molotov, etc.
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface WeaponThrowable extends Weapon, Reloadable {
	
	/**
	 * Get the fuse time for this throwable weapon
	 * 
	 * @return the fuse time. -1 if no fuse
	 */
	public int getFuse();
	
	/**
	 * Check whether this weapon should explode or activate on impact
	 * with a wall, entity or the ground
	 * 
	 * @return true if activate on impact. false otherwise
	 */
	public boolean activateOnImpact();
	
	/**
	 * Launch this weapon and create a throwable entity
	 * 
	 * @param player the player that threw the weapon
	 */
	public void launch(Player player); // "throw" is a keyword. #FeelsBadMan
	
}