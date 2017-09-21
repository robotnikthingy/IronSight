package com.github.robotnikthingy.weaponsapi.api.weapon.state;

import java.util.Map;

import org.bukkit.entity.Player;

import com.github.robotnikthingy.weaponsapi.api.attachment.Attachment;
import com.github.robotnikthingy.weaponsapi.api.attachment.AttachmentPosition;

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
	 * Get the attachment positioned at the given {@link AttachmentPosition}
	 * 
	 * @param position the position to retrieve
	 * @return the attachment at the position. null if none
	 */
	public Attachment getAttachment(AttachmentPosition position);
	
	/**
	 * Check whether an attachment is positioned somewhere on the weapon
	 * 
	 * @param attachment the attachment to check
	 * @return true if attached, false otherwise
	 */
	public boolean hasAttachment(Attachment attachment);
	
	/**
	 * Check whether an attachment is positioned at the specified position
	 * 
	 * @param position the position to check
	 * @return true if an attachment is present. false otherwise
	 */
	public boolean hasAttachment(AttachmentPosition position);
	
	/**
	 * Check whether a specific attachment is positioned at the specified position
	 * 
	 * @param position the position to check
	 * @param attachment the attachment to check
	 * 
	 * @return true if the attachment is at the given position. false otherwise
	 */
	public boolean hasAttachment(AttachmentPosition position, Attachment attachment);
	
	/**
	 * Get a Map of all attachments for this attachable weapon. The state of
	 * immutability or its null state cannot be verified and depends on the
	 * various implementations
	 * 
	 * @return the attachments on this object
	 */
	public Map<AttachmentPosition, Attachment> getAttachments();
	
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