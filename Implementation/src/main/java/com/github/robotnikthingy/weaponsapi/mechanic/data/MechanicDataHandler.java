package com.github.robotnikthingy.weaponsapi.mechanic.data;

import java.util.ArrayList;
import java.util.List;

import com.github.robotnikthingy.weaponsapi.mechanic.MechanicAction;
import com.github.robotnikthingy.weaponsapi.mechanic.MechanicRequirement;
import com.google.common.collect.ImmutableList;

/**
 * Represents an implementation of {@link IMechanicDataHandler}
 * 
 * @author Parker Hawke - 2008Choco
 */
public class MechanicDataHandler implements IMechanicDataHandler {
	
	private final List<MechanicRequirement> requirements = new ArrayList<>();
	private final List<MechanicAction> actions = new ArrayList<>();

	@Override
	public void addRequirement(MechanicRequirement requirement) {
		if (requirements.contains(requirement)) return;
		this.requirements.add(requirement);
	}

	@Override
	public void removeRequirement(MechanicRequirement requirement) {
		this.requirements.remove(requirement);
	}

	@Override
	public boolean hasRequirement(MechanicRequirement requirement) {
		return requirements.contains(requirement);
	}
	
	@Override
	public boolean hasRequirements() {
		return requirements.size() >= 1;
	}

	@Override
	public List<MechanicRequirement> getRequirements() {
		return ImmutableList.copyOf(requirements);
	}

	@Override
	public void addAction(MechanicAction action) {
		if (actions.contains(action)) return;
		this.actions.add(action);
	}

	@Override
	public void removeAction(MechanicAction action) {
		this.actions.remove(action);
	}

	@Override
	public boolean hasAction(MechanicAction action) {
		return actions.contains(action);
	}
	
	@Override
	public boolean hasActions() {
		return actions.size() >= 1;
	}

	@Override
	public List<MechanicAction> getActions() {
		return ImmutableList.copyOf(actions);
	}
	
}