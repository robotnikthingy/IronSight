package com.github.robotnikthingy.weaponsapi.api.mechanic;

/**
 * Represents the foundation of an action from which actions, requirements,
 * events and targets will inherit
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface Mechanic {
	
	/**
	 * Get the name of the mechanic as represented in the configuration file
	 * 
	 * @return the mechanic name
	 */
	public String getName();
	
	/**
	 * Get an array of parameters passed to the mechanic
	 * 
	 * @return the passed parameters
	 */
	public String[] getParameters();
	
	/**
	 * Get the type of mechanic represented by this object
	 * 
	 * @return the represented mechanic type
	 */
	public MechanicType getType();
	
}