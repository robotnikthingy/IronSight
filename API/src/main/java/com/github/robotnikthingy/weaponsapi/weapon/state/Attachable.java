package com.github.robotnikthingy.weaponsapi.weapon.state;

import com.github.robotnikthingy.weaponsapi.attachment.Attachment;
import com.github.robotnikthingy.weaponsapi.attachment.AttachmentPosition;

import org.bukkit.entity.Player;

/**
 * Represents a weapon capable of supporting attachments
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface Attachable {
	
	/**
	 * Get a list of all positions in which attachments are supported
	 * 
	 * @return all supported attachment positions
	 */
	public AttachmentPosition[] getSupportedAttachments();
	
	/**
	 * Check whether a given attachment can be attached to this weapon. This
	 * is more specific than {@link #getSupportedAttachments()} and can further
	 * specify what types of attachments are supported on the weapon
	 * 
	 * @param attachment the attachment to check
	 * @return true if attachable, false otherwise
	 */
	public boolean canAttach(Attachment attachment);
	
	/**
	 * Called when the provided attachment is attached to the weapon by the
	 * Player. This is called AFTER the attachment was successful, meaning
	 * {@link Attachment#attach(Player, com.github.robotnikthingy.weaponsapi.weapon.Weapon)}
	 * will be fired first whether it was successful or not.
	 * 
	 * @param player the player that attached the attachment
	 * @param attachment the attachment that was attached
	 */
	public void attach(Player player, Attachment attachment);
	
}