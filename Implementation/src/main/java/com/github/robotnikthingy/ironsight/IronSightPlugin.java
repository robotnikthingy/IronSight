package com.github.robotnikthingy.ironsight;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import com.github.robotnikthingy.ironsight.api.IronSight;
import com.github.robotnikthingy.ironsight.api.IronSightAPI;
import com.github.robotnikthingy.ironsight.api.ammo.Ammunition;
import com.github.robotnikthingy.ironsight.api.bullet.Bullet;
import com.github.robotnikthingy.ironsight.api.manager.WeaponManager;
import com.github.robotnikthingy.ironsight.api.mechanic.MechanicParser;
import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;
import com.github.robotnikthingy.ironsight.api.player.IronSightPlayer;
import com.github.robotnikthingy.ironsight.api.weapon.Weapon;
import com.github.robotnikthingy.ironsight.bullet.IronBullet;
import com.github.robotnikthingy.ironsight.manager.IronWeaponManager;
import com.github.robotnikthingy.ironsight.mechanic.IronMechanicParser;
import com.github.robotnikthingy.ironsight.mechanic.data.IronMechanicDataHandler;
import com.github.robotnikthingy.ironsight.player.IronPlayer;

/**
 * The main JavaPlugin class for the IronSight plugin implementation
 * 
 * @author Robotnik
 * @since 8/4/2017
 */
public class IronSightPlugin extends JavaPlugin implements IronSightAPI {
	
	private static IronSightPlugin instance;

    public static final File FOLDER_PLUGIN = IronSightPlugin.getInstance().getDataFolder();
    public static final File FOLDER_WEAPONS = new File(FOLDER_PLUGIN, "/Weapons");
    public static final File FOLDER_HARDPOINTS = new File(FOLDER_PLUGIN, "/Hardpoints");
    public static final File FOLDER_PROJECTILES = new File(FOLDER_PLUGIN, "/Projectiles");
    public static final File FOLDER_ATTACHMENTS = new File(FOLDER_PLUGIN, "/Attachments");
    public static final File FOLDER_ITEMS = new File(FOLDER_PLUGIN, "/Items");
    public static final File FOLDER_EXPLOSIONS = new File(FOLDER_PLUGIN, "/Explosions");
    
    private final Map<UUID, IronPlayer> players = new HashMap<>();

    private IronWeaponManager weaponManager;
    private IronMechanicParser mechanicParser;
    
    @Override
    public void onEnable() {
    	instance = this;
    	this.initFolders(FOLDER_PLUGIN, FOLDER_WEAPONS, FOLDER_PROJECTILES, 
    					FOLDER_ATTACHMENTS, FOLDER_ITEMS, FOLDER_EXPLOSIONS);
    	
    	// Load necessary variables
    	this.weaponManager = new IronWeaponManager();
    	this.mechanicParser = new IronMechanicParser();
    	
    	// Setup the API. Ready for use
        IronSight.setAPI(this);
    }

    /**
     * Get an instance of the weapons API
     * 
     * @return this instance
     */
    public static IronSightPlugin getInstance() {
        return instance;
    }
    
    @Override
    public WeaponManager getWeaponManager() {
		return weaponManager;
	}
    
    @Override
    public MechanicParser getMechanicParser() {
    	return mechanicParser;
    }
    
    @Override
    public IronSightPlayer getPlayer(Player player) {
    	return players.computeIfAbsent(player.getUniqueId(), p -> new IronPlayer(player));
    }
    
    @Override
    public MechanicDataHandler createMechanicDataHandler() {
    	return new IronMechanicDataHandler();
    }
    
    @Override
    public Bullet createBullet(Weapon weapon, Ammunition ammunition, IronSightPlayer shooter, Location location, Vector initialVelocity) {
    	return new IronBullet(weapon, ammunition, shooter, location, initialVelocity);
    }
    
    @Override
    public Bullet createBullet(Weapon weapon, Ammunition ammunition, IronSightPlayer shooter, Location location) {
    	return new IronBullet(weapon, ammunition, shooter, location);
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