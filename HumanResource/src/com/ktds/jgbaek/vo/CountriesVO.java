package com.ktds.jgbaek.vo;

public class CountriesVO {
	
//	COUNTRY_ID	CHAR(2 BYTE)
//	COUNTRY_NAME	VARCHAR2(40 BYTE)
//	REGION_ID	NUMBER
	
	private String countryId;
	private String countryName;
	private int regionId;
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	
	

}
