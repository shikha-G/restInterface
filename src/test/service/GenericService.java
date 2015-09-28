package test.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

//@Service
public interface GenericService<T> {

	List<T> find(Map<String, Object> searchParams);

	T createOrUpdate(T t);
}
