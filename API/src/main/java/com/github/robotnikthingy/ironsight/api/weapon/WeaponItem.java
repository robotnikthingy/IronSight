package com.github.robotnikthingy.ironsight.api.weapon;

import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;
import com.github.robotnikthingy.ironsight.api.weapon.state.Reloadable;
import com.github.robotnikthingy.ironsight.api.weapon.state.Shootable;

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
	public MechanicDataHandler getSelectionDataHandler();
	
}