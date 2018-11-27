package io.app.model;

public class AccountsFilter {
	
	private String filterType;
	private String zipCode;
	private String city;
	private String state;
	private double latitude;
	private double longitude;
	
	public String getFilterType() {
		return filterType;
	}
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}	
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "AccountFilter [filterType=" + filterType + ", zipCode=" + zipCode + ", city=" + city + ", state="
				+ state + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
