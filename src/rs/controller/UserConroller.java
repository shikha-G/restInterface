package rs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.model.User;
import rs.service.UserService;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@RestController
@RequestMapping("/user")
public class UserConroller extends GenericController<User> {
	
	/**
	 * Field userService.
	 */
	@Autowired
	UserService userService;
	
	/**
	 * Method addFriends.
	 * @param token String
	 * @param contacts List<String>
	 * @param result BindingResult
	
	 * @return ResponseEntity<?> */
	@RequestMapping(method = RequestMethod.PUT, value="/contacts")
	public ResponseEntity<?> addFriends(@RequestHeader(value="token") String token,@Valid @RequestBody List<String> contacts, BindingResult result) {
		if(result.hasFieldErrors()){
			return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
		}
		Map<String, Object> searchParams = new HashMap<String, Object>();
		searchParams.put("mobileNo", contacts);
		List<User> friends = service.find(searchParams );
		//userService.createFriendShip(token,friends);
		return new ResponseEntity<List<User>>(friends, HttpStatus.OK);
	}
}
