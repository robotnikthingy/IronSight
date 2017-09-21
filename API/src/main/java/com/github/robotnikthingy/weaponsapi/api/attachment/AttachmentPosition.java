package com.github.robotnikthingy.weaponsapi.api.attachment;

/**
 * Represents a position on the gun in which an attachment can be made
 * 
 * @author Parker Hawke - 2008Choco
 */
public enum AttachmentPosition {
	
	/**
	 * An attachment on the gun barrel (i.e. silencer, flash hider, etc.)
	 */
	BARREL,
	
	/**
	 * A grip under the midsection of the weapon (i.e. bipod, foregrip, etc.)
	 */
	GRIP,
	
	/**
	 * A magazine attachment (i.e. quickdraw mag, extended mag, etc.)
	 */
	MAGAZINE,
	
	/**
	 * A scope attachment on a weapon (i.e. 8x scope, red dot, etc.)
	 */
	SCOPE,
	
	/**
	 * The left side of the weapon (generally used as an alternative position
	 * for underbarrel attachments)
	 */
	SIDE_LEFT,
	
	/**
	 * The right side of the weapon (generally used as an alternative position
	 * for underbarrel attachments)
	 */
	SIDE_RIGHT,
	
	/**
	 * An attachment on the stock of the gun (i.e. adjustable stock, etc.)
	 */
	STOCK,

	/**
	 * An attachment positioned under the barrel of the gun (i.e. laser sight, 
	 * flashlights, etc.)
	 */
	UNDERBARREL;
	
}