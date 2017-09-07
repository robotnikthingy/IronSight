package com.github.robotnikthingy.weaponsapi.action;
/**
 * Represents an action, such as shooting a projectile or playing a sound
 *
 * @author Robotnik
 * @since 9/7/2017
 */

import java.util.ArrayList;

public class MechanicAction extends AbstractMechanic{

    protected MechanicAction(String name, String[] parameters){
        super(name, mechanicType.ACTION, parameters);
    }
}
