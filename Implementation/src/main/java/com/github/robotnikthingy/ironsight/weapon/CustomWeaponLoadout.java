package com.github.robotnikthingy.ironsight.weapon;

import com.github.robotnikthingy.ironsight.api.IronSight;
import com.github.robotnikthingy.ironsight.api.ammo.Ammunition;
import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;
import com.github.robotnikthingy.ironsight.api.weapon.WeaponLoadout;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CustomWeaponLoadout implements WeaponLoadout {
	
	@SuppressWarnings("unused")
	private int clipSize, maxAmmo, cooldown, ammo = 0; // TODO
    private double damage;
    @SuppressWarnings("unused") private String name; // TODO
    @SuppressWarnings("unused") private String[] lore; // TODO
    
    @SuppressWarnings("unused")
    private boolean reloadOnSwitch; // TODO
    
    private MechanicDataHandler reloadHandler = IronSight.createMechanicDataHandler();
    private MechanicDataHandler shootingHandler = IronSight.createMechanicDataHandler();
    
    public CustomWeaponLoadout(String name) {
    	this.name = name;
    }
    
    public void loadConfigurationOptions(FileConfiguration configFile) {
    	
    }
    
    @Override
    public void reload(Player player, Ammunition ammo) {
        int ammoCount = IronSight.getPlayer(player).getRemainingAmmunition(ammo);
        int requiredAmmo = getClipSize() - this.ammo;

        int toReload = Math.min(requiredAmmo, Math.min(ammoCount, getClipSize()));
        this.ammo += toReload;

        // Remove item from inventory
        ItemStack item = ammo.getItem();
        item.setAmount(toReload);
        player.getInventory().removeItem(item);
    }
    
    @Override
    public MechanicDataHandler getReloadDataHandler() {
        return reloadHandler;
    }
    
    @Override
    public MechanicDataHandler getShootingDataHandler() {
        return shootingHandler;
    }
    
    @Override
    public int getClipSize() {
        return clipSize;
    }
    
    @Override
    public int getMaxAmmo() {
        return maxAmmo;
    }
    
    @Override
    public int getAmmo() {
        return ammo;
    }
    
    @Override
    public double getDamage() {
        return damage;
    }
    
    @Override
    public void shoot(Player player) {
        this.ammo--;
    }

}