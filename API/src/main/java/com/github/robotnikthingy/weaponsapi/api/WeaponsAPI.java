package com.github.robotnikthingy.weaponsapi.api;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.github.robotnikthingy.weaponsapi.api.manager.IWeaponManager;
import com.github.robotnikthingy.weaponsapi.api.mechanic.IMechanicParser;
import com.github.robotnikthingy.weaponsapi.api.player.IWeaponsPlayer;

/**
 * The main class bridging the API and WeaponsAPI plugin implementation.
 * Most values retrieved from the API will be interfaces and implemented in the
 * plugin rather than being publicly accessible to developers. If access to the
 * implementation is required, a separate maven repository is available
 * <p>
 * <br><b>Group ID:</b> com.github.robotnikthingy
 * <br><b>Artifact ID (API):</b> WeaponsAPI
 * <br><b>Artifact ID (Implementation):</b> WeaponsPlugin
 * 
 * @author ysl3000
 */
public class WeaponsAPI {

    private static IWeaponsAPI weaponsAPI;

    private WeaponsAPI() {}
    
    /**
     * Set the implementation to use for the Weapons API. This should be used
     * in implementation ONLY. Any attempt to invoke this method will result in
     * a runtime exception
     * 
     * @param weaponsAPI the new API implementation
     * 
     * @throws ExceptionInInitializerError if the API has already been set
     */
    public static void setAPI(IWeaponsAPI weaponsAPI) {
        if (WeaponsAPI.weaponsAPI != null)
            throw new ExceptionInInitializerError("API already initialized.");
        
        WeaponsAPI.weaponsAPI = weaponsAPI;
    }

    /**
     * Get the API compatibility layer bridging the API to the plugin
     * 
     * @return the API compatibility layer
     */
	public static IWeaponsAPI getAPI() {
		return weaponsAPI;
	}
	
	/**
	 * Get the plugin weapon manager. All weapons should be registered here in order
	 * to be handled by the plugin
	 * 
	 * @return the weapon manager
	 */
	public static IWeaponManager getWeaponManager() {
		return weaponsAPI.getWeaponManager();
	}
	
	/**
	 * Get the mechanic parser used to parse mechanics from the weapon configuration 
	 * files. Any custom mechanics should be registered here in order to be recognised 
	 * by the plugin when parsing weapons and their options
	 * 
	 * @return the mechanic parser
	 */
	public static IMechanicParser getMechanicParser() {
		return weaponsAPI.getMechanicParser();
	}
	
	/**
	 * Get a WeaponsPlayer instance given a Bukkit {@link Player}
	 * 
	 * @param player the player to retrieve an instance of
	 * @return the related WeaponsPlayer instance
	 */
	public static IWeaponsPlayer getPlayer(Player player) {
		return weaponsAPI.getPlayer(player);
	}
	
	/**
	 * Get a WeaponsPlayer instance given a Bukkit Player's UUID. If no WeaponsPlayer
	 * instance is associated with the (valid) player, a new instance will be created
	 * 
	 * @param player the UUID of the player to retrieve an instance of
	 * @return the related WeaponsPlayer instance
	 */
	public static IWeaponsPlayer getPlayer(UUID uuid) {
		Player player = Bukkit.getPlayer(uuid);
		return (player != null ? getPlayer(player) : null);
	}

}