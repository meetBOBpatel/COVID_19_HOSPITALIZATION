package location.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Location {
	/*
	 * Correspond to the user table
	 */
	
	private String address;
	private int hospital_id;
	private String city; 
	private String state;
	private String county; 
	private String zipcode;
	private int state_fips;
	private int county_fips; 
	private int fips;
		
	public Location() {
		
	}
	
	public Location(String address, int hospital_id, String city, String state, String county, String zipcode,
			int state_fips, int county_fips, int fips) {
		this.address = address;
		this.hospital_id = hospital_id;
		this.city = city;
		this.state = state;
		this.county = county;
		this.zipcode = zipcode;
		this.state_fips = state_fips;
		this.county_fips = county_fips;
		this.fips = fips;
	}
	
	public Location(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
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
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public int getState_fips() {
		return state_fips;
	}
	public void setState_fips(int state_fips) {
		this.state_fips = state_fips;
	}
	public int getCounty_fips() {
		return county_fips;
	}
	public void setCounty_fips(int county_fips) {
		this.county_fips = county_fips;
	}
	public int getFips() {
		return fips;
	}
	public void setFips(int fips) {
		this.fips = fips;
	}
	
	
	

}
