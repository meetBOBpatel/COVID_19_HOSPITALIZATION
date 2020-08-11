package bed.service;

import java.util.List;

import bed.dao.BedDao;
import bed.domain.Bed;
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
public class BedService {
	private BedDao bedDao = new BedDao();
	
	/**
	 * register a Bed
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void registBed(Bed form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		Bed bed = bedDao.findByBedLicenseNum(form.getLicense_num());
		int bedID = bed.getLicense_num();
		int formID = form.getLicense_num();
		
		if(bedID == formID)
			throw new UserException("This Bed ID has already been in your Database!");
		
		bedDao.addBed(form);
	}
	
	/**
	 * @return List of beds form database
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public List<Object> findallBeds() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return bedDao.findallBeds();
		
	}
	
	/**
	 * Deletes a bed from database
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void deleteBed(Bed bed) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		bedDao.deleteBed(bed);
	}
	
	/**
	 * register a Bed
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void updateBed(Bed bed) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		bedDao.updateBed(bed);
	}
	
	/**
	 * register a Bed
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Bed findByBedLicenseNum(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Bed finding = bedDao.findByBedLicenseNum(id);
		return finding;
	}
}
