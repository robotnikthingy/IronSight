package com.github.robotnikthingy.ironsight.api.weapon;

/**
 * Represents a weapon capable of being thrown as a projectile.
 * ex: Grenade, Molotov, etc.
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface WeaponThrowable extends WeaponReloadable {
	
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
	
}