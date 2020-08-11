package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

import user.domain.User;
import java.sql.Statement;

/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class initalizeDao {
	
	
	public void initDB() {
		Statement statement;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//			Connection connect1 = DriverManager
//			          .getConnection("jdbc:mysql://localhost:3306/bookstore?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");

		
		//statement allow to issue SQL queries to the database
			
//			statement = connect1.createStatement();
			 Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
			statement = connect.createStatement();
			
//			statement.executeUpdate("DROP DATABASE IF EXISTS covid_19_hospitalization");
		    statement.executeUpdate("CREATE DATABASE IF NOT EXISTS covid_19_hospitalization"); //PART 1
		    
//		    connect1.close();
		    
		   
			
			statement.executeUpdate("DROP TABLE IF EXISTS hospital");
			
			String sqlstmt1 = "CREATE TABLE IF NOT EXISTS hospital" +
							" ( hospital_name VARCHAR(100) NOT NULL," +
							" hospital_id INT PRIMARY KEY NOT NULL, " +
							" hospital_type VARCHAR(50) NOT NULL)";
			statement.executeUpdate(sqlstmt1);
			
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
			
			statement.executeUpdate("DROP TABLE IF EXISTS tb_user");
			String sqlstmt2 = "CREATE TABLE IF NOT EXISTS tb_user" +
							" ( username VARCHAR(50) primary key," +
							" `password` VARCHAR(50) NOT NULL, " +
							" email VARCHAR(50) NOT NULL)";
			statement.executeUpdate(sqlstmt2);

			
			 statement.executeUpdate("DROP TABLE IF EXISTS beds");
	            String sqlstmt3 ="CREATE TABLE IF NOT EXISTS beds" +
	    				"(hospital_id INT not null,"+
	                    "license_num INT primary key NOT NULL," + 
	                    "license_beds INT not null," + 
	                    "staffed_beds INT not null," + 
	                    "icu_beds INT not null," + 
	                    "pedi_ice_beds INT," + 
	                    "bed_utilization FLOAT(10,5)," + 
	                    "potential_increase INT not null," + 
	                    "avg_ventilator_use FLOAT(10,5))";
	                        //    "FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id)) " ;
	            statement.executeUpdate(sqlstmt3);
	            
	            PreparedStatement preparedStatement2 = connect
		          .prepareStatement("insert into  beds (hospital_id, license_num, license_beds, staffed_beds, icu_beds, pedi_ice_beds, bed_utilization, potential_increase, avg_ventilator_use) values (?,?,?,?,?,?,?,?,?)");
		      preparedStatement2.setString(1, "1");
		      preparedStatement2.setString(2, "1");
		      preparedStatement2.setString(3, "62");
		      preparedStatement2.setString(4, "62");
		      preparedStatement2.setString(5, "5");
		      preparedStatement2.setString(6, "3");
		      preparedStatement2.setString(7, "0.9472947351");
		      preparedStatement2.setString(8, "9");
		      preparedStatement2.setString(9, "5");
		      
		    preparedStatement2.executeUpdate(); // RUN A TRANSACTION
		    
		      preparedStatement2 = connect
		          .prepareStatement("insert into  beds (hospital_id, license_num, license_beds, staffed_beds, icu_beds, pedi_ice_beds, bed_utilization, potential_increase, avg_ventilator_use) values (?,?,?,?,?,?,?,?,?)");
		      preparedStatement2.setString(1, "2");
		      preparedStatement2.setString(2, "2");
		      preparedStatement2.setString(3, "295");
		      preparedStatement2.setString(4, "295");
		      preparedStatement2.setString(5, "20");
		      preparedStatement2.setString(6, "16");
		      preparedStatement2.setString(7, "0.2840275749");
		      preparedStatement2.setString(8, "44");
		      preparedStatement2.setString(9, "4");		
		    
		    preparedStatement2.executeUpdate(); // RUN A TRANSACTION
		    
	      preparedStatement2 = connect
		          .prepareStatement("insert into  beds (hospital_id, license_num, license_beds, staffed_beds, icu_beds, pedi_ice_beds, bed_utilization, potential_increase, avg_ventilator_use) values (?,?,?,?,?,?,?,?,?)");
		      preparedStatement2.setString(1, "3");
		      preparedStatement2.setString(2, "3");
		      preparedStatement2.setString(3, "54");
		      preparedStatement2.setString(4, "54");
		      preparedStatement2.setString(5, "2");
		      preparedStatement2.setString(6, "5");
		      preparedStatement2.setString(7, "0.8403820482");
		      preparedStatement2.setString(8, "13");
		      preparedStatement2.setString(9, "8");

			    preparedStatement2.executeUpdate(); // RUN A TRANSACTION         
            
	            
//	            statement.executeUpdate("DROP TABLE IF EXISTS location");
	            String sqlstmt4 = "CREATE TABLE IF NOT EXISTS location" +
	                    " (address VARCHAR(50) primary key not null, " +
	                    " hospital_id INT not null," + 
	                    " city VARCHAR(50) NOT NULL," + 
	                    " state VARCHAR(50) NOT NULL," + 
	                    " county VARCHAR(50) NOT NULL," + 
	                    " zipcode VARCHAR(50) NOT NULL," + 
	                    " state_fips INT NOT NULL, " + 
	                    " county_fips INT NOT NULL," + 
	                    " fips INT NOT NULL)";
	                            	
	                         //   " FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id) ";
	            statement.executeUpdate(sqlstmt4);
						
	            PreparedStatement preparedStatement3 = connect
				          .prepareStatement("insert into  location (address ,hospital_id, city, state, county, zipcode, state_fips, county_fips, fips) values (?,?,?,?,?,?,?,?,?)");
		          preparedStatement3.setString(1, "650 E Indian School Rd"); //addr
		          preparedStatement3.setString(2, "1");
				      preparedStatement3.setString(3, "Phoenix");
				      preparedStatement3.setString(4, "AZ");
				      preparedStatement3.setString(5, "Maricopa");
				      preparedStatement3.setString(6, "85012");
				      preparedStatement3.setString(7, "04");
				      preparedStatement3.setString(8, "013");
				      preparedStatement3.setString(9, "04013");
				      
				      preparedStatement3.executeUpdate(); // RUN A TRANSACTION
				      
			       preparedStatement3 = connect
				          .prepareStatement("insert into  location (address ,hospital_id, city, state, county, zipcode, state_fips, county_fips, fips) values (?,?,?,?,?,?,?,?,?)");
			       	  preparedStatement3.setString(1, "3601 S 6th Ave");
			          preparedStatement3.setString(2, "2");
				      preparedStatement3.setString(3, "Tucson");
				      preparedStatement3.setString(4, "AZ");
				      preparedStatement3.setString(5, "Pima");
				      preparedStatement3.setString(6, "85723");
				      preparedStatement3.setString(7, "04");
				      preparedStatement3.setString(8, "019");
				      preparedStatement3.setString(9, "04019");
				      
				      preparedStatement3.executeUpdate(); // RUN A TRANSACTION
				      
			      preparedStatement3 = connect
				          .prepareStatement("insert into  location (address ,hospital_id, city, state, county, zipcode, state_fips, county_fips, fips) values (?,?, ?, ?,?,?,?,?,?)");
			          preparedStatement3.setString(1, "2615 E Clinton Ave");			
			          preparedStatement3.setString(2, "3");
				      preparedStatement3.setString(3, "Fresno");
				      preparedStatement3.setString(4, "CA");
				      preparedStatement3.setString(5, "Fresno");
				      preparedStatement3.setString(6, "93703");
				      preparedStatement3.setString(7, "06");
				      preparedStatement3.setString(8, "019");
				      preparedStatement3.setString(9, "06019");
				      
				      preparedStatement3.executeUpdate(); // RUN A TRANSACTION      

			      
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

