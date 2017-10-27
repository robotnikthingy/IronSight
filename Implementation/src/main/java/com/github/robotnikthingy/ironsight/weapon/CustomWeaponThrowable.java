package com.github.robotnikthingy.ironsight.weapon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.robotnikthingy.ironsight.api.IronSight;
import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;
import com.github.robotnikthingy.ironsight.api.weapon.Weapon;
import com.github.robotnikthingy.ironsight.api.weapon.WeaponLoadout;
import com.github.robotnikthingy.ironsight.api.weapon.WeaponThrowable;
import com.google.common.collect.ImmutableList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

public class CustomWeaponThrowable implements CustomWeapon, WeaponThrowable {
	
	private MechanicDataHandler reloadHandler = IronSight.createMechanicDataHandler();
	private MechanicDataHandler shootingHandler = IronSight.createMechanicDataHandler();
	
	private ItemStack item;
	private String name;
	private int clipSize, maxAmmo = 0;
	private double damage;
	
	private int fuse;
	private boolean activateOnImpact;
	
	private WeaponLoadout currentLoadout;
	private List<WeaponLoadout> loadouts = new ArrayList<>();

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ItemStack getItem() {
		return item;
	}
	
	@Override
	public void setLoadout(WeaponLoadout loadout) {
		this.currentLoadout = loadout;
	}

	@Override
	public WeaponLoadout getLoadout() {
		return currentLoadout;
	}

	@Override
	public Collection<WeaponLoadout> getLoadouts() {
		return ImmutableList.copyOf(loadouts);
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
		
		weapon.currentLoadout = currentLoadout;
		weapon.loadouts = loadouts;
		
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