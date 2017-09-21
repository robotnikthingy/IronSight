package com.github.robotnikthingy.weaponsapi.mechanic;

import java.util.function.Consumer;

import com.github.robotnikthingy.weaponsapi.mechanic.data.MechanicEnvironment;

/**
 * Represents a type of mechanic capabale of being executed at any given
 * time such that its execution method is invoked
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface MechanicAction extends Mechanic {
	
	/**
	 * Call this mechanic action and invoke required methods
	 * 
	 * @param environment the environment as of this method call. Cannot be null
	 */
	public void call(MechanicEnvironment environment);
	
	/**
	 * Get this mechanic requirement as a consumer function. By default,
	 * this method implementation will return the result of
	 * {@link #call(MechanicEnvironment)} as a Consumer, but if possible,
	 * this method should be overridden to simplify the Predicate as much
	 * as possible
	 * 
	 * @return the resulting consumer
	 */
	public default Consumer<MechanicEnvironment> asConsumer() {
		return e -> call(e);
	}
	
	@Override
	public default MechanicType getType() {
		return MechanicType.ACTION;
	}
	
}