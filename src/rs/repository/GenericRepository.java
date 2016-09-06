package rs.repository;

import java.util.List;
import java.util.Map;


/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 * @param <T>
 */
public interface GenericRepository<T> {

	/**
	 * Method findByFields.
	 * @param searchParams Map<String,Object>
	
	 * @return List<T> */
	List<T> findByFields(Map<String, Object> searchParams);

// move other methods to repository

	/**
	 * Method createRelationShip.
	 * @param uuid String
	 * @param friends List<?>
	 * @param string String
	 */
	void createRelationShip(String uuid, List<?> friends, String string);
	
	
}
