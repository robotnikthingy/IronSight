package com.github.robotnikthingy.ironsight.weapon;

import java.util.Arrays;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.robotnikthingy.ironsight.api.IronSight;
import com.github.robotnikthingy.ironsight.api.ammo.Ammunition;
import com.github.robotnikthingy.ironsight.api.attachment.Attachment;
import com.github.robotnikthingy.ironsight.api.attachment.AttachmentPosition;
import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;
import com.github.robotnikthingy.ironsight.api.weapon.Weapon;
import com.github.robotnikthingy.ironsight.api.weapon.WeaponAttachable;
import com.github.robotnikthingy.ironsight.api.weapon.WeaponItem;
import com.google.common.collect.ImmutableMap;

public class CustomWeaponItem implements CustomWeapon, WeaponItem, WeaponAttachable {
	
	private MechanicDataHandler reloadHandler = IronSight.createMechanicDataHandler();
	private MechanicDataHandler shootingHandler = IronSight.createMechanicDataHandler();
	private MechanicDataHandler selectionHandler = IronSight.createMechanicDataHandler();
	
	private ItemStack item;
	private AttachmentPosition[] supportedPositions;
	private Map<AttachmentPosition, Attachment> attachments;
	
	private String name;
	private int clipSize, maxAmmo, ammo = 0;
	private double damage;

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
		CustomWeaponItem weapon = new CustomWeaponItem();
		
		weapon.reloadHandler = reloadHandler;
		weapon.shootingHandler = shootingHandler;
		weapon.selectionHandler = selectionHandler;
		
		weapon.item = item;
		weapon.supportedPositions = supportedPositions;
		
		weapon.name = name;
		weapon.clipSize = clipSize;
		weapon.maxAmmo = maxAmmo;
		weapon.damage = damage;
		
		return weapon;
	}

	@Override
	public AttachmentPosition[] getSupportedAttachments() {
		return Arrays.copyOf(supportedPositions, supportedPositions.length);
	}

	@Override
	public boolean addAttachment(AttachmentPosition position, Attachment attachment) {
		if (!attachments.containsKey(position) || attachments.get(position) != null) return false;
		
		this.attachments.put(position, attachment);
		return true;
	}

	@Override
	public boolean setAttachment(AttachmentPosition position, Attachment attachment) {
		if (!attachments.containsKey(position)) return false;
		
		this.attachments.put(position, attachment);
		return true;
	}

	@Override
	public Attachment removeAttachment(AttachmentPosition position) {
		return attachments.remove(position);
	}

	@Override
	public Attachment getAttachment(AttachmentPosition position) {
		return attachments.get(position);
	}

	@Override
	public boolean hasAttachment(Attachment attachment) {
		return attachments.containsValue(attachment);
	}

	@Override
	public boolean hasAttachment(AttachmentPosition position) {
		return attachments.get(position) != null;
	}

	@Override
	public boolean hasAttachment(AttachmentPosition position, Attachment attachment) {
		return attachments.get(position) == attachment;
	}

	@Override
	public Map<AttachmentPosition, Attachment> getAttachments() {
		return ImmutableMap.copyOf(attachments);
	}

	@Override
	public boolean canAttach(Attachment attachment) {
		return true;
	}

	@Override
	public MechanicDataHandler getSelectionDataHandler() {
		return selectionHandler;
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
		result = prime * result + Arrays.hashCode(supportedPositions);
		
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || !(object instanceof CustomWeaponItem)) return false;
		
		CustomWeaponItem weapon = (CustomWeaponItem) object;
		if (name == null) {
			if (weapon.name != null) return false;
		}
		else if (!name.equals(weapon.name)) return false;
		
		return true;
	}
	
}