package com.github.robotnikthingy.weaponsapi.weapon;

import com.github.robotnikthingy.weaponsapi.mechanic.data.IMechanicDataHandler;
import com.github.robotnikthingy.weaponsapi.weapon.state.Reloadable;
import com.github.robotnikthingy.weaponsapi.weapon.state.Shootable;

/**
 * Represents a weapon as an item
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface WeaponItem extends Weapon, Shootable, Reloadable {
	
	/**
	 * Get the selection-related mechanic data handler
	 * 
	 * @return the reload data handler
	 */
	public IMechanicDataHandler getSelectionDataHandler();
	
}