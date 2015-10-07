package test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;

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
	public ResponseEntity post(@Valid @RequestBody T t, BindingResult result) {
		if(result.hasFieldErrors()){
			return new ResponseEntity(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(service.createOrUpdate(t), HttpStatus.CREATED);
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
	
	/*@ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public List<String> validationErrorHandle(Exception error){
		List<String> fields = new ArrayList<String>();
		error.printStackTrace();
		JsonMappingException ex = (JsonMappingException)error.getCause();
		for (Reference ref : ex.getPath()) {
			fields.add(ref.getFieldName());
		}
		return fields;
	}*/

}
