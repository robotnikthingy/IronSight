package com.github.robotnikthingy.weaponsapi.bullet;

import com.github.robotnikthingy.weaponsapi.ammo.Ammunition;
import com.github.robotnikthingy.weaponsapi.weapon.Weapon;
import com.github.robotnikthingy.weaponsapi.weapon.state.Shootable;

import org.bukkit.entity.Player;

/**
 * Represents a moving bullet fired from a {@link Shootable} weapon
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface Bullet {
	
	/**
	 * Set the speed of the bullet
	 * 
	 * @param speed the new speed to set
	 */
	public void setSpeed(double speed);
	
	/**
	 * Get the current speed of the bullet
	 * 
	 * @return the speed of the bullet
	 */
	public double getSpeed();
	
	/**
	 * Check whether this bullet penetrates through entities and continues
	 * along its path once an entity has been intercepted
	 * 
	 * @return true if penetrates. false if stops after hitting entity
	 */
	public boolean penetrateEntities();
	
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
	
}