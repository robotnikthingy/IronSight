package com.github.robotnikthingy.weaponsapi.mechanic;

import java.util.function.Predicate;

import com.github.robotnikthingy.weaponsapi.mechanic.data.MechanicEnvironment;

/**
 * Represents a type of mechanic capable of being evaluated in a given
 * situation. Whether the requirement is met or not should be determined
 * in {@link #isMet(Object)} by its implementation
 *
 * @author Parker Hawke - 2008Choco
 */
public interface MechanicRequirement extends Mechanic {
	
	/**
	 * Check whether this requirement has been met or not
	 * 
	 * @param environment the environment as of this method call. Cannot be null
	 * @return true if met, false otherwise
	 */
	public boolean isMet(MechanicEnvironment environment);
	
	/**
	 * Get this mechanic requirement as a predicate function. By default,
	 * this method implementation will return the result of
	 * {@link #isMet(MechanicEnvironment)} as a Predicate, but if possible,
	 * this method should be overridden to simplify the Predicate as much 
	 * as possible
	 * 
	 * @return the resulting predicate
	 */
	public default Predicate<MechanicEnvironment> asPredicate() {
		return e -> isMet(e);
	}
	
	@Override
	public default MechanicType getType() {
		return MechanicType.REQUIREMENT;
	}
	
}