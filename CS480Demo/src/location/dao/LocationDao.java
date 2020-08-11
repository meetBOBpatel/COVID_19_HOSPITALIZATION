package location.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import hospital.domain.Hospital;
import location.domain.Location;
import user.domain.User;



/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class LocationDao {
	
	
	/**
	 * get the search result with hospital_id 
	 * @param hospital_id
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Location findByLocationAddress(String address) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Location loc = new Location();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");

			
		    String sql = "select * from location where address = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,address);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String adr = resultSet.getString("address");
		    	if(adr.equals(address) ){
		    		loc.setAddress(resultSet.getString("address"));
		    		loc.setHospital_id(resultSet.getInt("hospital_id"));
		    		loc.setCity(resultSet.getString("city"));  
		    		loc.setState(resultSet.getString("state"));
		    		loc.setCounty(resultSet.getString("county"));
		    		loc.setZipcode(resultSet.getString("zipcode"));  
		    		loc.setState_fips(resultSet.getInt("state_fips"));
		    		loc.setCounty_fips(resultSet.getInt("county_fips"));
		    		loc.setFips(resultSet.getInt("fips"));  
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
		return loc;
	}
	
	
	
	
	/**
	 * insert Hospital
	 * @param Bed
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException  
	 */
	public void addLocation(Location loc) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
								
			String sql = "insert into location values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			
		    preparestatement.setString(1,loc.getAddress());
		    preparestatement.setInt(2,loc.getHospital_id());
		    preparestatement.setString(3,loc.getCity());
		    preparestatement.setString(4,loc.getState());
		    preparestatement.setString(5,loc.getCounty());
		    preparestatement.setString(6,loc.getZipcode());
		    preparestatement.setInt(7,loc.getState_fips());
		    preparestatement.setInt(8,loc.getCounty_fips());
		    preparestatement.setInt(9,loc.getFips());
		    
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	/**
	 * delete Hospital
	 * @param Bed
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException  
	 */
	public boolean deleteLocation(Location loc) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
								
			String sql = "delete from location where address = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    
			preparestatement.setString(1,loc.getAddress());
		    
			boolean deleteLoc = preparestatement.executeUpdate() > 0;
		    return deleteLoc;
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
	/**
	 * delete Hospital
	 * @param Bed
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException  
	 */
	public boolean updateLocation(Location loc) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
								
			String sql = "update location set address = ?, hospital_id = ?, city = ?, "
										   + "state = ?, county = ?, zipcode = ?, "
										   + "state_fips = ?, county_fips = ?, fips = ?" 
										   + " where address = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 

		    preparestatement.setString(1,loc.getAddress());
		    preparestatement.setInt(2,loc.getHospital_id());
		    preparestatement.setString(3,loc.getCity());
		    preparestatement.setString(4,loc.getState());
		    preparestatement.setString(5,loc.getCounty());
		    preparestatement.setString(6,loc.getZipcode());
		    preparestatement.setInt(7,loc.getState_fips());
		    preparestatement.setInt(8,loc.getCounty_fips());
		    preparestatement.setInt(9,loc.getFips());
			
			
		    preparestatement.setString(10,loc.getAddress());

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
	public List<Object> findallLocations() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");

			
			String sql = "select * from location";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Location loc = new Location();
	    		loc.setAddress(resultSet.getString("address"));
	    		loc.setHospital_id(resultSet.getInt("hospital_id"));
	    		loc.setCity(resultSet.getString("city"));  
	    		loc.setState(resultSet.getString("state"));
	    		loc.setCounty(resultSet.getString("county"));
	    		loc.setZipcode(resultSet.getString("zipcode"));  
	    		loc.setState_fips(resultSet.getInt("state_fips"));
	    		loc.setCounty_fips(resultSet.getInt("county_fips"));
	    		loc.setFips(resultSet.getInt("fips")); 
	    		
	    		list.add(loc);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
		
}
