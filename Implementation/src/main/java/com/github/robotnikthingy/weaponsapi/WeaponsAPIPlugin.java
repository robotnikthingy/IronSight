package com.github.robotnikthingy.weaponsapi;

import java.io.File;
import java.util.Arrays;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Robotnik
 * @since 8/4/2017
 */
public class WeaponsAPIPlugin extends JavaPlugin {
	
	private static WeaponsAPIPlugin instance;

    public static final File FOLDER_PLUGIN = WeaponsAPIPlugin.getInstance().getDataFolder();
    public static final File FOLDER_WEAPONS = new File(FOLDER_PLUGIN, "/Weapons");
    public static final File FOLDER_PROJECTILES = new File(FOLDER_PLUGIN, "/Projectiles");
    public static final File FOLDER_ATTACHMENTS = new File(FOLDER_PLUGIN, "/Attachments");
    public static final File FOLDER_ITEMS = new File(FOLDER_PLUGIN, "/Items");
    public static final File FOLDER_EXPLOSIONS = new File(FOLDER_PLUGIN, "/Explosions");

    private WeaponsAPIInterface weaponsAPIInterface;
    
    @Override
    public void onEnable() {
    	instance = this;
    	this.initFolders(FOLDER_PLUGIN, FOLDER_WEAPONS, FOLDER_PROJECTILES, 
    					FOLDER_ATTACHMENTS, FOLDER_ITEMS, FOLDER_EXPLOSIONS);
    	
        this.weaponsAPIInterface = new WeaponsAPIImplementation();
        WeaponsAPI.API.setApi(weaponsAPIInterface);
    }

    /**
     * Get an instance of the weapons API
     * 
     * @return this instance
     */
    public static WeaponsAPIPlugin getInstance() {
        return instance;
    }
    
    /**
     * Create any directories passed into this method
     * 
     * @param folders the directories to create
     */
    private void initFolders(File... folders) {
    	Arrays.stream(folders).filter(File::isDirectory).forEach(File::mkdirs);
    }
    
}