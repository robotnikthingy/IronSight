package com.github.robotnikthingy.weaponsapi.Weapons;

import java.io.File;
import org.bukkit.Location;

/**
 * Will be used to represent a weapon located at coordinates in a world.
 * This weapon is not attached to a player and is meant to be used as a way of using weapons
 * in forms other than an Item which other plugins can take advantage of
 * ex: having a cannon made out of blocks which fires the weapon when it receives a redstone signal
 */
public class WeaponHardPoint extends AbstractWeapon{

    Location location;

    public WeaponHardPoint(String name, File file, Location location){
        super(name,file);
        this.location = location;
    }

}
