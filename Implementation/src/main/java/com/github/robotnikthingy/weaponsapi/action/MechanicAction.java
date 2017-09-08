package com.github.robotnikthingy.weaponsapi.action;

import com.github.robotnikthingy.weaponsapi.mechanic.MechanicType;

/**
 * Represents an action such as shooting a projectile or playing a sound
 *
 * @author Robotnik
 * @since 9/7/2017
 */
public class MechanicAction extends AbstractMechanic {

    protected MechanicAction(String name, String[] parameters) {
        super(MechanicType.ACTION, name, parameters);
    }
    
}