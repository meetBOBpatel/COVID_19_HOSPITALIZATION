package bed.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bed.domain.Bed;
import bed.service.BedService;
import hospital.dao.HospitalDao;
import hospital.domain.Hospital;
import hospital.service.HospitalService;
import user.domain.User;
import user.service.UserService;

/**
 * Servlet implementation class findAll
 */

public class updateBed extends HttpServlet {
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
	 BedService bedservice = new BedService();
		try {
			int license_num = Integer.parseInt(request.getParameter("license_num"));
			int license_beds = Integer.parseInt(request.getParameter("license_beds"));
			int staffed_beds = Integer.parseInt(request.getParameter("staffed_beds"));
			int icu_beds = Integer.parseInt(request.getParameter("icu_beds"));
			int pedi_ice_beds = Integer.parseInt(request.getParameter("pedi_ice_beds"));
			float bed_utilization = Float.parseFloat(request.getParameter("bed_utilization"));
			int potential_increase = Integer.parseInt(request.getParameter("potential_increase"));
			float avg_ventilator_use = Float.parseFloat(request.getParameter("avg_ventilator_use"));
			int hospital_id = Integer.parseInt(request.getParameter("hospital_id"));

			
			
			Bed bed = new Bed(license_num, license_beds, staffed_beds, icu_beds, pedi_ice_beds,
				 bed_utilization, potential_increase, avg_ventilator_use, hospital_id);
			
			bedservice.updateBed(bed);
		
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			List<Object> li = bedservice.findallBeds();
//			for(int i = 0; i < li.size();i++){
//				System.out.println(li.get(i).toString());
//			}
//			
//		} catch (InstantiationException | IllegalAccessException
//				| ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
		request.getRequestDispatcher("/jsps/bed/bed_item.jsp").forward(request, response);
	}

}
