package com.github.robotnikthingy.ironsight.weapon;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.robotnikthingy.ironsight.api.IronSight;
import com.github.robotnikthingy.ironsight.api.ammo.Ammunition;
import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;
import com.github.robotnikthingy.ironsight.api.weapon.Weapon;
import com.github.robotnikthingy.ironsight.api.weapon.WeaponThrowable;

public class CustomWeaponThrowable implements CustomWeapon, WeaponThrowable {
	
	private MechanicDataHandler reloadHandler = IronSight.createMechanicDataHandler();
	private MechanicDataHandler shootingHandler = IronSight.createMechanicDataHandler();
	
	private ItemStack item;
	private String name;
	private int clipSize, maxAmmo, ammo = 0;
	private double damage;
	
	private int fuse;
	private boolean activateOnImpact;

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
	public MechanicDataHandler getReloadDataHandler() {
		return reloadHandler;
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
	public String getName() {
		return name;
	}

	@Override
	public double getDamage() {
		return damage;
	}

	@Override
	public ItemStack getItem() {
		return item;
	}

	@Override
	public MechanicDataHandler getShootingDataHandler() {
		return shootingHandler;
	}

	@Override
	public void shoot(Player player) {
		this.ammo--;
	}

	@Override
	public Weapon newInstance() {
		CustomWeaponThrowable weapon = new CustomWeaponThrowable();
		
		weapon.reloadHandler = reloadHandler;
		weapon.shootingHandler = shootingHandler;
		
		weapon.item = item;
		weapon.name = name;
		weapon.clipSize = clipSize;
		weapon.maxAmmo = maxAmmo;
		weapon.damage = damage;
		
		weapon.fuse = fuse;
		weapon.activateOnImpact = activateOnImpact;
		
		return weapon;
	}

	@Override
	public int getFuse() {
		return fuse;
	}

	@Override
	public boolean activateOnImpact() {
		return activateOnImpact;
	}
	
	@Override
	public void loadConfigurationOptions(FileConfiguration configFile) {
		// TODO: Load any and all information from the configuration file
	}

	@Override
	public int hashCode() {
		int prime = 31;
		long dmgBits = Double.doubleToLongBits(damage);
		
		int result = prime + clipSize;
		result = prime * result + (int) (dmgBits ^ (dmgBits >>> 32));
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + maxAmmo;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (activateOnImpact ? 1231 : 1237);;
		result = prime * result + fuse;
		
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || !(object instanceof CustomWeaponThrowable)) return false;
		
		CustomWeaponThrowable weapon = (CustomWeaponThrowable) object;
		if (name == null) {
			if (weapon.name != null) return false;
		}
		else if (!name.equals(weapon.name)) return false;
		
		return true;
	}
	
}