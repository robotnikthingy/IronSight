package com.github.robotnikthingy.ironsight.api.weapon;

import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;

/**
 * Represents a weapon as an item
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface WeaponItem extends WeaponReloadable {
	
	/**
	 * Get the selection-related mechanic data handler
	 * 
	 * @return the reload data handler
	 */
	public MechanicDataHandler getSelectionDataHandler();
	
}