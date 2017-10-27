package com.github.robotnikthingy.ironsight.weapon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.github.robotnikthingy.ironsight.api.IronSight;
import com.github.robotnikthingy.ironsight.api.attachment.Attachment;
import com.github.robotnikthingy.ironsight.api.attachment.AttachmentPosition;
import com.github.robotnikthingy.ironsight.api.mechanic.data.MechanicDataHandler;
import com.github.robotnikthingy.ironsight.api.weapon.Weapon;
import com.github.robotnikthingy.ironsight.api.weapon.WeaponAttachable;
import com.github.robotnikthingy.ironsight.api.weapon.WeaponItem;
import com.github.robotnikthingy.ironsight.api.weapon.WeaponLoadout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * This is an example implementation of {@link Weapon}, AK-47.
 * Any use of the API may refer to this implementation and learn how the
 * creation of a weapon may be accomplished
 * 
 * @author Parker Hawke - 2008Choco
 */
public class AK47 implements WeaponItem, WeaponAttachable {
	
	private static final ItemStack ITEM = new ItemStack(Material.DIAMOND_HOE, 1, (short) 1);
	private static final AttachmentPosition[] SUPPORTED_POSITIONS = {
		AttachmentPosition.BARREL,
		AttachmentPosition.GRIP,
		AttachmentPosition.MAGAZINE,
		AttachmentPosition.SCOPE,
		AttachmentPosition.STOCK,
	};
	
	private final MechanicDataHandler selectionHandler = IronSight.createMechanicDataHandler();
	
	private final List<WeaponLoadout> loadouts = new ArrayList<>();
	private final Map<AttachmentPosition, Attachment> attachments = AttachmentPosition.newAttachmentMap(SUPPORTED_POSITIONS);
	
	private WeaponLoadout currentLoadout;

	@Override
	public String getName() {
		return "AK-47";
	}

	@Override
	public ItemStack getItem() {
		return ITEM;
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
		return new AK47();
	}

	@Override
	public AttachmentPosition[] getSupportedAttachments() {
		return SUPPORTED_POSITIONS;
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
	
}