package com.github.robotnikthingy.weaponsapi.action;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Represents the foundation of an action from which actions, requirements 
 * and target actions will inherit
 * 
 * @author Robotnik
 */
public abstract class AbstractMechanic {
	
	// This can likely be simplified... Matches "name(parameter)", "name(parameter, parameter)", and so on and so forth
	public static final Pattern MECHANIC_PATTERN = Pattern.compile("(\\w+)(?:\\((\\s*(?:\\w+)*(?:,(?:\\s*\\w+))*\\s*)\\))");
	
	private final String name;
	private final MechanicType type;
	private final String[] parameters;

	/**
	 * Construct a new AbstractMechanic given a type, name and parameters
	 * 
	 * @param type the type of mechanic
	 * @param name the mechanic name as represented in the configuration file
	 * @param parameters the parameters passed
	 */
    public AbstractMechanic(MechanicType type, String name, String[] parameters){
    	this.type = type;
    	this.name = name;
    	this.parameters = parameters;
    }
    
    /**
     * Get the name of this mechanic
     * 
     * @return the mechanic name
     */
    public String getName() {
		return name;
	}
    
    /**
     * Get the type of mechanic represented by this object
     * 
     * @return the represented mechanic type
     */
    public MechanicType getType() {
		return type;
	}
    
    /**
     * Get an array of parameters passed to the abstract mechanic
     * 
     * @return the mechanic parameters
     */
    public String[] getParameters() {
		return Arrays.copyOf(parameters, parameters.length);
	}
    
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

}