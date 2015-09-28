package test.repository;

import java.util.List;
import java.util.Map;

public interface GenericRepository<T> {

	List<T> findByFields(Map<String, Object> searchParams);

	T create(T t);
}
