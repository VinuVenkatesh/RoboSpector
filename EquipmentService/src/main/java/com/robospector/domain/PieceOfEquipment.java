package com.robospector.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "equipmentdetails")
public class PieceOfEquipment {

	@Id
	private int id;
	private String name;
	private Location location;
	private int aging;
	private String comment;
	private boolean isArchived;

	public PieceOfEquipment() {
		super();
	}

	public PieceOfEquipment(int id, String name, Location location, int aging, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.aging = aging;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getAging() {
		return aging;
	}

	public void setAging(int aging) {
		this.aging = aging;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

	@Override
	public String toString() {
		return "PieceOfEquipment [id=" + id + ", name=" + name + ", location=" + location + ", aging=" + aging
				+ ", comment=" + comment + ", isArchived=" + isArchived + "]";
	}
}
