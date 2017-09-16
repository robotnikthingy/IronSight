package com.github.robotnikthingy.weaponsapi.mechanic;

import com.github.robotnikthingy.weaponsapi.mechanic.data.MechanicEnvironment;

/**
 * Represents a type of mechanic capabale of being executed at any given
 * time such that its execution method is invoked
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface MechanicAction extends Mechanic {
	
	/**
	 * Call this mechanic action and invoke required methods
	 * 
	 * @param environment the environment as of this method call. Cannot be null
	 */
	public void call(MechanicEnvironment environment);
	
	@Override
	public default MechanicType getType() {
		return MechanicType.ACTION;
	}
	
}