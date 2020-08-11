package bed.web.servlet;

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

import bed.domain.Bed;
import bed.service.BedService;
import hospital.domain.Hospital;
import hospital.service.HospitalService;
import user.service.UserException;

/**
 * Servlet implementation class UserServlet
 */

public class UserServletBed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServletBed() {
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
		//Map<String, String> form = new HashMap<String,String>();
		//Map<String,String[]> paramMap = request.getParameterMap();  
		//List<String> infoString = new ArrayList<String>();
		
		BedService bedservice = new BedService();  
		Bed form = new Bed();	

		int license_num = Integer.parseInt(request.getParameter("license_num"));
		int license_beds = Integer.parseInt(request.getParameter("license_beds"));
		int staffed_beds = Integer.parseInt(request.getParameter("staffed_beds"));
		int icu_beds = Integer.parseInt(request.getParameter("icu_beds"));
		int pedi_ice_beds = Integer.parseInt(request.getParameter("pedi_ice_beds"));
		float bed_utilization = Float.parseFloat(request.getParameter("bed_utilization"));
		int potential_increase = Integer.parseInt(request.getParameter("potential_increase"));
		float avg_ventilator_use = Float.parseFloat(request.getParameter("avg_ventilator_use"));
		int hospital_id = Integer.parseInt(request.getParameter("hospital_id"));
		
		System.out.print("NUM = " + license_num);
        
		form.setLicense_num(license_num);
		form.setLicense_beds(license_beds);
		form.setStaffed_beds(staffed_beds);
		form.setIcu_beds(icu_beds);
		form.setPedi_ice_beds(pedi_ice_beds);
		form.setBed_utilization(bed_utilization);
		form.setPotential_increase(potential_increase);
		form.setAvg_ventilator_use(avg_ventilator_use);
		form.setHospital_id(hospital_id);
		
		try {
			bedservice.registBed(form);
			//request.getSession().setAttribute("session_hospital", form);
			request.getRequestDispatcher("/jsps/bed/bed_item.jsp").forward(request, response);
			
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
		
	}

}
