package com.github.robotnikthingy.ironsight.api.weapon;

import java.util.Map;

import com.github.robotnikthingy.ironsight.api.attachment.Attachment;
import com.github.robotnikthingy.ironsight.api.attachment.AttachmentPosition;

/**
 * Represents a weapon capable of supporting attachments
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface WeaponAttachable extends Weapon {
	
	/**
	 * Get a list of all positions in which attachments are supported
	 * 
	 * @return all supported attachment positions
	 */
	public AttachmentPosition[] getSupportedAttachments();
     
    /** 
     * Add an attachment to this weapon at the given position. Attachment may 
     * fail if the position is already taken, or the position is not supported 
     *  
     * @param position the position to place the attachment 
     * @param attachment the attachment to add 
     *  
     * @return true if successful, false otherwise 
     */ 
    public boolean addAttachment(AttachmentPosition position, Attachment attachment); 
     
    /** 
     * Forcibly set an attachment to this weapon at the given position regardless 
     * of any existing attachments. This method may still fail and return false  
     * if the position specified is not supported 
     *  
     * @param position the position to place the attachment 
     * @param attachment the attachment to set 
     *  
     * @return true if successful, false otherwise 
     */ 
    public boolean setAttachment(AttachmentPosition position, Attachment attachment); 
	
    /** 
     * Remove the attachment from a given position if one is present 
     *  
     * @param position the position to remove the attachment from 
     * @return the removed attachment. null if none removed 
     */ 
    public Attachment removeAttachment(AttachmentPosition position); 
     
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
	
}