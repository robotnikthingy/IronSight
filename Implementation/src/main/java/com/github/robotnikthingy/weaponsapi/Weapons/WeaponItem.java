package com.github.robotnikthingy.weaponsapi.Weapons;

import com.github.robotnikthingy.weaponsapi.WeaponsAPIPlugin;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Created by Robotnik on 8/4/2017.
 * This represents a weapon item and all its properties
 */
public class WeaponItem extends AbstractWeapon{

    public String DisplayName;

    public WeaponItem(String name, File file){
        super(name,file);

    }






}
