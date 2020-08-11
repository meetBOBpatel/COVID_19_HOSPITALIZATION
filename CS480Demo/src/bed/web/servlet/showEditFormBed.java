package bed.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bed.service.BedService;
import hospital.dao.HospitalDao;
import hospital.domain.Hospital;
import hospital.service.HospitalService;
import user.domain.User;
import user.service.UserService;

/**
 * Servlet implementation class findAll
 */

public class showEditFormBed extends HttpServlet {
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
						
			int id = Integer.parseInt(request.getParameter("license_num"));		
			request.setAttribute("bedInfo", bedservice.findByBedLicenseNum(id));
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			List<Object> li = hospitalservice.findallHospitals();
////			for(int i = 0; i < li.size();i++){
////				System.out.println(li.get(i).toString());
////			}
//			
//		} catch (InstantiationException | IllegalAccessException
//				| ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		request.getRequestDispatcher("/jsps/bed/bed_edit.jsp").forward(request, response);
	}

}
