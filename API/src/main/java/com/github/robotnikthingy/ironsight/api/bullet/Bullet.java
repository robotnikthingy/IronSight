package com.github.robotnikthingy.ironsight.api.bullet;

import com.github.robotnikthingy.ironsight.api.ammo.Ammunition;
import com.github.robotnikthingy.ironsight.api.weapon.Weapon;
import com.github.robotnikthingy.ironsight.api.weapon.state.Shootable;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Represents a moving bullet fired from a {@link Shootable} weapon
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
	public Player getShooter();
	
	/**
	 * Check whether this bullet entity is still valid. A valid bullet
	 * state indicates that it is still a moving entity. Upon hitting an
	 * entity or a wall, the bullet is no longer considered valid
	 * 
	 * @return the validity of the bullet
	 */
	public boolean isValid();
	
	/**
	 * Get the speed of this bullet. The speed is equal to the magnitude
	 * of the bullet's velocity {@link Vector#length()}
	 * 
	 * @return the speed of the bullet
	 */
	public default double getSpeed() {
		if (!isValid()) return -0.0;
		return getVelocity().length();
	}
	
}