package com.github.robotnikthingy.ironsight.api.attachment;

import com.github.robotnikthingy.ironsight.api.weapon.Weapon;

/**
 * Represents a weapon attachment that gives weapons special properties
 * 
 * @author Parker Hawke - 2008Choco
 */
public interface Attachment {
	
	/**
	 * Get the name of this attachment
	 * 
	 * @return the attachment name
	 */
	public String getName();
	
	/**
	 * Get all possible positions on a weapon for this attachment
	 * 
	 * @return the attachment positions
	 */
	public AttachmentPosition[] getPositions();
	
	/**
	 * Check whether this attachment may be attached to a given weapon
	 * 
	 * @param weapon the weapon to check
	 * @return true if attachable to the specified weapon. false otherwise
	 */
	public boolean isAttachableTo(Weapon weapon);
	
	/**
	 * Check whether this attachment can be attached to a weapon if the
	 * provided attachment is present
	 * 
	 * @param attachment the attachment to check compatibility for
	 * @return true if attachable when the provided attachment is present.
	 * false otherwise
	 */
	public boolean isAttachableWith(Attachment attachment);
	
}