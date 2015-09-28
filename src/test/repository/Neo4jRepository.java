package test.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class Neo4jRepository<T> implements GenericRepository<T> {

	public List<T> findByFields(Map<String, Object> searchParams) {
		// TODO Auto-generated method stub
		return null;
	}

	public T create(T t) {
		// TODO Auto-generated method stub
		return null;
	}

}
