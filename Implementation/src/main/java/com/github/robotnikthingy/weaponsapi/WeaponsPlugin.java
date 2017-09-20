package com.github.robotnikthingy.weaponsapi;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.robotnikthingy.weaponsapi.manager.IWeaponManager;
import com.github.robotnikthingy.weaponsapi.manager.WeaponManager;
import com.github.robotnikthingy.weaponsapi.mechanic.IMechanicParser;
import com.github.robotnikthingy.weaponsapi.mechanic.MechanicParser;
import com.github.robotnikthingy.weaponsapi.player.IWeaponsPlayer;
import com.github.robotnikthingy.weaponsapi.player.WeaponsPlayer;

/**
 * The main JavaPlugin class for the WeaponsAPI plugin implementation
 * 
 * @author Robotnik
 * @since 8/4/2017
 */
public class WeaponsPlugin extends JavaPlugin implements IWeaponsAPI {
	
	private static WeaponsPlugin instance;

    public static final File FOLDER_PLUGIN = WeaponsPlugin.getInstance().getDataFolder();
    public static final File FOLDER_WEAPONS = new File(FOLDER_PLUGIN, "/Weapons");
    public static final File FOLDER_PROJECTILES = new File(FOLDER_PLUGIN, "/Projectiles");
    public static final File FOLDER_ATTACHMENTS = new File(FOLDER_PLUGIN, "/Attachments");
    public static final File FOLDER_ITEMS = new File(FOLDER_PLUGIN, "/Items");
    public static final File FOLDER_EXPLOSIONS = new File(FOLDER_PLUGIN, "/Explosions");
    
    private final Map<UUID, WeaponsPlayer> players = new HashMap<>();

    private WeaponManager weaponManager;
    private MechanicParser mechanicParser;
    
    @Override
    public void onEnable() {
    	instance = this;
    	this.initFolders(FOLDER_PLUGIN, FOLDER_WEAPONS, FOLDER_PROJECTILES, 
    					FOLDER_ATTACHMENTS, FOLDER_ITEMS, FOLDER_EXPLOSIONS);
    	
    	// Load necessary variables
    	this.weaponManager = new WeaponManager();
    	this.mechanicParser = new MechanicParser();
    	
    	// Setup the API. Ready for use
        WeaponsAPI.setAPI(this);
    }

    /**
     * Get an instance of the weapons API
     * 
     * @return this instance
     */
    public static WeaponsPlugin getInstance() {
        return instance;
    }
    
    @Override
    public IWeaponManager getWeaponManager() {
		return weaponManager;
	}
    
    @Override
    public IMechanicParser getMechanicParser() {
    	return mechanicParser;
    }
    
    @Override
    public IWeaponsPlayer getPlayer(Player player) {
    	return players.computeIfAbsent(player.getUniqueId(), p -> new WeaponsPlayer(player));
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