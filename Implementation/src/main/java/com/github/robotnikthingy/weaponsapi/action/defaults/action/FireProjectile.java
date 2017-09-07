package com.github.robotnikthingy.weaponsapi.action.defaults.action;

import com.github.robotnikthingy.weaponsapi.action.MechanicAction;

/**
 * The fireProjectile action which will be used to fire projectiles
 *
 * @author Robotnik
 * @since 9/7/2017
 */

public class FireProjectile extends MechanicAction {

    //will need to add target info and stuff later to determine where the projectile is being fire from, where its being fired at, etc
    FireProjectile(String[] parameters){
        super("FireProjectile", parameters);
    }
}
