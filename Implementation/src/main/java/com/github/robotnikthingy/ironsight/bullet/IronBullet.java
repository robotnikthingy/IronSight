package com.github.robotnikthingy.ironsight.bullet;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import com.github.robotnikthingy.ironsight.api.ammo.Ammunition;
import com.github.robotnikthingy.ironsight.api.bullet.Bullet;
import com.github.robotnikthingy.ironsight.api.player.IronSightPlayer;
import com.github.robotnikthingy.ironsight.api.weapon.Weapon;

/**
 * Represents an implementation of {@link Bullet}
 * 
 * @author Parker Hawke - 2008Choco
 */
public class IronBullet implements Bullet {
	
	private boolean valid = true;
	
	private Location location;
	private Vector velocity;
	
	private final Weapon weapon;
	private final Ammunition ammunition;
	private final IronSightPlayer shooter;
	
	/**
	 * Construct a new IronBullet given the weapon it was shot from, the
	 * related ammunition and the player that shot the weapon
	 * 
	 * @param weapon the weapon to which this bullet originated
	 * @param ammunition the belonging ammunition
	 * @param shooter the player that shot the weapon
	 * @param location the location of the bullet
	 * @param initialVelocity the initial velocity of the bullet
	 */
	public IronBullet(Weapon weapon, Ammunition ammunition, IronSightPlayer shooter, Location location, Vector initialVelocity) {
		this.weapon = weapon;
		this.ammunition = ammunition;
		this.shooter = shooter;
		this.location = location;
		this.velocity = initialVelocity;
	}
	
	/**
	 * Construct a new IronBullet given the weapon it was shot from, the
	 * related ammunition and the player that shot the weapon, and apply
	 * a velocity of zero
	 * 
	 * @param weapon the weapon to which this bullet originated
	 * @param ammunition the belonging ammunition
	 * @param shooter the player that shot the weapon
	 * @param location the location of the bullet
	 */
	public IronBullet(Weapon weapon, Ammunition ammunition, IronSightPlayer shooter, Location location) {
		this(weapon, ammunition, shooter, location, new Vector());
	}

	@Override
	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	@Override
	public Vector getVelocity() {
		return velocity;
	}
	
	@Override
	public double getSpeed() {
		return valid ? getVelocity().length() : 0.0;
	}
	
	@Override
	public void setLocation(Location location) {
		this.location = location;
	}
	
	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public boolean penetratesEntities() {
		return false;
	}

	@Override
	public Ammunition getBelongingAmmo() {
		return ammunition;
	}

	@Override
	public Weapon getBelongingWeapon() {
		return weapon;
	}

	@Override
	public IronSightPlayer getShooter() {
		return shooter;
	}

	@Override
	public boolean isValid() {
		return valid;
	}
	
}