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
import org.springframework.web.bind.annotation.RestController;

import rs.model.LoginRequest;
import rs.service.LoginService;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@RestController
@RequestMapping("/login")
public class LoginController extends GenericController<LoginRequest>{

	/**
	 * Field loginService.
	 */
	@Autowired
	LoginService loginService;
	
	
	/**
	 * Method validateToken.
	 * @param t Map<String,Object>
	 * @param result BindingResult
	
	 * @return ResponseEntity<?> */
	@RequestMapping(method = RequestMethod.POST, value="verify" )
	public ResponseEntity<?> validateToken(@Valid @RequestBody Map<String,Object> t, BindingResult result) {
		ResponseEntity<?> response;
		if(result.hasFieldErrors()){
			response= new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
		}else{		
			response= new ResponseEntity<LoginRequest>(loginService.verify(t), HttpStatus.CREATED);
		}
		return response;
		
	}


}
