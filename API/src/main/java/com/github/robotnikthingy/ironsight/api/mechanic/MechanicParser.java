package com.github.robotnikthingy.ironsight.api.mechanic;

import java.text.ParseException;
import java.util.function.Function;

/**
 * Represents a parser capable of parsing string data into {@link Mechanic}s. All
 * custom mechanics must be registered here before being acknowledged by the plugin
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface MechanicParser {
	
	/**
	 * Attempt to parse a full mechanic string with a name and parameters
	 * 
	 * @param value the parseable value (i.e. "someMechanic(someParam, someOtherParam)")
	 * @return the resulting mechanic. null if no parser data for the provided mechanic
	 * 
	 * @throws ParseException If the parse is unsuccessful given that the provided String
	 * is null, empty, or simply does not match the required RegEx pattern
	 */
	public Mechanic parseMechanic(String value) throws ParseException;
	
	/**
	 * Register mechanic parser data to allow the plugin to recognise a mechanic in the
	 * configuration file. The passed String should be the NAME of the mechanic, and the
	 * name only (i.e. "someMechanic(someParam)" should only pass "someMechanic")
	 * 
	 * @param mechanicName the name of the mechanic to register
	 * @param creationFunction the function to create a new instance of the mechanic. The
	 * provided String array in the Function are the parsed parameters. Generally, 
	 * {@code CustomMechanicClass::new} as a parameter should suffice
	 */
	public void registerParserData(String mechanicName, Function<String[], Mechanic> creationFunction);
	
}