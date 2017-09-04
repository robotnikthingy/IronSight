package com.github.robotnikthingy.weaponsapi.hitbox;

import java.util.UUID;

import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

/**
 * Represents a bounding box around a given minimum and maximum point.
 * Bounding boxes may be intercepted by bullets or alternative entities
 * (i.e. explosions)
 * 
 * @author Parker Hawke - 2008Choco
 */
public class Hitbox implements Cloneable {
	
	private final UUID world;
	private Vector min, max;
	
	/**
	 * Construct a new hitbox based on given coordinates and a world. Coordinates
	 * are not kept to any specific order and will be reorganized to suit the
	 * min-max orientation based on their value. Therefore, passed values need not
	 * be in order of value, rather in order of axis.
	 * 
	 * @param world the world in which this hitbox resides
	 * @param ax the primary x coordinate
	 * @param ay the primary y coordinate
	 * @param az the primary z coordinate
	 * @param bx the secondary x coordinate
	 * @param by the secondary y coordinate
	 * @param bz the secondary z coordinate
	 */
	public Hitbox(World world, double ax, double ay, double az, double bx, double by, double bz) {
		Validate.notNull(world, "Hitboxes cannot reside in a null world");
		
		this.world = world.getUID();
		this.min = new Vector(Math.min(ax, bx), Math.min(ay, by), Math.min(az, bz));
		this.max = new Vector(Math.max(ax, bx), Math.max(ay, by), Math.max(az, bz));
	}
	
	/**
	 * Construct a new hitbox based on given vectors and a world. Coordinates
	 * in the vector may be reorganized to suit the min-max orientation based
	 * on their values.
	 * 
	 * @param world the world in which this hitbox resides
	 * @param min the primary set of coordinates
	 * @param max the secondary set of coordinates
	 */
	public Hitbox(World world, Vector min, Vector max) {
		// Invoke alternative constructor to ensure integrity of provided vectors
		this(world, min.getX(), min.getY(), min.getZ(), max.getX(), max.getY(), max.getZ());
	}
	
	/**
	 * Construct a new hitbox based on given locations and their belonging world.
	 * Coordinates in the locations may be reorganized to suit the min-max 
	 * orientation based on their values. The world object from the first location
	 * object will be used as the residing world
	 * 
	 * @param min the primary location
	 * @param max the secondary location
	 */
	public Hitbox(Location min, Location max) {
		// Invoke alternative constructor to ensure integrity of provided vectors
		this(min.getWorld(), min.getX(), min.getY(), min.getZ(), max.getX(), max.getY(), max.getZ());
	}
	
	/**
	 * Get the world in which this hitbox resides
	 * 
	 * @return the residing world
	 */
	public World getWorld() {
		return Bukkit.getWorld(world);
	}
	
	/**
	 * Set the minimum position of this vector. The provided minimum vector
	 * may be shifted to better suit the min-max orientation of the hitbox
	 * 
	 * @param min the new minimum position
	 */
	public void setMin(Vector min) {
		Validate.notNull(min, "Cannot set the minimum point to a null value");
		
		this.min = new Vector(Math.min(min.getX(), max.getX()), Math.min(min.getY(), max.getY()), Math.min(min.getZ(), max.getZ()));
		this.max = new Vector(Math.max(min.getX(), max.getX()), Math.max(min.getY(), max.getY()), Math.max(min.getZ(), max.getZ()));
	}
	
	/**
	 * Set the minimum x coordinate for this hitbox. If the new minimum x 
	 * coordinate is greater than the maximum x coordinate, the minimum x
	 * coordinate will be set to the current maximum x coordinate, and the
	 * maximum x coordinate will be set to the provided value.
	 * 
	 * @param x the new minimum x coordinate
	 */
	public void setMinX(double x) {
		double minX = Math.min(x, max.getX());
		
		this.min.setX(minX);
		if (minX == max.getX()) {
			this.max.setX(x);
		}
	}
	
	/**
	 * Set the minimum y coordinate for this hitbox. If the new minimum y 
	 * coordinate is greater than the maximum y coordinate, the minimum y
	 * coordinate will be set to the current maximum y coordinate, and the
	 * maximum y coordinate will be set to the provided value.
	 * 
	 * @param y the new minimum y coordinate
	 */
	public void setMinY(double y) {
		double minY = Math.min(y, max.getY());
		
		this.min.setY(minY);
		if (minY == max.getY()) {
			this.max.setY(y);
		}
	}
	
	/**
	 * Set the minimum z coordinate for this hitbox. If the new minimum z 
	 * coordinate is greater than the maximum z coordinate, the minimum z
	 * coordinate will be set to the current maximum z coordinate, and the
	 * maximum z coordinate will be set to the provided value.
	 * 
	 * @param z the new minimum z coordinate
	 */
	public void setMinZ(double z) {
		double minZ = Math.min(z, max.getZ());
		
		this.min.setZ(minZ);
		if (minZ == max.getZ()) {
			this.max.setZ(z);
		}
	}
	
	/**
	 * Get the minimum position for this hitbox
	 * 
	 * @return the minimum position
	 */
	public Vector getMin() {
		return min;
	}
	
	/**
	 * Set the maximum position of this vector. The provided maximum vector
	 * may be shifted to better suit the min-max orientation of the hitbox
	 * 
	 * @param max the new maximum position
	 */
	public void setMax(Vector max) {
		Validate.notNull(min, "Cannot set the maximum point to a null value");
		
		this.min = new Vector(Math.min(min.getX(), max.getX()), Math.min(min.getY(), max.getY()), Math.min(min.getZ(), max.getZ()));
		this.max = new Vector(Math.max(min.getX(), max.getX()), Math.max(min.getY(), max.getY()), Math.max(min.getZ(), max.getZ()));
	}
	
	/**
	 * Set the maximum x coordinate for this hitbox. If the new maximum x 
	 * coordinate is less than the minimum x coordinate, the maximum x
	 * coordinate will be set to the current minimum x coordinate, and the
	 * minimum x coordinate will be set to the provided value.
	 * 
	 * @param x the new maximum x coordinate
	 */
	public void setMaxX(double x) {
		double maxX = Math.max(x, min.getX());
		
		this.max.setX(maxX);
		if (maxX == min.getX()) {
			this.min.setX(x);
		}
	}
	
	/**
	 * Set the maximum y coordinate for this hitbox. If the new maximum y 
	 * coordinate is less than the minimum y coordinate, the maximum y
	 * coordinate will be set to the current minimum y coordinate, and the
	 * minimum y coordinate will be set to the provided value.
	 * 
	 * @param y the new maximum y coordinate
	 */
	public void setMaxY(double y) {
		double maxY = Math.max(y, min.getY());
		
		this.max.setY(maxY);
		if (maxY == min.getY()) {
			this.min.setY(y);
		}
	}
	
	/**
	 * Set the maximum z coordinate for this hitbox. If the new maximum z 
	 * coordinate is less than the minimum z coordinate, the maximum z
	 * coordinate will be set to the current minimum z coordinate, and the
	 * minimum z coordinate will be set to the provided value.
	 * 
	 * @param z the new maximum z coordinate
	 */
	public void setMaxZ(double z) {
		double maxZ = Math.max(z, min.getZ());
		
		this.max.setZ(maxZ);
		if (maxZ == min.getZ()) {
			this.min.setZ(z);
		}
	}
	
	/**
	 * Get the maximum position for this hitbox
	 * 
	 * @return the maximum position
	 */
	public Vector getMax() {
		return max;
	}
	
	/**
	 * Get the length of this hitbox (x axis)
	 * 
	 * @return the length
	 */
	public double getLength() {
		return max.getX() - min.getX();
	}
	
	/**
	 * Get the width of this hitbox (z axis)
	 * 
	 * @return the width
	 */
	public double getWidth() {
		return max.getZ() - min.getZ();
	}
	
	/**
	 * Get the height of this hitbox (y axis)
	 * 
	 * @return the height
	 */
	public double getHeight() {
		return max.getY() - min.getY();
	}
	
	/**
	 * Check whether the provided point is within the confines of this hitbox
	 * 
	 * @param point the point to check
	 * @return true if the point lies within the hitbox
	 */
	public boolean isWithin(Vector point) {
		if (point == null) return false;
		
		double x = point.getX(), y = point.getY(), z = point.getZ();
		return (x > min.getX() && x < max.getX()) && (y > min.getY() && y < max.getY()) && (z > min.getZ() && z < max.getZ());
	}
	
	/**
	 * Check whether the provided point is within the confines of this hitbox
	 * as well as within the same world
	 * 
	 * @param location the location to check
	 * @return true if the location lies within the hitbox and is in the 
	 * same world
	 */
	public boolean isWithin(Location location) {
		return location != null && location.getWorld().getUID().equals(world) && isWithin(location.toVector());
	}
	
	/**
	 * Shift this hitbox along a given axis by a provided amount
	 * 
	 * @param axis the axis to shift
	 * @param amount the amount to shift by
	 */
	public void shift(Axis axis, double amount) {
		Validate.notNull(axis, "Hitboxes cannot be shifted on a null axis");
		axis.applyOffset(this, amount);
	}
	
	/**
	 * Shift the entirety of this hitbox by a given amount
	 * 
	 * @param amount the amount to shift by
	 */
	public void shift(double amount) {
		this.min.setX(min.getX() + amount);
		this.min.setY(min.getY() + amount);
		this.min.setZ(min.getZ() + amount);
		
		this.max.setX(max.getX() + amount);
		this.max.setY(max.getY() + amount);
		this.max.setZ(max.getZ() + amount);
	}
	
	@Override
	public int hashCode() {
		int prime = 31, result = 1;
		result = prime * result + max.hashCode();
		result = prime * result + min.hashCode();
		result = prime * result + world.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || !(object instanceof Hitbox)) return false;
		
		Hitbox hitbox = (Hitbox) object;
		return world.equals(hitbox.world) && min.equals(hitbox.min) && max.equals(hitbox.max);
	}
	
	@Override
	public Hitbox clone() {
		return new Hitbox(Bukkit.getWorld(world), min, max);
	}
	
}