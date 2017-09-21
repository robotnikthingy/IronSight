package com.github.robotnikthingy.weaponsapi.attachment;

import java.io.File;

import com.github.robotnikthingy.weaponsapi.api.attachment.Attachment;
import com.github.robotnikthingy.weaponsapi.api.attachment.AttachmentPosition;
import com.github.robotnikthingy.weaponsapi.api.weapon.Weapon;
import com.github.robotnikthingy.weaponsapi.utils.ConfigurableObject;

import org.bukkit.entity.Player;

/**
 * Represents an attachment to a weapon and its properties
 * 
 * @author Parker Hawke - 2008Choco
 */
public class ConfigurableAttachment extends ConfigurableObject implements Attachment {
	
	public ConfigurableAttachment(File file) {
		super(file);
	}
	
	@Override
	public void loadConfigurationOptions() {
    	// TODO: Load values from configuration file
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public AttachmentPosition[] getPositions() {
		return null; // TODO: Attachment position
	}

	@Override
	public boolean isAttachableTo(Weapon weapon) {
		return false; // TODO: Return attachable guns
	}

	@Override
	public boolean isAttachableWith(Attachment attachment) {
		return false; // TODO: Get incompatible attachments
	}

	@Override
	public boolean attach(Player player, Weapon weapon) {
		return true;
	}
	
}