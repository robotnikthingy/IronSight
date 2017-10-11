package com.github.robotnikthingy.ironsight.api.weapon;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.github.robotnikthingy.ironsight.api.player.IronSightPlayer;

/**
 * Represents a weapon located at a given {@link Location} in a world.
 * This weapon is not meant to be associated with a Player until it is interacted
 * with (ex: a cannon, stationary machine gun, etc.). Some weapons will be
 * activated through redstone whereas others may require manual deployment, shooting
 * and reloading from a {@link Player}
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface WeaponHardpoint extends Weapon {
	
	/**
	 * Set the location and relocate the weapon
	 * 
	 * @param location the new location
	 */
	public void setLocation(Location location);
	
	/**
	 * Get the location in which this hardpoint is positioned
	 * 
	 * @return the current weapon position
	 */
	public Location getLocation();
	
	/**
	 * Set the user interacting with this weapon hardpoint
	 * 
	 * @param player the new interacting user. null to set no user
	 * @return true if successful. false otherwise
	 */
	public boolean setUser(IronSightPlayer player);
	
	/**
	 * Get the user interacting with this weapon hardpoint
	 * 
	 * @return the interacting player. null if no user
	 */
	public IronSightPlayer getUser();
	
	/**
	 * Check whether redstone should activate this weapon and invoke
	 * {@link #shoot(Player)}
	 * 
	 * @return true if redstone activation is permitted. false otherwise
	 */
	public boolean shouldRedstoneActivate();
	
}