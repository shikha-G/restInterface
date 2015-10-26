package rs.repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import rs.model.User;

public interface GenericRepository<T> {

	List<T> findByFields(Map<String, Object> searchParams);

	T create(T t);
	
	T update(T t);
	
	T createOrUpdate(T t);
	
	T delete(T t);
	
	List<T> createMultiple(List<T> list);
	
	List<T> updateMultiple(List<T> list);
	
	List<T> deleteMultiple(List<T> list);

	T findByUUID(UUID object);

	void createRelationShip(String uuid, List<?> friends, String string);
	
	
}
