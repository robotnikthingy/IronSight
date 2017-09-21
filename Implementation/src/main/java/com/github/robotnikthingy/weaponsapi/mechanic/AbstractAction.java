package com.github.robotnikthingy.weaponsapi.mechanic;

import com.github.robotnikthingy.weaponsapi.api.mechanic.MechanicAction;
import com.github.robotnikthingy.weaponsapi.api.mechanic.MechanicType;

/**
 * Represents an abstract implementation of {@link MechanicAction} and 
 * {@link AbstractMechanic}
 * 
 * @author Parker Hawke - 2008Choco
 */
public abstract class AbstractAction extends AbstractMechanic implements MechanicAction {
	
	/**
	 * Construct a new AbstractAction given a name and its parameters
	 * 
	 * @param name the name of the mechanic
	 * @param parameters the mechanic parameters
	 */
	public AbstractAction(String name, String[] parameters) {
		super(MechanicType.ACTION, name, parameters);
	}
	
}