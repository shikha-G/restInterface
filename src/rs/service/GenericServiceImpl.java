package rs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.repository.GenericRepository;
import rs.validate.GenericValidator;

//@Service
public abstract class GenericServiceImpl<T> implements GenericService<T> {

	@Autowired
	GenericRepository<T> repo;
	
	@Autowired
	GenericValidator<T> validator;
	
	public List<T> find(Map<String, Object> searchParams) {
		return repo.findByFields(searchParams);
	}

	public List<T> createMultiple(List<T> t) {
		return t;
	}

	public T create(T t) {
		return repo.create(t);
	}

	public T update(T t) {
		return repo.update(t);
	}

	public T createOrUpdate(T t) {
		return repo.createOrUpdate(t);
	}

}
