package com.github.robotnikthingy.weaponsapi.mechanic;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Represents the foundation of an action from which actions, requirements,
 * events and targets will inherit
 * 
 * @author Robotnik
 */
public abstract class AbstractMechanic implements Mechanic {

	// This can likely be simplified... Matches "name(parameter)", "name(parameter, parameter)", and so on and so forth
	public static final Pattern MECHANIC_PATTERN = Pattern.compile("(\\w+)(?:\\((\\s*(?:\\w+)*(?:,(?:\\s*\\w+))*\\s*)\\))");

	protected String name;
	protected MechanicType type;
	protected String[] parameters;

	/**
	 * Construct a new AbstractMechanic given a type, name and parameters
	 * 
	 * @param type the type of mechanic
	 * @param name the mechanic name as represented in the configuration file
	 * @param parameters the parameters passed
	 */
	public AbstractMechanic(MechanicType type, String name, String[] parameters) {
		this.type = type;
		this.name = name;
		this.parameters = parameters;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String[] getParameters() {
		return Arrays.copyOf(parameters, parameters.length);
	}

	@Override
	public MechanicType getType() {
		return type;
	}

}