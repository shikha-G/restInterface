package rs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.model.LoginRequest;

@RestController
@RequestMapping("/login")
public class LoginController extends GenericController<LoginRequest> {
	
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> post(@Valid @RequestBody LoginRequest t, BindingResult result) {
		if(result.hasFieldErrors()){
			return new ResponseEntity<List>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
		}
		boolean sent =sendSMS(t.getOtp());
		if(sent){
			t.setStatus("VERIFICATION_PENDING");
		}
		return new ResponseEntity<LoginRequest>(service.createOrUpdate(t), HttpStatus.CREATED);
	}

	private boolean sendSMS(String otp) {
		// TODO Auto-generated method stub
		return true;
	}
}
