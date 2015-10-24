package rs.validate;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

@Service
public class GenericValidatorImpl<T> implements GenericValidator<T> {

	public void validateMap(Map<String, Object> map) {
		for(Entry<String, Object> entry:map.entrySet()){
			if(entry.getValue() instanceof String){
				String value=(String)entry.getValue();
				if(value.contains(",")){
					map.put(entry.getKey(),Arrays.asList(value.split(",")));
				}
			}
		}
		
	}

}
