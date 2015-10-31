package rs.validate;

import java.util.Map;


/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 * @param <T>
 */
public interface GenericValidator<T> {

	/**
	 * Method validateMap.
	 * @param map Map<String,Object>
	 */
	void validateMap(Map<String, Object> map);

}
