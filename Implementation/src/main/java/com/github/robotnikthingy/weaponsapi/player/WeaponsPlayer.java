package com.github.robotnikthingy.weaponsapi.player;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.robotnikthingy.weaponsapi.ammo.Ammunition;
import com.github.robotnikthingy.weaponsapi.hitbox.Hitbox;
import com.github.robotnikthingy.weaponsapi.weapon.Weapon;
import com.github.robotnikthingy.weaponsapi.weapon.WeaponHardpoint;

/**
 * An implementation of {@link IWeaponsPlayer}
 * 
 * @author Parker Hawke - 2008Choco
 */
public class WeaponsPlayer implements IWeaponsPlayer {
	
	private WeaponHardpoint hardpoint = null;
	private Hitbox hitbox;
	
	private Player player;
	private final UUID playerUUID;
	
	public WeaponsPlayer(Player player) {
		this.player = player;
		this.playerUUID = player.getUniqueId();
		
		Location location = player.getLocation();
		this.hitbox = new Hitbox(location.getWorld(),
				location.getX(), location.getY(), location.getZ(), 
				location.getX(), location.getY(), location.getZ());
	}

	@Override
	public Player getBukkitPlayer() {
		return player.isValid() ? player : (this.player = Bukkit.getPlayer(playerUUID));
	}

	@Override
	public boolean setActiveHardpoint(WeaponHardpoint hardpoint) {
		this.hardpoint = hardpoint;
		this.hardpoint.setUser(player);
		return true; // This should be based on the result of WeaponHardpoint#setUser()
	}

	@Override
	public WeaponHardpoint getActiveHardpoint() {
		return hardpoint;
	}

	@Override
	public int getRemainingAmmunition(Weapon weapon) {
		return -1; // TODO
	}

	@Override
	public int getRemainingAmmunition(Ammunition ammunition) {
		int ammoCount = 0;
		for (ItemStack item : player.getInventory()) {
			if (item == null || !item.isSimilar(ammunition.getItem())) continue;
			ammoCount += item.getAmount();
		}
		
		return ammoCount;
	}

	@Override
	public boolean hasWeapon(Weapon weapon) {
		if (weapon.getItem() == null) return false;
		
		for (ItemStack item : player.getInventory())
			if (item != null && item.isSimilar(weapon.getItem())) return true;
		
		return false;
	}

	@Override
	public Hitbox getHitbox() {
		return hitbox;
	}

	@Override
	public void updateHitbox() {
		// TODO: Update to the player's current location
	}
	
}