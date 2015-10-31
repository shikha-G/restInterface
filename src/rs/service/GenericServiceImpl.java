package rs.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import rs.repository.GenericRepository;
import rs.validate.GenericValidator;

//@Service
/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 * @param <T>
 */
public abstract class GenericServiceImpl<T> implements GenericService<T> {

	/**
	 * Field repo.
	 */
	@Autowired
	GenericRepository<T> repo;
	
	/**
	 * Field validator.
	 */
	@Autowired
	GenericValidator<T> validator;
	
	/**
	 * Method find.
	 * @param searchParams Map<String,Object>
	
	
	 * @return List<T> * @see rs.service.GenericService#find(Map<String,Object>) */
	public List<T> find(Map<String, Object> searchParams) {
		validator.validateMap(searchParams);
		return repo.findByFields(searchParams);
	}

	/**
	 * Method createMultiple.
	 * @param t List<T>
	
	
	 * @return List<T> * @see rs.service.GenericService#createMultiple(List<T>) */
	public List<T> createMultiple(List<T> t) {
		return t;
	}

	/**
	 * Method create.
	 * @param t T
	
	
	 * @return T * @see rs.service.GenericService#create(T) */
	@Transactional
	public T create(T t) {
		return repo.create(t);
	}

	/**
	 * Method update.
	 * @param t T
	
	
	 * @return T * @see rs.service.GenericService#update(T) */
	@Transactional
	public T update(T t) {
		return repo.update(t);
	}
	/**
	 * Method createOrUpdate.
	 * @param t T
	
	
	 * @return T * @see rs.service.GenericService#createOrUpdate(T) */
	@Transactional
	public T createOrUpdate(T t) {
		return repo.createOrUpdate(t);
	}
	
	/**
	 * Method findByUUID.
	 * @param uuid UUID
	
	
	 * @return T * @see rs.service.GenericService#findByUUID(UUID) */
	@Override
	public T findByUUID(UUID uuid) {
		return repo.findByUUID(uuid);
	}

}
