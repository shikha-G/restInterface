package rs.controller;

import java.util.List;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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

import rs.model.Group;
import rs.model.JoinRequest;
import rs.service.GenericService;
import rs.service.LoginService;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@RestController
//@RequestMapping("/request")
public class JoinGroupController extends GenericController<JoinRequest> {

	@Autowired
	GenericService<JoinRequest> joinService;
	
	@Autowired LoginService loginService;

	@RequestMapping(method = RequestMethod.POST, value="/join")
	public ResponseEntity<?> create(@RequestHeader(value="token") String token,@Valid @RequestBody JoinRequest request, BindingResult result) {
		if(result.hasFieldErrors()){
			return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
		}
		request.setUserUUID(loginService.getLoggedInUser(token));
		JoinRequest reqJoinRequest=joinService.createOrUpdate(request);
		return new ResponseEntity<JoinRequest>(reqJoinRequest, HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.PUT, value="/vote")
	public ResponseEntity<?> vote(@RequestHeader(value="token") String token,@RequestBody String groupUUID, @NotNull BindingResult result) {
		if(result.hasFieldErrors()){
			return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
		}		 
		//Group group=groupService.joinGroup(token,groupUUID);
		//return new ResponseEntity<Group>(group, HttpStatus.OK);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/invite")
	public ResponseEntity<?> invite(@RequestHeader(value="token") String token,@RequestBody String groupUUID, @NotNull BindingResult result) {
		if(result.hasFieldErrors()){
			return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
		}		 
		//Group group=groupService.joinGroup(token,groupUUID);
		//return new ResponseEntity<Group>(group, HttpStatus.OK);
		return null;
	}
	
}
