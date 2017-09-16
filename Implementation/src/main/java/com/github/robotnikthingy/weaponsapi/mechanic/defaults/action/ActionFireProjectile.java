package com.github.robotnikthingy.weaponsapi.mechanic.defaults.action;

import com.github.robotnikthingy.weaponsapi.mechanic.AbstractAction;
import com.github.robotnikthingy.weaponsapi.mechanic.data.MechanicEnvironment;

/**
 * The "fireProjectile" action which will be used to fire projectiles
 *
 * @author Robotnik
 * @since 9/7/2017
 */
public class ActionFireProjectile extends AbstractAction {
	
	public ActionFireProjectile(String[] parameters) {
		super("fireProjectile", parameters);
	}

	@Override
	public void call(MechanicEnvironment environment) {
		// TODO: Implement a projectile launch
	}
	
}