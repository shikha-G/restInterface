package test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.repository.GenericRepository;
import test.validate.GenericValidator;

@Service
public class GenericServiceImpl<T> implements GenericService<T> {

	@Autowired
	GenericRepository<T> repo;
	
	@Autowired
	GenericValidator<T> validator;
	
	public List<T> find(Map<String, Object> searchParams) {
		return repo.findByFields(searchParams);
	}

	public T createOrUpdate(T t) {		
		return repo.create(t);
	}

}
