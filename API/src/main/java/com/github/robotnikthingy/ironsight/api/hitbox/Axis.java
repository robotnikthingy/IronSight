package com.github.robotnikthingy.ironsight.api.hitbox;

import java.util.function.BiConsumer;

import org.apache.commons.lang.Validate;

/**
 * Represents the varying axis in the Minecraft world. A utility class
 * for {@link Hitbox}
 * 
 * @author Parker Hawke - 2008Choco
 */
public enum Axis {
	
	/**
	 * Represents the X axis (along the east/west directions)
	 */
	X(Hitbox::setMinX, Hitbox::setMaxX),
	
	/**
	 * Represents the Y axis (along the up/down directions)
	 */
	Y(Hitbox::setMinY, Hitbox::setMaxY),
	
	/**
	 * Represents the Z axis (along the north/south directions)
	 */
	Z(Hitbox::setMinZ, Hitbox::setMaxZ);
	
	
	private final BiConsumer<Hitbox, Double> minManipulator, maxManipulator;
	
	private Axis(BiConsumer<Hitbox, Double> minManipulator, BiConsumer<Hitbox, Double> maxManipulator) {
		this.minManipulator = minManipulator;
		this.maxManipulator = maxManipulator;
	}
	
	/**
	 * Apply an offset for a given hitbox
	 * 
	 * @param hitbox the hitbox to offset
	 * @param offset the amount in which the hitbox should be offset
	 */
	public void applyOffset(Hitbox hitbox, double offset) {
		Validate.notNull(hitbox, "Cannot apply offset to null hitbox");
		
		minManipulator.accept(hitbox, offset);
		maxManipulator.accept(hitbox, offset);
	}
	
}