package bed.domain;

/**
 * Bed object
 * 
 * @author Meet
 * @author Varun
 * 
 */
public class Bed {
	/*
	 * Correspond to the user table
	 */
	
	private int license_num;
	private int license_beds; 
	private int staffed_beds;
	private int icu_beds;
	private int pedi_ice_beds; 
	private float bed_utilization;
	private int potential_increase;
	private float avg_ventilator_use; 
	private int hospital_id;
	
	public Bed() {
		
	}
	
	public Bed(int license_num) {
	        this.license_num = license_num;
	}
	
	public Bed(int license_num, int license_beds, int staffed_beds, int icu_beds, int pedi_ice_beds,
			float bed_utilization, int potential_increase, float avg_ventilator_use, int hospital_id) {
		this.license_num = license_num;
		this.license_beds = license_beds;
		this.staffed_beds = staffed_beds;
		this.icu_beds = icu_beds;
		this.pedi_ice_beds = pedi_ice_beds;
		this.bed_utilization = bed_utilization;
		this.potential_increase = potential_increase;
		this.avg_ventilator_use = avg_ventilator_use;
		this.hospital_id = hospital_id;
	}

	public int getLicense_num() {
		return license_num;
	}

	public void setLicense_num(int license_num) {
		this.license_num = license_num;
	}

	public int getLicense_beds() {
		return license_beds;
	}

	public void setLicense_beds(int license_beds) {
		this.license_beds = license_beds;
	}

	public int getStaffed_beds() {
		return staffed_beds;
	}

	public void setStaffed_beds(int staffed_beds) {
		this.staffed_beds = staffed_beds;
	}

	public int getIcu_beds() {
		return icu_beds;
	}

	public void setIcu_beds(int icu_beds) {
		this.icu_beds = icu_beds;
	}

	public int getPedi_ice_beds() {
		return pedi_ice_beds;
	}

	public void setPedi_ice_beds(int pedi_ice_beds) {
		this.pedi_ice_beds = pedi_ice_beds;
	}

	public float getBed_utilization() {
		return bed_utilization;
	}

	public void setBed_utilization(float bed_utilization) {
		this.bed_utilization = bed_utilization;
	}

	public int getPotential_increase() {
		return potential_increase;
	}

	public void setPotential_increase(int potential_increase) {
		this.potential_increase = potential_increase;
	}

	public float getAvg_ventilator_use() {
		return avg_ventilator_use;
	}

	public void setAvg_ventilator_use(float avg_ventilator_use) {
		this.avg_ventilator_use = avg_ventilator_use;
	}

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}



	






	
//	@Override
//	public String toString() {
//		return "User [ id=" + hospital_id + ", name="
//				+ hospital_name + ", type=" + hospital_type +"]";
//	}
}
