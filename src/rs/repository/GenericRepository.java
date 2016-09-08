package rs.repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;


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

	/**
	 * Method create.
	 * @param t T
	
	 * @return T */
	T create(T t);
	
	/**
	 * Method update.
	 * @param t T
	
	 * @return T */
	T update(T t);
	
	/**
	 * Method createOrUpdate.
	 * @param t T
	
	 * @return T */
	T createOrUpdate(T t);
	
	/**
	 * Method delete.
	 * @param t T
	
	 * @return T */
	T delete(T t);
	
	/**
	 * Method createMultiple.
	 * @param list List<T>
	
	 * @return List<T> */
	List<T> createMultiple(List<T> list);
	
	/**
	 * Method updateMultiple.
	 * @param list List<T>
	
	 * @return List<T> */
	List<T> updateMultiple(List<T> list);
	
	/**
	 * Method deleteMultiple.
	 * @param list List<T>
	
	 * @return List<T> */
	List<T> deleteMultiple(List<T> list);

	/**
	 * Method findByUUID.
	 * @param object UUID
	
	 * @return T */
	T findByUUID(UUID object);

	/**
	 * Method createRelationShip.
	 * @param uuid String
	 * @param friends List<?>
	 * @param string String
	 */
	void createRelationShip(String uuid, List<?> friends, String string);
	
	
}
