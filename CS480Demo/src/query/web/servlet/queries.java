package query.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;

import user.domain.User;
import user.service.UserService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;

import bed.domain.Bed;
import hospital.domain.Hospital;

/**
 * Servlet implementation class findAll
 */

public class queries extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");

        
        try {
            switch (action) {
            case "/query_1":
                System.out.println(action);
                query1(request,response);
                break;
            case "/query_2":
                System.out.println(action);
                query2(request,response);
                break;
            case "/query_3":
                System.out.println(action);
                query3(request,response);
                break;
            case "/query_4":
                System.out.println(action);
                query4(request,response);
                break;
            case "/query_5":
                System.out.println(action);
                query5(request,response);
                break;    
            case "/query_6":
                System.out.println(action);
                query6(request,response);
                break;    
            case "/query_7":
                System.out.println(action);
                query7(request,response);
                break;
            case "/query_8":
                System.out.println(action);
                query8(request,response);
                break;
            default:
                System.out.println("Default");
                break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }


	}
	
	protected void query1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
            Statement stmt = connect.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT hospital_name AS Hospital_Name FROM hospital WHERE hospital_type = 'VA Hospital' OR hospital_type = 'Short Term Acute Care Hospital';");  
            out.println("<table border=1 width=70% height=50%>");  
            out.println("<tr><th>Hospital_Name</th><tr>");  
            while (rs.next()) 
            {

                String n = rs.getString("hospital_name");    
                out.println("<tr><td>" + n + "</td></tr>");   
            }
            
            out.println("</table>");  
            out.println("</html></body>"); 
            
            connect.close();  
        }  
            catch (Exception e) 
           {  
            out.println("error");  
           }
		
	}
	
	protected void query2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
            Statement stmt = connect.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT COUNT(license_beds) FROM beds WHERE license_beds > 100;");  
            out.println("<table border=1 width=10% height=10%>");
            out.println("<style>\n" + 
            		"	body{\n" + 
            		"	\n" + 
            		"		background: coral;		\n" + 
            		"	}\n" + 
            		"</style>");
            out.println("<tr><th>COUNT(license_beds)</th><tr>");  
            while (rs.next()) 
            {

                int nm = rs.getInt("COUNT(license_beds)");     
                out.println("<tr><td>" + nm + "</td></tr>");   
            }
            
            out.println("</table>");  
            out.println("</html></body>"); 
            
            connect.close();  
        }  
            catch (Exception e) 
           {  
            out.println("error");  
           }
		
	}
	
	protected void query3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
            Statement stmt = connect.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT hospital_id, county FROM location WHERE state = 'Alabama'ORDER BY county DESC;");  
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>hospital_id</th><th>county</th><tr>");  
            while (rs.next()) 
            {

                String n = rs.getString("county");  

                int nm = rs.getInt("hospital_id");  
   
                out.println("<tr><td>" + nm + "</td><td>" + n + "</td></tr>");   
            }
            
            out.println("</table>");  
            out.println("</html></body>"); 
            
            connect.close();  
        }  
            catch (Exception e) 
           {  
            out.println("error");  
           }
		
	}
	
	protected void query4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
            Statement stmt = connect.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT h.hospital_name, CONCAT_WS(', ',address, county, city, state, zipcode) AS Address FROM hospital h NATURAL JOIN location l where l.state = 'Alabama';");  
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Hospital Name</th><th>Address</th><tr>");  
            while (rs.next()) 
            {

                String n = rs.getString("h.hospital_name");  

                String s = rs.getString("Address");   
                out.println("<tr><td>" + n + "</td><td>" + s + "</td></tr>");   
            }
            
            out.println("</table>");  
            out.println("</html></body>"); 
            
            connect.close();  
        }  
            catch (Exception e) 
           {  
            out.println("error");  
           }
		
	}
	
	protected void query5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
            Statement stmt = connect.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT h.hospital_type, AVG(license_beds) as Average_Beds_Capacity\n" + 
            		"FROM hospital h JOIN beds b ON h.hospital_id = b.hospital_id\n" + 
            		"GROUP BY h.hospital_type");  
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Hospital Type</th><th>Average Beds</th><tr>");  
            while (rs.next()) 
            {

                String n = rs.getString("hospital_type");  
                float nm = rs.getFloat("Average_Beds_Capacity");  
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><tr>");   
            }
            
            out.println("</table>");  
            out.println("</html></body>"); 
            
            connect.close();  
        }  
            catch (Exception e) 
           {  
            out.println("error");  
           }
		
	}
	
	protected void query6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
            Statement stmt = connect.createStatement();  
            ResultSet rs = stmt.executeQuery(
            		"SELECT h.hospital_name, l.county, b.bed_utilization\n" + 
            		"FROM hospital h \n" + 
            		"JOIN location l ON h.hospital_id = l.hospital_id\n" + 
            		"JOIN beds b ON l.hospital_id = b.hospital_id\n" + 
            		"WHERE l.state = 'Alabama'\n" + 
            		"ORDER BY bed_utilization DESC\n" + 
            		"LIMIT 3");  
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Hospital Name</th><th>County</th><th>Bed Utilization</th><tr>");  
            while (rs.next()) 
            {

                String n = rs.getString("hospital_name");  
                System.out.print(n);
                String nm = rs.getString("county");  
                System.out.print(nm);
                float s = rs.getFloat("bed_utilization");   
                System.out.print(s);
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");   
            }
            
            out.println("</table>");  
            out.println("</html></body>"); 
            
            connect.close();  
        }  
            catch (Exception e) 
           {  
            out.println("error");  
           }
		
	}
	
	protected void query7(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
            Statement stmt = connect.createStatement();  
            ResultSet rs = stmt.executeQuery(
            		"SELECT h.hospital_name, CONCAT_WS(', ',address, county, city, state, zipcode) AS Address, h.hospital_type, (b.license_beds - b.staffed_beds) as Diff\n" + 
            		"FROM hospital h\n" + 
            		"NATURAL JOIN beds b \n" + 
            		"NATURAL JOIN location l\n" + 
            		"JOIN (SELECT h1.hospital_type, avg(license_beds - staffed_beds) as average\n" + 
            		"	   FROM beds b1 \n" + 
            		"      JOIN hospital h1 ON b1.hospital_id = h1.hospital_id\n" + 
            		"      GROUP BY h1.hospital_type) as sT on h.hospital_type = sT.hospital_type  \n" + 
            		"WHERE (b.license_beds - b.staffed_beds) < sT.average;\n");
            
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Hospital Name</th><th>Address</th><th>Hospital Type</th><th>Bed Difference</th><tr>");  
            while (rs.next()) 
            {

                String n = rs.getString("hospital_name");  
                
                String nm = rs.getString("Address");  

                String nmm = rs.getString("hospital_type");  

                int nmmm = rs.getInt("Diff");  
   
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + nmm + "</td><td>" + nmmm + "</td></tr>");   
            }
            
            out.println("</table>");  
            out.println("</html></body>"); 
            
            connect.close();  
        }  
            catch (Exception e) 
           {  
            out.println("error");  
           }
		
	}
	
	protected void query8(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>");
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/covid_19_hospitalization?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "root" ,"yeshmeet123");
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT l.state AS State ,count(hospital_name) as NumberOfHospitals FROM hospital h JOIN location l WHERE h.hospital_id = l.hospital_id GROUP BY State ORDER BY NumberOfHospitals ASC;");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>State</th><th>NumberOfHospitals</th><tr>");
            while (rs.next()) 
            {

                String n = rs.getString("State");

                int nm = rs.getInt("NumberOfHospitals");

                out.println("<tr><td>" + n + "</td><td>" + nm + "</td></tr>");
            }

            out.println("</table>");
            out.println("</html></body>"); 

            connect.close();
        }
            catch (Exception e) 
           {
            out.println("error");
           }

    }

}
