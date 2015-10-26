package rs.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;


public interface GenericService<T> {

	List<T> find(Map<String, Object> searchParams);

	T update(T t);
	
	List<T> createMultiple(List<T> t);

	T create(T t);

	T createOrUpdate(T t);
	
	T findByUUID(UUID uuid);
}
