package rs.validate;

import java.util.Map;


public interface GenericValidator<T> {

	void validateMap(Map<String, Object> map);

}
