package hospital.web.servlet;

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
import user.service.UserException;

/**
 * Servlet implementation class UserServlet
 */

public class UserServletHospital extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServletHospital() {
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
		
		HospitalService hospitalservice = new HospitalService();  
		Hospital form = new Hospital();	

		String name = request.getParameter("hospital_name");
        int id = Integer.parseInt(request.getParameter("hospital_id"));
        String type = request.getParameter("hospital_type");
        
		form.setHospital_name(name);
		form.setHospital_id(id);
		form.setHospital_type(type);
		
		try {
			hospitalservice.registHospital(form);
			request.getSession().setAttribute("session_hospital", form);
			request.getRequestDispatcher("/jsps/hospital/hospital_item.jsp").forward(request, response);
			
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
