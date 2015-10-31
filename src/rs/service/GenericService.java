package rs.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 * @param <T>
 */
public interface GenericService<T> {

	/**
	 * Method find.
	 * @param searchParams Map<String,Object>
	
	 * @return List<T> */
	List<T> find(Map<String, Object> searchParams);

	/**
	 * Method update.
	 * @param t T
	
	 * @return T */
	T update(T t);
	
	/**
	 * Method createMultiple.
	 * @param t List<T>
	
	 * @return List<T> */
	List<T> createMultiple(List<T> t);

	/**
	 * Method create.
	 * @param t T
	
	 * @return T */
	T create(T t);

	/**
	 * Method createOrUpdate.
	 * @param t T
	
	 * @return T */
	T createOrUpdate(T t);
	
	/**
	 * Method findByUUID.
	 * @param uuid UUID
	
	 * @return T */
	T findByUUID(UUID uuid);
}
