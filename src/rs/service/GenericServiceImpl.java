package rs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.repository.GenericRepository;
import rs.validate.GenericValidator;

//@Service
public abstract class GenericServiceImpl<T> implements GenericService<T> {

	@Autowired
	GenericRepository<T> repo;
	
	@Autowired
	GenericValidator<T> validator;
	
	public List<T> find(Map<String, Object> searchParams) {
		validator.validateMap(searchParams);
		return repo.findByFields(searchParams);
	}

	public List<T> createMultiple(List<T> t) {
		return t;
	}

	@Transactional
	public T create(T t) {
		return repo.create(t);
	}

	@Transactional
	public T update(T t) {
		return repo.update(t);
	}
	@Transactional
	public T createOrUpdate(T t) {
		return repo.createOrUpdate(t);
	}

}
