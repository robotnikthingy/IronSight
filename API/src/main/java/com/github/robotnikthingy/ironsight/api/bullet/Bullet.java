package com.github.robotnikthingy.ironsight.api.bullet;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import com.github.robotnikthingy.ironsight.api.ammo.Ammunition;
import com.github.robotnikthingy.ironsight.api.player.IronSightPlayer;
import com.github.robotnikthingy.ironsight.api.weapon.Weapon;

/**
 * Represents a moving bullet fired from a {@link Weapon}
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface Bullet {
	
	/**
	 * Set the velocity for this bullet. Bullet velocity will be applied
	 * instantaneously such that it's still valid
	 * 
	 * @param velocity the new bullet velocity
	 */
	public void setVelocity(Vector velocity);
	
	/**
	 * Get the bullet's current velocity
	 * 
	 * @return the bullet velocity
	 */
	public Vector getVelocity();
	
	/**
	 * Get the speed of this bullet. The speed is equal to the magnitude
	 * of the bullet's velocity {@link Vector#length()}
	 * 
	 * @return the speed of the bullet
	 */
	public double getSpeed();
	
	/**
	 * Set the location of this bullet
	 * 
	 * @param location the bullet location
	 */
	public void setLocation(Location location);
	
	/**
	 * Get the location of this bullet
	 * 
	 * @return the current bullet location
	 */
	public Location getLocation();
	
	/**
	 * Check whether this bullet penetrates through entities and continues
	 * along its path once an entity has been intercepted
	 * 
	 * @return true if penetrates. false if stops after hitting entity
	 */
	public boolean penetratesEntities();
	
	/**
	 * Get the ammunition representing this bullet
	 * 
	 * @return the bullet's ammunition
	 */
	public Ammunition getBelongingAmmo();
	
	/**
	 * Get the weapon that shot this bullet
	 * 
	 * @return the shooting weapon
	 */
	public Weapon getBelongingWeapon();
	
	/**
	 * Get the player that shot this bullet
	 * 
	 * @return the shooter. Can be null
	 */
	public IronSightPlayer getShooter();
	
	/**
	 * Check whether this bullet entity is still valid. A valid bullet
	 * state indicates that it is still a moving entity. Upon hitting an
	 * entity or a wall, the bullet is no longer considered valid
	 * 
	 * @return the validity of the bullet
	 */
	public boolean isValid();
	
}