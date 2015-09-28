package test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public abstract class GenericController<T> {
	@RequestMapping(method= RequestMethod.GET)  
	   public List<T> get(Map<String, Object> searchParams) {
	        return new ArrayList<T>();
	    }
	
	@RequestMapping(method= RequestMethod.POST)  
	   public T post(T t) {
	        return t;
	    }
	
	@RequestMapping(method= RequestMethod.PUT)  
	   public T put(T t) {
	        return t;
	    }
	
	@RequestMapping(method= RequestMethod.PATCH)  
	   public T patch(T t) {
	        return t;
	    }
	    
	    
}
