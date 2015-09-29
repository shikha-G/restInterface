package test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import test.service.GenericService;

public abstract class GenericController<T> {
	
	@Autowired
	GenericService<T> service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<T> get(@RequestParam Map<String, Object> searchParams) {
		return service.find(searchParams);
		//return new ArrayList<T>();
	}

	@RequestMapping(method = RequestMethod.POST)
	public T post(@RequestBody T t) {
		return service.createOrUpdate(t);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public T put(@RequestBody T t) {
		return service.createOrUpdate(t);
	}

	@RequestMapping(method = RequestMethod.PATCH)
	public T patch(@RequestBody T t) {
		return t;
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
