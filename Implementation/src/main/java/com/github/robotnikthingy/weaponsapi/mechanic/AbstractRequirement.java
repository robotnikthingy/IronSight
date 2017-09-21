package com.github.robotnikthingy.weaponsapi.mechanic;

import com.github.robotnikthingy.weaponsapi.api.mechanic.MechanicRequirement;
import com.github.robotnikthingy.weaponsapi.api.mechanic.MechanicType;

/**
 * Represents an abstract implementation of {@link MechanicRequirement} and 
 * {@link AbstractMechanic}
 * 
 * @author Parker Hawke - 2008Choco
 *
 * @param <T> the type of value to act as a predicate
 */
public abstract class AbstractRequirement extends AbstractMechanic implements MechanicRequirement {
	
	/**
	 * Construct a new AbstractRequirement given a name and its parameters
	 * 
	 * @param name the name of the mechanic
	 * @param parameters the mechanic parameters
	 */
	public AbstractRequirement(String name, String[] parameters) {
		super(MechanicType.REQUIREMENT, name, parameters);
	}
	
}