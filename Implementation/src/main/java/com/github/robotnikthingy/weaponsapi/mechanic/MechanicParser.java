package com.github.robotnikthingy.weaponsapi.mechanic;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;

import com.github.robotnikthingy.weaponsapi.api.mechanic.IMechanicParser;
import com.github.robotnikthingy.weaponsapi.api.mechanic.Mechanic;

/**
 * Represents an implementation of {@link IMechanicParser}
 * 
 * @author Parker Hawke - 2008Choco
 */
public class MechanicParser implements IMechanicParser {
	
	private final Map<String, Function<String[], Mechanic>> mechanics = new HashMap<>();
	
	@Override
	public Mechanic parseMechanic(String value) throws ParseException {
		if (value == null || value.isEmpty())
			throw new ParseException("Cannot parse null or empty String", 0);

		Matcher matcher = AbstractMechanic.MECHANIC_PATTERN.matcher(value);
		if (!matcher.find())
			throw new ParseException("Invalid syntax provided for parser. See AbstractMechanic#MECHANIC_PATTERN", 0);

		String name = matcher.group(1);
		String[] parameters = matcher.group(2).split("\\s*,\\s*");
		
		return (mechanics.containsKey(name) ? mechanics.get(name).apply(parameters) : null);
	}
	
	@Override
	public void registerParserData(String mechanic, Function<String[], Mechanic> creation) {
		if (mechanics.containsKey(mechanic))
			throw new IllegalStateException("Cannot register two mechanics with identical names (" + mechanic + ")");
			
		this.mechanics.put(mechanic, creation);
	}
	
	/**
	 * Clear all registered mechanic parsing data
	 */
	public void clearParseData() {
		this.mechanics.clear();
	}
	
}