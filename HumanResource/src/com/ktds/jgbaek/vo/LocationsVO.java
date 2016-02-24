package com.ktds.jgbaek.vo;

public class LocationsVO {
	
//	LOCATION_ID	NUMBER(4,0)
//	STREET_ADDRESS	VARCHAR2(40 BYTE)
//	POSTAL_CODE	VARCHAR2(12 BYTE)
//	CITY	VARCHAR2(30 BYTE)
//	STATE_PROVINCE	VARCHAR2(25 BYTE)
//	COUNTRY_ID	CHAR(2 BYTE)
	
	private int locationId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private String countryId;
	
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	
}
