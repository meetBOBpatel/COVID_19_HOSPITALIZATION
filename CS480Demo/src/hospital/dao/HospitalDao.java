package hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import hospital.domain.Hospital;
import user.domain.User;



/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class HospitalDao {
	
	
	/**
	 * get the search result with hospital_id 
	 * @param hospital_id
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Hospital findByHospitalID(int hospital_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Hospital hosp = new Hospital();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");

			
		    String sql = "select * from hospital where hospital_id = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,hospital_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	int id = resultSet.getInt("hospital_id");
		    	if(id == hospital_id){
		    		hosp.setHospital_name(resultSet.getString("hospital_name"));
		    		hosp.setHospital_id(resultSet.getInt("hospital_id"));
		    		hosp.setHospital_type(resultSet.getString("hospital_type"));  		
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
//		System.out.println("");
//		System.out.println("");
//		System.out.println("Hospital ID: " + hosp.getHospital_id());
//		System.out.println("Hospital NAME: " + hosp.getHospital_name());
//		System.out.println("Hospital TYPE: " + hosp.getHospital_type());
//		System.out.println("");
//		System.out.println("");		
//		
		return hosp;
	}
	
	
	
	
	/**
	 * insert Hospital
	 * @param Location
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException  
	 */
	public void addHospital(Hospital hosp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
								
			String sql = "insert into hospital values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,hosp.getHospital_name());
		    preparestatement.setInt(2,hosp.getHospital_id());
		    preparestatement.setString(3,hosp.getHospital_type());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	/**
	 * delete Hospital
	 * @param Location
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException  
	 */
	public boolean deleteHospital(Hospital hosp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
								
			String sql = "delete from hospital where hospital_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,hosp.getHospital_id());
		    boolean deleteHosp = preparestatement.executeUpdate() > 0;
		    return deleteHosp;
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
	/**
	 * delete Hospital
	 * @param Location
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException  
	 */
	public boolean updateHospital(Hospital hosp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
								
			String sql = "update hospital set hospital_name = ?, hospital_id = ?, hospital_type = ? where hospital_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,hosp.getHospital_name());
		    preparestatement.setInt(2,hosp.getHospital_id());
		    preparestatement.setString(3,hosp.getHospital_type());
		    preparestatement.setInt(4,hosp.getHospital_id());
		    boolean updated = preparestatement.executeUpdate() > 0; 
		    return updated;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	
	
	
	
	/**
	 * findall Hospital info from table
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException  
	 */
	public List<Object> findallHospitals() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");

			
			String sql = "select * from hospital";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Hospital hosp = new Hospital();
				hosp.setHospital_name(resultSet.getString("hospital_name"));
	    		hosp.setHospital_id(resultSet.getInt("hospital_id"));
	    		hosp.setHospital_type(resultSet.getString("hospital_type"));
	    		list.add(hosp);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
		
}
