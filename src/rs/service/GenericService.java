package rs.service;

import java.util.List;
import java.util.Map;

import rs.model.LoginRequest;

//@Service
public interface GenericService<T> {

	List<T> find(Map<String, Object> searchParams);

	T createOrUpdate(T t);
	
	List<T> createMultiple(List<T> t);

	T create(T t);
}
