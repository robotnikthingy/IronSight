package com.github.robotnikthingy.ironsight.api.mechanic;

/**
 * Represents all types of mechanics including actions, requirements, etc.
 * 
 * @author Robotnik
 */
public enum MechanicType {
	
	/**
	 * Represents an executable action
	 */
	ACTION,
	
	/**
	 * Represents a condition that must be met before an action may be 
	 * executed
	 */
	REQUIREMENT;
	
}