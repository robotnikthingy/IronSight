package com.github.robotnikthingy.ironsight.api;

import java.util.UUID;

import com.github.robotnikthingy.ironsight.api.ammo.Ammunition;
import com.github.robotnikthingy.ironsight.api.bullet.Bullet;
import com.github.robotnikthingy.ironsight.api.manager.WeaponManager;
import com.github.robotnikthingy.ironsight.api.mechanic.MechanicParser;
import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;
import com.github.robotnikthingy.ironsight.api.player.IronSightPlayer;
import com.github.robotnikthingy.ironsight.api.weapon.Weapon;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * The main class bridging the API and IronSight plugin implementation.
 * Most values retrieved from the API will be interfaces and implemented in the
 * plugin rather than being publicly accessible to developers. If access to the
 * implementation is required, a separate maven repository is available
 * <p>
 * <br><b>Group ID:</b> com.github.robotnikthingy
 * <br><b>Artifact ID (API):</b> IronSight
 * <br><b>Artifact ID (Implementation):</b> IronSightPlugin
 * 
 * @author ysl3000
 */
public class IronSight {

    private static IronSightAPI ironsightAPI;

    private IronSight() {}
    
    /**
     * Set the implementation to use for the IronSight API. This should be used
     * in implementation ONLY. Any attempt to invoke this method will result in
     * a runtime exception
     * 
     * @param ironsightAPI the new API implementation
     * 
     * @throws ExceptionInInitializerError if the API has already been set
     */
    public static void setAPI(IronSightAPI weaponsAPI) {
        if (IronSight.ironsightAPI != null)
            throw new ExceptionInInitializerError("API already initialized.");
        
        IronSight.ironsightAPI = weaponsAPI;
    }

    /**
     * Get the API compatibility layer bridging the API to the plugin
     * 
     * @return the API compatibility layer
     */
	public static IronSightAPI getAPI() {
		return ironsightAPI;
	}
	
	/**
	 * Get the plugin weapon manager. All weapons should be registered here in order
	 * to be handled by the plugin
	 * 
	 * @return the weapon manager
	 */
	public static WeaponManager getWeaponManager() {
		return ironsightAPI.getWeaponManager();
	}
	
	/**
	 * Get the mechanic parser used to parse mechanics from the weapon configuration 
	 * files. Any custom mechanics should be registered here in order to be recognised 
	 * by the plugin when parsing weapons and their options
	 * 
	 * @return the mechanic parser
	 */
	public static MechanicParser getMechanicParser() {
		return ironsightAPI.getMechanicParser();
	}
	
	/**
	 * Get a WeaponsPlayer instance given a Bukkit {@link Player}
	 * 
	 * @param player the player to retrieve an instance of
	 * @return the related WeaponsPlayer instance
	 */
	public static IronSightPlayer getPlayer(Player player) {
		return ironsightAPI.getPlayer(player);
	}
	
	/**
	 * Get a WeaponsPlayer instance given a Bukkit Player's UUID. If no WeaponsPlayer
	 * instance is associated with the (valid) player, a new instance will be created
	 * 
	 * @param player the UUID of the player to retrieve an instance of
	 * @return the related WeaponsPlayer instance
	 */
	public static IronSightPlayer getPlayer(UUID uuid) {
		Player player = Bukkit.getPlayer(uuid);
		return (player != null ? getPlayer(player) : null);
	}
	
	/**
	 * Create a new instance of {@link MechanicDataHandler} for use in weapons, 
	 * ammunition or any other class that requires data handlers
	 * 
	 * @return a new data handler
	 */
	public static MechanicDataHandler createMechanicDataHandler() {
		return ironsightAPI.createMechanicDataHandler();
	}
	
	/**
	 * Create a new Bullet and add it to the world
	 * 
	 * @param weapon the weapon to which this bullet originated
	 * @param ammunition the belonging ammunition
	 * @param shooter the player that shot the weapon
	 * @param location the location of the bullet
	 * @param initialVelocity the initial velocity of the bullet
	 */
	public static Bullet createBullet(Weapon weapon, Ammunition ammunition, IronSightPlayer shooter, Location location, Vector initialVelocity) {
		return ironsightAPI.createBullet(weapon, ammunition, shooter, location, initialVelocity);
	}
	
	/**
	 * Create a new Bullet and add it to the world with a velocity of 0
	 * 
	 * @param weapon the weapon to which this bullet originated
	 * @param ammunition the belonging ammunition
	 * @param shooter the player that shot the weapon
	 * @param location the location of the bullet
	 * @param initialVelocity the initial velocity of the bullet
	 */
	public static Bullet createBullet(Weapon weapon, Ammunition ammunition, IronSightPlayer shooter, Location location) {
		return ironsightAPI.createBullet(weapon, ammunition, shooter, location);
	}

}