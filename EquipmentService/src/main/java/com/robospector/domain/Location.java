package com.robospector.domain;

public class Location {

	private String localtionurl;
	private String latitude;
	private String longitude;

	public Location() {
		super();
	}

	public Location(String localtionurl, String latitude, String longitude) {
		super();
		this.localtionurl = localtionurl;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLocaltionurl() {
		return localtionurl;
	}

	public void setLocaltionurl(String localtionurl) {
		this.localtionurl = localtionurl;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Location [localtionurl=" + localtionurl + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
