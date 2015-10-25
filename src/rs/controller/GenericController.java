package rs.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import rs.service.GenericService;

public abstract class GenericController<T> {
	
	@Autowired
	GenericService<T> service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<T> get(@RequestParam Map<String, Object> searchParams) {
		return service.find(searchParams);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> post(@Valid @RequestBody T t, BindingResult result) {
		if(result.hasFieldErrors()){
			return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<T>(service.create(t), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public T put(@RequestBody T t) {
		return service.update(t);
	}

	@RequestMapping(method = RequestMethod.PATCH)
	public T patch(@RequestBody T t) {
		return service.update(t);
	}
	
	@RequestMapping(value="/multi", method = RequestMethod.POST)
	public List<T> postMultiple(@RequestBody List<T> t) {
		return service.createMultiple(t);
	}
	
	@RequestMapping(value="/multi", method = RequestMethod.PUT)
	public List<T> putMultiple(@RequestBody List<T> t) {
		return service.createMultiple(t);
	}
	
	@RequestMapping(value="/multi", method = RequestMethod.PATCH)
	public List<T> patchMultiple(@RequestBody List<T> t) {
		return service.createMultiple(t);
	}
	


}
