package rs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

	/*@ResponseBody
    //@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public List<String> validationErrorHandle(HttpMessageNotReadableException error){
		List<String> fields = new ArrayList<String>();
		error.printStackTrace();
		JsonMappingException ex = (JsonMappingException)error.getCause();
		for (Reference ref : ex.getPath()) {
			fields.add(ref.getFieldName());
		}
		return fields;
	}*/
}
