package com.github.robotnikthingy.weaponsapi.action;

import java.util.function.BiFunction;
import java.util.regex.Matcher;

/**
 * A parser to parse actions and their parameters from configuration files
 * 
 * @author Robotnik
 * @since 8/9/2017
 */
public final class MechanicParser {
	
	private MechanicParser() {}
	
	/**
	 * Parse and return a MechanicAction from a provided String value
	 * 
	 * @param action the action string to parse
	 * @return the resulting MechanicAction. null if unsuccessful parse
	 * 
	 * @author Parker Hawke - 2008Choco
	 */
	public static MechanicAction parseAction(String action) {
		return parse(action, MechanicAction::new);
	}
	
	/**
	 * Parse and return a MechanicRequirement from a provided String value
	 * 
	 * @param requirement the requirement string to parse
	 * @return the resulting MechanicRequirement. null if unsuccessful parse
	 * 
	 * @author Parker Hawke - 2008Choco
	 */
	public static MechanicRequirement parseRequirement(String requirement) {
		return parse(requirement, MechanicRequirement::new);
	}
	
	/**
	 * Parse any variant of AbstractMechanic and create a new instance of it
	 * 
	 * @param toParse the value to parse
	 * @param creation the instantiation function
	 * 
	 * @return the resulting abstract mechanic
	 * 
	 * @author Parker Hawke - 2008Choco
	 */
	private static <T extends AbstractMechanic> T parse(String toParse, BiFunction<String, String[], T> creation) {
		Matcher matcher = AbstractMechanic.MECHANIC_PATTERN.matcher(toParse);
		if (!matcher.find()) return null;
		
		String name = matcher.group(1);
		String[] parameters = matcher.group(2).split("\\s*,\\s*");
		
		return creation.apply(name, parameters);
	}
	
}