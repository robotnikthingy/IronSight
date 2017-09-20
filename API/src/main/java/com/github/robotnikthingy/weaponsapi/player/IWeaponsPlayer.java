package com.github.robotnikthingy.weaponsapi.player;

import com.github.robotnikthingy.weaponsapi.ammo.Ammunition;
import com.github.robotnikthingy.weaponsapi.hitbox.Hitbox;
import com.github.robotnikthingy.weaponsapi.weapon.Weapon;
import com.github.robotnikthingy.weaponsapi.weapon.WeaponHardpoint;

import org.bukkit.entity.Player;

/**
 * Represents a player capable of carrying weapons and being stationed at
 * a weapon hardpoint
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface IWeaponsPlayer {
	
	/**
	 * Get the underlying Bukkit {@link Player} representing this WeaponsPlayer
	 * 
	 * @return the Bukkit Player representation
	 */
	public Player getBukkitPlayer();
	
	/**
	 * Set the hardpoint at which this player should be stationed. Note
	 * that this method may not function if specific conditions are not met,
	 * in which case this method will return false
	 * 
	 * @param weapon the new hardpoint
	 * @return true if successful. false otherwise
	 */
	public boolean setActiveHardpoint(WeaponHardpoint hardpoint);
	
	/**
	 * Get the hardpoint at which this player is current stationed. If the
	 * player is not stationed at a hardpoint, this method will return null
	 * 
	 * @return the stationed hardpoint. null if none
	 */
	public WeaponHardpoint getActiveHardpoint();
	
	/**
	 * Get the amount of remaining ammunition in the player's inventory
	 * for the specified weapon
	 * 
	 * @param weapon the weapon to check ammunition for
	 * @return the remaining amount of ammunition
	 */
	public int getRemainingAmmunition(Weapon weapon);
	
	/**
	 * Get the amount of remaining ammunition in the player's inventory
	 * for the specified ammunition
	 * 
	 * @param ammunition the ammunition to check
	 * @return the remaining amount of ammunition
	 */
	public int getRemainingAmmunition(Ammunition ammunition);
	
	/**
	 * Check whether this player has the provided weapon in their inventory
	 * 
	 * @param weapon the weapon to check for
	 * @return true if the weapon is present. false otherwise
	 */
	public boolean hasWeapon(Weapon weapon);
	
	/**
	 * Get the hitbox that surrounds this player. The hitbox returned from
	 * this method will be a snapshot of the hitbox as of its invocation.
	 * 
	 * @return a snapshot of the player hitbox
	 */
	public Hitbox getHitbox();
	
	/**
	 * Forcible call an update this player's hitbox. This method should not 
	 * be called frequently as the hitbox updating will be handled internally
	 */
	public void updateHitbox();
	
}