package rs.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class GenericServiceImpl<T> implements GenericService<T>{

	@Autowired
	JpaRepository<T, UUID> repo;
	
	@Override
	public List<T> find(Map<String, Object> searchParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T t) {
		return repo.save(t);
	}

	@Override
	public List<T> createMultiple(List<T> t) {
		return repo.save(t);
	}

	@Override
	public T create(T t) {
		return repo.save(t);
	}

	@Override
	public T createOrUpdate(T t) {
		return repo.save(t);
	}

	@Override
	public T findByUUID(UUID uuid) {
		return repo.findOne(uuid);
	}

}
