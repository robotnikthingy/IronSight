package com.github.robotnikthingy.weaponsapi.action;

import com.github.robotnikthingy.weaponsapi.mechanic.MechanicType;

/**
 * Represents a requirement that must be conditionally met
 *
 * @author Robotnik
 * @since 9/7/2017
 */
public class MechanicRequirement extends AbstractMechanic {
	
	public MechanicRequirement(String name, String[] parameters) {
		super(MechanicType.REQUIREMENT, name, parameters);
	}
	
}