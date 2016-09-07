package rs.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class GenericRepositoryImpl<T> implements GenericRepository<T> {

	@Override
	public List<T> findByFields(Map<String, Object> searchParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createRelationShip(String uuid, List<?> friends, String string) {
		// TODO Auto-generated method stub
		
	}

}
