package com.github.robotnikthingy.ironsight.weapon;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.robotnikthingy.ironsight.api.IronSight;
import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;
import com.github.robotnikthingy.ironsight.api.player.IronSightPlayer;
import com.github.robotnikthingy.ironsight.api.weapon.Weapon;
import com.github.robotnikthingy.ironsight.api.weapon.WeaponHardpoint;

public class CustomWeaponHardpoint implements CustomWeapon, WeaponHardpoint {
	
	private MechanicDataHandler shootingHandler = IronSight.createMechanicDataHandler();
	
	private Location location;
	private IronSightPlayer user;
	
	private ItemStack item;
	private String name;
	private double damage;
	private boolean redstoneActivate;

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
	public void shoot(Player player) {}

	@Override
	public Weapon newInstance() {
		CustomWeaponHardpoint weapon = new CustomWeaponHardpoint();
		
		weapon.shootingHandler = shootingHandler;
		
		weapon.item = item;
		weapon.name = name;
		weapon.damage = damage;
		
		weapon.redstoneActivate = redstoneActivate;
		
		return weapon;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public Location getLocation() {
		return location.clone();
	}

	@Override
	public boolean setUser(IronSightPlayer player) {
		this.user = player;
		return true;
	}

	@Override
	public IronSightPlayer getUser() {
		return user;
	}

	@Override
	public boolean shouldRedstoneActivate() {
		return redstoneActivate;
	}
	
	@Override
	public void loadConfigurationOptions(FileConfiguration configFile) {
		// TODO: Load any and all information from the configuration file
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		long dmgBits = Double.doubleToLongBits(damage);
		
		int result = prime + (int) (dmgBits ^ (dmgBits >>> 32));
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (redstoneActivate ? 1231 : 1237);
		
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || !(object instanceof CustomWeaponHardpoint)) return false;
		
		CustomWeaponHardpoint weapon = (CustomWeaponHardpoint) object;
		if (name == null) {
			if (weapon.name != null) return false;
		}
		else if (!name.equals(weapon.name)) return false;
		
		return true;
	}
	
}