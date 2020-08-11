package hospital.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.service.HospitalService;

/**
 * Servlet implementation class findAll
 */

public class findAllHospitals extends HttpServlet {
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
		HospitalService hospitalservice = new HospitalService();
		try {
			request.setAttribute("HospitalList", hospitalservice.findallHospitals());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			System.out.println("SHOWING DATABASE FOR HOSPITAL");
//			System.out.println("This is before printing");
//			System.out.println("");
//			
			List<Object> lists = hospitalservice.findallHospitals();
//			for(int i = 0; i < lists.size();i++){
//				System.out.println(lists.get(i).toString());
//				System.out.println("");
//			}
//
//			System.out.println("This is after printing");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/jsps/hospital/HospitalList.jsp").forward(request, response);
	}

}
