package com.github.robotnikthingy.weaponsapi.mechanic.defaults.requirement;

import com.github.robotnikthingy.weaponsapi.api.mechanic.data.MechanicEnvironment;
import com.github.robotnikthingy.weaponsapi.mechanic.AbstractRequirement;

/**
 * This is an example to demonstrate how requirements will function.
 * This class will not stay within implementation and should not be used
 * nor registered
 * 
 * @author Parker Hawke - 2008Choco
 */
public class RequirementExample extends AbstractRequirement {
	
	private boolean specificParameter1;
	private int specificParameter2;
	
	public RequirementExample(String[] parameters) {
		super("exampleRequirement", parameters);
	}
	
	public boolean getSpecificParametre1() {
		return specificParameter1;
	}
	
	public int getSpecificParameter2() {
		return specificParameter2;
	}
	
	@Override
	public boolean isMet(MechanicEnvironment environment) {
		return specificParameter1 && (specificParameter2 > 0) && environment.getPlayer().getBukkitPlayer().isFlying();
	}
	
}