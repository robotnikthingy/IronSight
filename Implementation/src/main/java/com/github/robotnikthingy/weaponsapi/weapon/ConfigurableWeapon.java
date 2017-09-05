package com.github.robotnikthingy.weaponsapi.weapon;

import java.io.File;

import com.github.robotnikthingy.weaponsapi.utils.ConfigurableObject;

/**
 * Represents a weapon created using configuration files
 * 
 * @author Parker Hawke - 2008Choco
 */
public class ConfigurableWeapon extends ConfigurableObject implements Weapon {

    public ConfigurableWeapon(String name, File file){
    	super(name, file);
    }
    
    public void loadConfigurationOptions(){
    	// TODO: Load values from configuration file
    }
    
    @Override
    public String getName() {
    	return name;
    }

}