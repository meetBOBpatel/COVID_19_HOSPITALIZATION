package hospital.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Hospital {
	/*
	 * Correspond to the user table
	 */
	
	private int hospital_id;
	private String hospital_name; 
	private String hospital_type;
	
	public Hospital() {
		
	}
	
	public Hospital(int hospital_id, String hospital_name, String hospital_type){
		this.hospital_name = hospital_name;
		this.hospital_id = hospital_id;
		this.hospital_type = hospital_type;
		
	}
	
	public Hospital(int hospital_id) {
	        this.hospital_id = hospital_id;
	}

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String getHospital_type() {
		return hospital_type;
	}

	public void setHospital_type(String hospital_type) {
		this.hospital_type = hospital_type;
	}


	
//	@Override
//	public String toString() {
//		return "User [ id=" + hospital_id + ", name="
//				+ hospital_name + ", type=" + hospital_type +"]";
//	}
}
