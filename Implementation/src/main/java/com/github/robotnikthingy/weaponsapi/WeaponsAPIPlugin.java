package com.github.robotnikthingy.weaponsapi;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by Robotnik on 8/4/2017.
 */
public class WeaponsAPIPlugin extends JavaPlugin {


    private WeaponsAPIInterface weaponsAPIInterface;
    public static File PluginFolder;
    public static File WeaponsFolder;
    public static File ProjectilesFolder;
    public static File AttachmentsFolder;
    public static File ItemsFolder;
    public static File ExplosionsFolder;
    private static WeaponsAPIPlugin instance;

    @Override
    public void onEnable() {
        this.weaponsAPIInterface = new WeaponsAPIImplementation();
        WeaponsAPI.api.setApi(weaponsAPIInterface);

        instance = this;

        //Robotnik: create folders
        PluginFolder = getDataFolder();
        if (PluginFolder.exists() == false)
            PluginFolder.mkdir();

        WeaponsFolder = new File(getDataFolder() + "/Weapons");
        if (WeaponsFolder.exists() == false)
            WeaponsFolder.mkdir();

        ProjectilesFolder = new File(getDataFolder() + "/Projectiles");
        if (ProjectilesFolder.exists() == false)
            ProjectilesFolder.mkdir();

        AttachmentsFolder = new File(getDataFolder() + "/Attachments");
        if (AttachmentsFolder.exists() == false)
            AttachmentsFolder.mkdir();

        ItemsFolder = new File(getDataFolder() + "/Items");
        if (ItemsFolder.exists() == false)
            ItemsFolder.mkdir();

        ExplosionsFolder = new File(getDataFolder() + "/Explosions");
        if (ExplosionsFolder.exists() == false)
            ExplosionsFolder.mkdir();
    }

    //return instance of the plugin
    public static WeaponsAPIPlugin getInstance() {
        return instance;
    }
}
