package user.dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import user.domain.User;

public class InitializeDao {
		
	public void initDB() {
		
		 Statement statement;
		try {
			
			
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect1 = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/bookstore", "root","M@nUtd_is_<3#ggmu"); 
			
			statement = connect1.createStatement();
			statement.executeUpdate("DROP DATABASE IF EXISTS covid_19_hospitalization");
		    statement.executeUpdate("CREATE DATABASE IF NOT EXISTS covid_19_hospitalization"); //PART 1
		    
		    connect1.close();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization", "root","M@nUtd_is_<3#ggmu"); 
			
			statement = connect.createStatement();
	
			
//		    System.out.println("Connection - covid");//debugging purposes
		    
			//TableHOSPITAL
            statement.executeUpdate("DROP TABLE IF EXISTS HOSPITAL");
            String sqlstmt1 = "CREATE TABLE IF NOT EXISTS HOSPITAL" +
                            "(hospital_name VARCHAR(100) NOT NULL," +
                            "hospital_id INT PRIMARY KEY NOT NULL, " +
                            "hospital_type VARCHAR(100) NOT NULL)";
            statement.executeUpdate(sqlstmt1);

		          //HOSPITAL
		            PreparedStatement preparedStatement = connect
		                    .prepareStatement("insert into  hospital (hospital_name, hospital_id, hospital_type) values (?, ?, ?)");
		                preparedStatement.setString(1, "Phoenix VA Health Care System (AKA Carl T Hayden VA Medical Center)");
		                preparedStatement.setString(2, "1");
		                preparedStatement.setString(3, "VA Hospital");
		                preparedStatement.executeUpdate(); // RUN A TRANSACTION
		
		                preparedStatement = connect
		                        .prepareStatement("insert into  hospital (hospital_name, hospital_id, hospital_type) values (?, ?, ?)");
		                preparedStatement.setString(1, "Southern Arizona VA Health Care System");
		                preparedStatement.setString(2, "2");
		                preparedStatement.setString(3, "VA Hospital");
		                preparedStatement.executeUpdate(); // RUN A TRANSACTION
		
		                preparedStatement = connect
		                    .prepareStatement("insert into  hospital (hospital_name, hospital_id, hospital_type) values (?, ?, ?)");
		                preparedStatement.setString(1, "VA Central California Health Care System");
		                preparedStatement.setString(2, "3");
		                preparedStatement.setString(3, "VA Hospital");
		                preparedStatement.executeUpdate(); // RUN A TRANSACTION
            
            
            
            
            //TableLOCATION
            statement.executeUpdate("DROP TABLE IF EXISTS location");
            String sqlstmt2 = "CREATE TABLE IF NOT EXISTS location" +
                            "(address VARCHAR(50) primary key not null, " +
                            "hospital_id INT not null," + 
                            "city VARCHAR(50) NOT NULL," + 
                            "state VARCHAR(50) NOT NULL," + 
                            "county VARCHAR(50) NOT NULL," + 
                            "zipcode VARCHAR(50) NOT NULL," + 
                            "state_fips INT NOT NULL, " + 
                            "county_fips INT NOT NULL," + 
                            "fips INT NOT NULL)"; 
//            				+ "FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id) ) ";
            statement.executeUpdate(sqlstmt2);

					        	//LOCATION
					         preparedStatement = connect
							          .prepareStatement("insert into  location (address ,hospital_id, city, state, county, zipcode, state_fips, county_fips, fips) values (?,?,?,?,?,?,?,?,?)");
					          preparedStatement.setString(1, "650 E Indian School Rd"); //addr
					          preparedStatement.setString(2, "1");
							      preparedStatement.setString(3, "Phoenix");
							      preparedStatement.setString(4, "AZ");
							      preparedStatement.setString(5, "Maricopa");
							      preparedStatement.setString(6, "85012");
							      preparedStatement.setString(7, "04");
							      preparedStatement.setString(8, "013");
							      preparedStatement.setString(9, "04013");
							      
							      preparedStatement.executeUpdate(); // RUN A TRANSACTION
							      
						       preparedStatement = connect
							          .prepareStatement("insert into  location (address ,hospital_id, city, state, county, zipcode, state_fips, county_fips, fips) values (?,?,?,?,?,?,?,?,?)");
						       	  preparedStatement.setString(1, "3601 S 6th Ave");
						          preparedStatement.setString(2, "2");
							      preparedStatement.setString(3, "Tucson");
							      preparedStatement.setString(4, "AZ");
							      preparedStatement.setString(5, "Pima");
							      preparedStatement.setString(6, "85723");
							      preparedStatement.setString(7, "04");
							      preparedStatement.setString(8, "019");
							      preparedStatement.setString(9, "04019");
							      
							      preparedStatement.executeUpdate(); // RUN A TRANSACTION
							      
						      preparedStatement = connect
							          .prepareStatement("insert into  location (address ,hospital_id, city, state, county, zipcode, state_fips, county_fips, fips) values (?,?, ?, ?,?,?,?,?,?)");
						          preparedStatement.setString(1, "2615 E Clinton Ave");			
						          preparedStatement.setString(2, "3");
							      preparedStatement.setString(3, "Fresno");
							      preparedStatement.setString(4, "CA");
							      preparedStatement.setString(5, "Fresno");
							      preparedStatement.setString(6, "93703");
							      preparedStatement.setString(7, "06");
							      preparedStatement.setString(8, "019");
							      preparedStatement.setString(9, "06019");
							      
							      preparedStatement.executeUpdate(); // RUN A TRANSACTION
         
            
            //TableBEDS
            statement.executeUpdate("DROP TABLE IF EXISTS beds");
            String sqlstmt3 = "CREATE TABLE IF NOT EXISTS beds" +
                            "(license_num INT primary key NOT NULL," + 
                            "license_beds INT not null," + 
                            "staffed_beds INT not null," + 
                            "icu_beds INT not null," + 
                            "pedi_ice_beds INT," + 
                            "bed_utilization DECIMAL," + 
                            "potential_increase INT not null," + 
                            "avg_ventilator_use decimal," + 
                            "hospital_id INT not null)" ; 
                            //+"FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id)) " ;
            statement.executeUpdate(sqlstmt3);

		            	//BEDS
					     preparedStatement = connect
					          .prepareStatement("insert into  beds (hospital_id, license_num, license_beds, staffed_beds, icu_beds, pedi_ice_beds, bed_utilization, potential_increase, avg_ventilator_use) values (?,?,?,?,?,?,?,?,?)");
					      preparedStatement.setString(1, "1");
					      preparedStatement.setString(2, "1");
					      preparedStatement.setString(3, "62");
					      preparedStatement.setString(4, "62");
					      preparedStatement.setString(5, "0");
					      preparedStatement.setString(6, "0");
					      preparedStatement.setString(7, "0");
					      preparedStatement.setString(8, "0");
					      preparedStatement.setString(9, "0");
					      
					    preparedStatement.executeUpdate(); // RUN A TRANSACTION
					    
					      preparedStatement = connect
					          .prepareStatement("insert into  beds (hospital_id, license_num, license_beds, staffed_beds, icu_beds, pedi_ice_beds, bed_utilization, potential_increase, avg_ventilator_use) values (?,?,?,?,?,?,?,?,?)");
					      preparedStatement.setString(1, "2");
					      preparedStatement.setString(2, "2");
					      preparedStatement.setString(3, "295");
					      preparedStatement.setString(4, "295");
					      preparedStatement.setString(5, "2");
					      preparedStatement.setString(6, "0");
					      preparedStatement.setString(7, "0");
					      preparedStatement.setString(8, "0");
					      preparedStatement.setString(9, "2");		
					    
					    preparedStatement.executeUpdate(); // RUN A TRANSACTION
					    
				      preparedStatement = connect
					          .prepareStatement("insert into  beds (hospital_id, license_num, license_beds, staffed_beds, icu_beds, pedi_ice_beds, bed_utilization, potential_increase, avg_ventilator_use) values (?,?,?,?,?,?,?,?,?)");
					      preparedStatement.setString(1, "3");
					      preparedStatement.setString(2, "3");
					      preparedStatement.setString(3, "54");
					      preparedStatement.setString(4, "54");
					      preparedStatement.setString(5, "2");
					      preparedStatement.setString(6, "0");
					      preparedStatement.setString(7, "0");
					      preparedStatement.setString(8, "0");
					      preparedStatement.setString(9, "2");
		
						    preparedStatement.executeUpdate(); // RUN A TRANSACTION            
            
            
            
            
            
            
            statement.executeUpdate("DROP TABLE IF EXISTS tb_user"); //PART2
            String sqlstmt4 = "CREATE TABLE IF NOT EXISTS tb_user" +
                            " ( username VARCHAR(50) primary key," +
                            " password VARCHAR(50) NOT NULL, " +
                            " email VARCHAR(50) NOT NULL)";
            statement.executeUpdate(sqlstmt4);
 
			          				      
			      			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
		
}
