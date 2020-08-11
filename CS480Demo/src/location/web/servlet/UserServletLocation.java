package location.web.servlet;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

//import javax.jws.WebService;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.domain.Hospital;
import hospital.service.HospitalService;
import location.domain.Location;
import location.service.LocationService;
import user.service.UserException;
import user.service.UserService;

/**
 * Servlet implementation class UserServlet
 */

public class UserServletLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServletLocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LocationService locationservice = new LocationService();  
		Location form = new Location();	

		String address = request.getParameter("address");
		int hospital_id = Integer.parseInt(request.getParameter("hospital_id"));
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String county = request.getParameter("county");
		String zipcode = request.getParameter("zipcode");
		int state_fips = Integer.parseInt(request.getParameter("state_fips"));
		int county_fips = Integer.parseInt(request.getParameter("county_fips"));
		int fips = Integer.parseInt(request.getParameter("fips"));
        
		form.setAddress(address);
		form.setHospital_id(hospital_id);
		form.setCity(city);
		form.setState(state);
		form.setZipcode(county);
		form.setCounty(zipcode);
		form.setState_fips(state_fips);
		form.setCounty_fips(county_fips);
		form.setFips(fips);
		
		try {
			locationservice.registLocation(form);
//			request.getSession().setAttribute("session_hospital", form);
			request.getRequestDispatcher("/jsps/location/location_item.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
//		UserService userservice = new UserService();		
//		if(user.getUsername()!=null){
//			try {
//				userservice.login(user);
//				request.getSession().setAttribute("session_user", user);
//				
//				request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
//			} catch (ClassNotFoundException | UserException e) {
//				// TODO Auto-generated catch block
//				request.setAttribute("msg", e.getMessage());
//			} catch (InstantiationException e) {
//				// TODO Auto-generated catch block
//				request.setAttribute("msg", e.getMessage());
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				request.setAttribute("msg", e.getMessage());
//			} 
//		}
//		else{
//			request.setAttribute("msg", "You need to register first");
//			request.getRequestDispatcher("/jsps/user/login.jsp").forward(request, response);
//		}
		
	}

}
