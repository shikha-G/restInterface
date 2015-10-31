package rs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.model.Group;
import rs.model.User;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Service
public class GroupServiceImpl extends GenericServiceImpl<Group> implements GroupService{

	/**
	 * Field userService.
	 */
	@Autowired
	UserService userService;

	/**
	 * Method joinGroup.
	 * @param token String
	 * @param uuid UUID
	
	
	 * @return Group * @see rs.service.GroupService#joinGroup(String, UUID) */
	@Override
	public Group joinGroup(String token, UUID uuid) {
		Group group = repo.findByUUID(uuid);
		User user = userService.findByUUID(UUID.fromString(token));
		List<User> userList = new ArrayList<User>();
		if(user !=null) {
			userList.add(user);
		}
		repo.createRelationShip(uuid.toString(), userList, "member");
		return group;
	}

}
