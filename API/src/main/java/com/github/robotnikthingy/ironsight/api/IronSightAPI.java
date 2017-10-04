package com.github.robotnikthingy.ironsight.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.github.robotnikthingy.ironsight.api.ammo.Ammunition;
import com.github.robotnikthingy.ironsight.api.bullet.Bullet;
import com.github.robotnikthingy.ironsight.api.manager.WeaponManager;
import com.github.robotnikthingy.ironsight.api.mechanic.MechanicParser;
import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;
import com.github.robotnikthingy.ironsight.api.player.IronSightPlayer;
import com.github.robotnikthingy.ironsight.api.weapon.Weapon;

/**
 * Contains various methods to bridge common features between API and 
 * implementation including the WeaponManager, etc.
 * 
 * @author ysl3000
 */
public interface IronSightAPI {
	
	/**
	 * Get the plugin weapon manager. All weapons should be registered here
	 * in order to be handled by the plugin
	 * 
	 * @return the weapon manager
	 */
	public WeaponManager getWeaponManager();
	
	/**
	 * Get the mechanic parser used to parse mechanics from the weapon configuration
	 * files. Any custom mechanics should be registered here in order to be
	 * recognised by the plugin when parsing weapons and their options
	 * 
	 * @return the mechanic parser
	 */
	public MechanicParser getMechanicParser();
	
	/**
	 * Get a WeaponsPlayer instance given a Bukkit {@link Player}. If no WeaponsPlayer
	 * instance is associated with the player, a new instance will be created
	 * 
	 * @param player the player to retrieve an instance of
	 * @return the related WeaponsPlayer instance
	 */
	public IronSightPlayer getPlayer(Player player);
	
	/**
	 * Create a new instance of {@link MechanicDataHandler} for use in weapons, 
	 * ammunition or any other class that requires data handlers
	 * 
	 * @return a new data handler
	 */
	public MechanicDataHandler createMechanicDataHandler();
	
	/**
	 * Create a new Bullet and add it to the world
	 * 
	 * @param weapon the weapon to which this bullet originated
	 * @param ammunition the belonging ammunition
	 * @param shooter the player that shot the weapon
	 * @param location the location of the bullet
	 * @param initialVelocity the initial velocity of the bullet
	 */
	public Bullet createBullet(Weapon weapon, Ammunition ammunition, IronSightPlayer shooter, Location location, Vector initialVelocity);
	
	/**
	 * Create a new Bullet and add it to the world with a velocity of 0
	 * 
	 * @param weapon the weapon to which this bullet originated
	 * @param ammunition the belonging ammunition
	 * @param shooter the player that shot the weapon
	 * @param location the location of the bullet
	 */
	public Bullet createBullet(Weapon weapon, Ammunition ammunition, IronSightPlayer shooter, Location location);
	
}