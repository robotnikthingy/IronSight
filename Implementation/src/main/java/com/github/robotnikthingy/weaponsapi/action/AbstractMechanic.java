package com.github.robotnikthingy.weaponsapi.action;

import java.util.ArrayList;

/**
 * Represents the foundation of an action from which actions, requirements 
 * and target actions will inherit
 * 
 * @author Robotnik
 */
public class AbstractMechanic {

    AbstractMechanic(String name, mechanicType type, String[] parameters){

    }

    public enum mechanicType {
        ACTION, REQUIREMENT
    }

	
}