package com.github.robotnikthingy.weaponsapi.mechanic.data;

import com.github.robotnikthingy.weaponsapi.mechanic.MechanicAction;
import com.github.robotnikthingy.weaponsapi.mechanic.MechanicRequirement;

import java.util.List;

/**
 * Represents a data handler for objects that require specific mechanic
 * requirements or actions when an action should occur
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface IMechanicDataHandler {
	
	/**
	 * Add a requirement to the data handler
	 * 
	 * @param requirement the requirement to add
	 */
	public void addRequirement(MechanicRequirement requirement);
	
	/**
	 * Remove a requirement from the data handler
	 * 
	 * @param requirement the requirement to remove
	 */
	public void removeRequirement(MechanicRequirement requirement);
	
	/**
	 * Check whether a requirement is present in this data handler
	 * 
	 * @param requirement the requirement to check
	 * @return true if present, false otherwise
	 */
	public boolean hasRequirement(MechanicRequirement requirement);
	
	/**
	 * Check whether this data handler contains any requirements
	 * 
	 * @return true if at least 1 requirement. false if none
	 */
	public boolean hasRequirements();
	
	/**
	 * Get a list of all requirements currently handled by this
	 * data handler
	 * 
	 * @return a list of all mechanic requirements
	 */
	public List<MechanicRequirement> getRequirements();
	
	/**
	 * Add a callable action to the data handler
	 * 
	 * @param action the action to add
	 */
	public void addAction(MechanicAction action);
	
	/**
	 * Remove a callable action from the data handler
	 * 
	 * @param action the action to remove
	 */
	public void removeAction(MechanicAction action);
	
	/**
	 * Check whether a callable action is present in this data
	 * handler
	 * 
	 * @param action the action to check
	 * @return true if present, false otherwise
	 */
	public boolean hasAction(MechanicAction action);
	
	/**
	 * Check whether this data handler contains any actions
	 * 
	 * @return true if at least 1 action. false if none
	 */
	public boolean hasActions();
	
	/**
	 * Get a list of all callable actions currently handled
	 * by this data handler
	 * 
	 * @return a list of all mechanic actions
	 */
	public List<MechanicAction> getActions();
	
}