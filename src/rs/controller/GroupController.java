package rs.controller;

import java.util.List;




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
import rs.service.GroupService;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@RestController
@RequestMapping("/group")
public class GroupController extends GenericController<Group> {
	
	/**
	 * Field groupService.
	 */
	@Autowired
	GroupService groupService;

	/**
	 * Method joinGroup.
	 * @param token String
	 * @param grp Group
	 * @param result BindingResult
	
	 * @return ResponseEntity<?> */
	@RequestMapping(method = RequestMethod.PUT, value="/join")
	public ResponseEntity<?> joinGroup(@RequestHeader(value="token") String token,@Valid @RequestBody Group grp, BindingResult result) {
		if(result.hasFieldErrors()){
			return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
		}		 
		Group group=groupService.joinGroup(token,grp.getUuid());
		return new ResponseEntity<Group>(group, HttpStatus.OK);
	}
	
	/**
	 * Method vote.
	 * @param token String
	 * @param groupUUID String
	 * @param result BindingResult
	
	 * @return ResponseEntity<?> */
	@RequestMapping(method = RequestMethod.PUT, value="/vote")
	public ResponseEntity<?> vote(@RequestHeader(value="token") String token,@RequestBody String groupUUID, @NotNull BindingResult result) {
		if(result.hasFieldErrors()){
			return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
		}		 
		//Group group=groupService.joinGroup(token,groupUUID);
		//return new ResponseEntity<Group>(group, HttpStatus.OK);
		return null;
	}
}
