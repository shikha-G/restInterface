package test.service;

import java.util.List;
import java.util.Map;

//@Service
public interface GenericService<T> {

	List<T> find(Map<String, Object> searchParams);

	T createOrUpdate(T t);
	
	List<T> createMultiple(List<T> t);
}
