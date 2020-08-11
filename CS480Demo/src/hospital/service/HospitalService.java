package hospital.service;

import java.util.List;

import hospital.dao.HospitalDao;
import hospital.domain.Hospital;
import user.dao.UserDao;
import user.domain.User;
import user.service.UserException;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class HospitalService {
	private HospitalDao hospitalDao = new HospitalDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void registHospital(Hospital form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		Hospital hosp = hospitalDao.findByHospitalID(form.getHospital_id());
		int hospID = hosp.getHospital_id();
		int formID = form.getHospital_id();
		
		if(hospID == formID)
			throw new UserException("This Hospital ID has already been in your Database!");
		
		hospitalDao.addHospital(form);
	}
	
 
	public List<Object> findallHospitals() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return hospitalDao.findallHospitals();
		
	}
	
	public boolean deleteHospital(Hospital hosp) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean delete = hospitalDao.deleteHospital(hosp);
		return delete;
	}
	
	public boolean updateHospital(Hospital hosp) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean update = hospitalDao.updateHospital(hosp);
		return update;
	}
	public Hospital findByHospitalID(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Hospital finding = hospitalDao.findByHospitalID(id);
		return finding;
	}
}
