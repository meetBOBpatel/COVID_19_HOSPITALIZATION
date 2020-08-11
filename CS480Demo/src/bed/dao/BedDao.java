package bed.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import bed.domain.Bed;
import hospital.domain.Hospital;
import user.domain.User;



/**
 * CRUD for Bed information
 *
 */
public class BedDao {
	
	
	/**
	 * get the search result with License Number 
	 * @param license_num
	 * @return Bed
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Bed findByBedLicenseNum(int license_num) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Bed bed = new Bed();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");

		    String sql = "select * from beds where license_num = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,license_num);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	int id = resultSet.getInt("license_num");
		    	if(id == license_num){
		    		bed.setLicense_num(resultSet.getInt("license_num"));
		    		bed.setHospital_id(resultSet.getInt("hospital_id"));  		
		    		bed.setLicense_beds(resultSet.getInt("license_beds"));
		    		bed.setStaffed_beds(resultSet.getInt("staffed_beds"));
		    		bed.setIcu_beds(resultSet.getInt("icu_beds"));
		    		bed.setPedi_ice_beds(resultSet.getInt("pedi_ice_beds"));
		    		bed.setBed_utilization(resultSet.getFloat("bed_utilization"));  		
		    		bed.setPotential_increase(resultSet.getInt("potential_increase"));
		    		bed.setAvg_ventilator_use(resultSet.getFloat("avg_ventilator_use"));
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return bed;
	}
	
	
	
	
	/**
	 * insert Bed
	 * @param bed
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException  
	 */
	public void addBed(Bed bed) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
								
			String sql = "insert into beds values(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,bed.getHospital_id());
		    preparestatement.setInt(2,bed.getLicense_num());
		    preparestatement.setInt(3,bed.getLicense_beds());
		    preparestatement.setInt(4,bed.getStaffed_beds());
		    preparestatement.setInt(5,bed.getIcu_beds());
		    preparestatement.setInt(6,bed.getPedi_ice_beds());
		    preparestatement.setFloat(7,bed.getBed_utilization());
		    preparestatement.setInt(8,bed.getPotential_increase());
		    preparestatement.setFloat(9,bed.getAvg_ventilator_use());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	/**
	 * delete Bed
	 * @param bed
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException  
	 */
	// returns void and not boolean 
	public void deleteBed(Bed bed) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");	
			
			String sql = "delete from beds where license_num = ?";
			
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,bed.getLicense_num());
//		    boolean deleteBed = 
		    preparestatement.executeUpdate();
//		    return deleteBed;
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
	/**
	 * Update Bed
	 * @param bed
	 * @return void
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException  
	 */
	// returns void and not boolean 
	public void updateBed(Bed bed) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
								
			String sql = "update beds set hospital_id = ?, license_num = ?, license_beds = ?,  staffed_beds = ?, icu_beds = ?, pedi_ice_beds = ?, bed_utilization = ?, potential_increase = ?, avg_ventilator_use = ? where license_num = ?";
			
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setInt(1,bed.getHospital_id());
		    preparestatement.setInt(2,bed.getLicense_num());
		    preparestatement.setInt(3,bed.getLicense_beds());
		    preparestatement.setInt(4,bed.getStaffed_beds());
		    preparestatement.setInt(5,bed.getIcu_beds());
		    preparestatement.setInt(6,bed.getPedi_ice_beds());
		    preparestatement.setFloat(7,bed.getBed_utilization());
		    preparestatement.setInt(8,bed.getPotential_increase());
		    preparestatement.setFloat(9,bed.getAvg_ventilator_use());
			preparestatement.setInt(10,bed.getLicense_num());

//		    boolean updated = 
		    preparestatement.executeUpdate(); 
//		    return updated;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	
	
	
	
	/**
	 * find all bed info from table
	 * @return List of beds
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException  
	 */
	public List<Object> findallBeds() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");

			
			String sql = "select * from beds";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Bed bed = new Bed();
	    		bed.setLicense_num(resultSet.getInt("license_num"));
	    		bed.setHospital_id(resultSet.getInt("hospital_id"));  		
	    		bed.setLicense_beds(resultSet.getInt("license_beds"));
	    		bed.setStaffed_beds(resultSet.getInt("staffed_beds"));
	    		bed.setIcu_beds(resultSet.getInt("icu_beds"));
	    		bed.setPedi_ice_beds(resultSet.getInt("pedi_ice_beds"));
	    		bed.setBed_utilization(resultSet.getFloat("bed_utilization"));  		
	    		bed.setPotential_increase(resultSet.getInt("potential_increase"));
	    		bed.setAvg_ventilator_use(resultSet.getFloat("avg_ventilator_use"));
	    		
	    		list.add(bed);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
		
}
