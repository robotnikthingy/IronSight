package com.github.robotnikthingy.weaponsapi.mechanic.data;

import com.github.robotnikthingy.weaponsapi.mechanic.MechanicAction;
import com.github.robotnikthingy.weaponsapi.mechanic.MechanicRequirement;
import com.github.robotnikthingy.weaponsapi.player.IWeaponsPlayer;
import com.github.robotnikthingy.weaponsapi.weapon.Weapon;

/**
 * Represents an environment to be passed around mechanic-based methods within
 * {@link MechanicAction} and {@link MechanicRequirement} providing environmental
 * values based on the situation at hand
 * 
 * @author Parker Hawke - 2008Choco
 */
public final class MechanicEnvironment {
	
	private final IWeaponsPlayer player;
	private final Weapon weapon;
	
	/**
	 * Construct a new MechanicEnvironment given a Player and Weapon instance
	 * 
	 * @param player the player that participated in this situation
	 * @param weapon the weapon used in the situation
	 */
	public MechanicEnvironment(IWeaponsPlayer player, Weapon weapon) {
		this.player = player;
		this.weapon = weapon;
	}
	
	/**
	 * Get the participating {@link IWeaponsPlayer} in this environment
	 * 
	 * @return the participating player
	 */
	public IWeaponsPlayer getPlayer() {
		return player;
	}
	
	/**
	 * Get the participating (used) Weapon in this environment
	 * 
	 * @return the weapon used
	 */
	public Weapon getWeapon() {
		return weapon;
	}
	
}