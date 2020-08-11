package location.service;

import java.util.List;

import hospital.dao.HospitalDao;
import hospital.domain.Hospital;
import location.dao.LocationDao;
import location.domain.Location;
import user.dao.UserDao;
import user.domain.User;
import user.service.UserException;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class LocationService {
	private LocationDao locationDao = new LocationDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void registLocation(Location form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		Location loc = locationDao.findByLocationAddress(form.getAddress());
		String locID = loc.getAddress();
		String formID = form.getAddress();
		
		if(locID == formID)
			throw new UserException("This Location Address is already in your Database!");
		
		locationDao.addLocation(form);
	}
	
 
	public List<Object> findallLocations() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return locationDao.findallLocations();
		
	}
	
	public boolean deleteLocation(Location hosp) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean delete = locationDao.deleteLocation(hosp);
		return delete;
	}
	
	public boolean updateLocation(Location loc) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean update = locationDao.updateLocation(loc);
		return update;
	}
	public Location findByLocationAddress(String adr) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Location finding = locationDao.findByLocationAddress(adr);
		return finding;
	}
}
