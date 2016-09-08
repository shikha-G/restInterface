package rs.repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

	@Override
	public T create(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T createOrUpdate(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T delete(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> createMultiple(List<T> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> updateMultiple(List<T> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> deleteMultiple(List<T> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findByUUID(UUID object) {
		// TODO Auto-generated method stub
		return null;
	}

}
