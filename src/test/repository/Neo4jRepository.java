package test.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class Neo4jRepository<T> implements GenericRepository<T> {

	//@Autowired
	
	public List<T> findByFields(Map<String, Object> searchParams) {
		
		return null;
	}

	public T create(T t) {
		
		return null;
	}

}
