package com.github.robotnikthingy.weaponsapi;

import com.github.robotnikthingy.weaponsapi.manager.IWeaponManager;
import com.github.robotnikthingy.weaponsapi.mechanic.IMechanicParser;
import com.github.robotnikthingy.weaponsapi.player.WeaponsPlayer;

import org.bukkit.entity.Player;

/**
 * Contains various methods to bridge common features between API and 
 * implementation including the WeaponManager, etc.
 * 
 * @author ysl3000
 */
public interface IWeaponsAPI {
	
	/**
	 * Get the plugin weapon manager. All weapons should be registered here
	 * in order to be handled by the plugin
	 * 
	 * @return the weapon manager
	 */
	public IWeaponManager getWeaponManager();
	
	/**
	 * Get the mechanic parser used to parse mechanics from the weapon configuration
	 * files. Any custom mechanics should be registered here in order to be
	 * recognised by the plugin when parsing weapons and their options
	 * 
	 * @return the mechanic parser
	 */
	public IMechanicParser getMechanicParser();
	
	/**
	 * Get a WeaponsPlayer instance given a Bukkit {@link Player}
	 * 
	 * @param player the player to retrieve an instance of
	 * @return the related WeaponsPlayer instance
	 */
	public WeaponsPlayer getPlayer(Player player);
	
}