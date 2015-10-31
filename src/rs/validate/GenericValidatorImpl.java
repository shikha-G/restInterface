package rs.validate;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.springframework.stereotype.Service;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 * @param <T>
 */
@Service
public class GenericValidatorImpl<T> implements GenericValidator<T> {

	/**
	 * Method validateMap.
	 * @param map Map<String,Object>
	
	 * @see rs.validate.GenericValidator#validateMap(Map<String,Object>) */
	public void validateMap(Map<String, Object> map) {
		for(Entry<String, Object> entry:map.entrySet()){
			if(entry.getKey().equals("uuid")){
				map.put(entry.getKey(), UUID.fromString((String)entry.getValue()));
			}
			if(entry.getValue() instanceof String){
				String value=(String)entry.getValue();
				if(value.contains(",")){
					map.put(entry.getKey(),Arrays.asList(value.split(",")));
				}
			}
			
		}
		
	}

}
