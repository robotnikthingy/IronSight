package com.github.robotnikthingy.ironsight.weapon;

import java.io.File;

import org.bukkit.inventory.ItemStack;

import com.github.robotnikthingy.ironsight.api.weapon.Weapon;
import com.github.robotnikthingy.ironsight.utils.ConfigurableObject;

/**
 * Represents a weapon created using configuration files
 * 
 * @author Parker Hawke - 2008Choco
 */
public class ConfigurableWeapon extends ConfigurableObject implements Weapon {

    public ConfigurableWeapon(File file){
    	super(file);
    }
    
    @Override
    public void loadConfigurationOptions(){
    	// TODO: Load values from configuration file
    }
    
    @Override
    public String getName() {
    	return name;
    }
    
    @Override
    public double getDamage() {
    	return 0; // TODO Configurable damage values
    }
    
    @Override
    public ItemStack getItem() {
    	return null; // TODO: Representing ItemStack
    }

}