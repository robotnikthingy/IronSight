package com.github.robotnikthingy.weaponsapi.Weapons;

import com.github.robotnikthingy.weaponsapi.WeaponsAPIPlugin;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Robotnik on 8/9/2017.
 * Will be used to keep track of and manage all weapons loaded by the plugin
 */
public class WeaponManager {
    public static File PluginFolder;

    public static ArrayList<WeaponItem> Weapons = new ArrayList<WeaponItem>();

    WeaponManager(){
        loadWeapons(WeaponsAPIPlugin.WeaponsFolder);
    }

    /**
     * Reloads all weapons and their configurations
     */
    public void reloadWeapons(){
        Weapons.clear();
        loadWeapons(WeaponsAPIPlugin.WeaponsFolder);
    }

    //Scans though all files in a folder and its subfolders, and adds any weapons found
    public void loadWeapons(File directory){
        //clear first since this method will be used on a reload of the plugin

        File[] directoryListing = directory.listFiles();
        for (File file : directoryListing){
            //scan through subfolder for weapons if its a directory
            if(file.isDirectory()){
                loadWeapons(file);
            }

            String extension = "";

            //Want to avoid using an external library just to get the file extension
            int i = file.getName().lastIndexOf('.');
            if (i > 0) {
                extension = file.getName().substring(i + 1);
            }

            //its a config file
            if (extension.equals("yml")){
                FileConfiguration config = YamlConfiguration.loadConfiguration(file);

                //try and find configuration section for the weapon
                ConfigurationSection ConfSection = config.getDefaultSection();
                if(ConfSection != null){
                    for(String key:ConfSection.getKeys(false)){
                        //we found a weapon so lets add it
                        Weapons.add(new WeaponItem(key,file));
                    }
                }
            }
        }
    }




    /**
     * Returns a WeaponItem from the manager if it exists
     * if specified weapon does not exist then returns null
     *
     * @param weaponName a String which represents a name of a weapon as found in a config file
     * @return weapon. If weapon does not exist returns null.
     */
    public WeaponItem getWeapon(String weaponName){
        for(WeaponItem weapon:Weapons){
            if(weapon.getName().equals(weaponName)){
                return weapon;
            }
        }

        //if no weapons are found, return null
        return null;

    }
}
