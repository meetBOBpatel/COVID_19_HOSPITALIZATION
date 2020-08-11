package location.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dao.HospitalDao;
import hospital.domain.Hospital;
import hospital.service.HospitalService;
import location.domain.Location;
import location.service.LocationService;
import user.domain.User;
import user.service.UserService;

/**
 * Servlet implementation class findAll
 */

public class updateLocation extends HttpServlet {
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
		LocationService locationservice = new LocationService();
		try {
			String address = request.getParameter("address");
			int hospital_id = Integer.parseInt(request.getParameter("hospital_id"));
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String county = request.getParameter("county");
			String zipcode = request.getParameter("zipcode");
			int state_fips = Integer.parseInt(request.getParameter("state_fips"));
			int county_fips = Integer.parseInt(request.getParameter("county_fips"));
			int fips = Integer.parseInt(request.getParameter("fips"));
			
			
			
			Location loc = new Location(address, hospital_id, city, state, county, zipcode, state_fips, county_fips, fips);
			
			locationservice.updateLocation(loc);
		
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			List<Object> li = locationservice.findallLocations();
//			for(int i = 0; i < li.size();i++){
//				System.out.println(li.get(i).toString());
//			}
//			
//		} catch (InstantiationException | IllegalAccessException
//				| ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		request.getRequestDispatcher("/jsps/location/location_item.jsp").forward(request, response);
	}

}
