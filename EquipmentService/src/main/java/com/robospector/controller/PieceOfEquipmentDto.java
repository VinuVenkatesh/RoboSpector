package com.robospector.controller;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import com.robospector.domain.Location;

@Component
public class PieceOfEquipmentDto {

	@Id
	private int id;
	private String name;
	private Location location;
	private int aging;
	private String comment;
	private String createdBy;

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "PieceOfEquipement [id=" + id + ", name=" + name + ", location=" + location + ", aging=" + aging
				+ ", comment=" + comment + ", createdBy=" + createdBy + "]";
	}
}
