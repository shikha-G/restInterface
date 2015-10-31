package rs.service;

import java.util.UUID;

import rs.model.Group;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
public interface GroupService extends GenericService<Group> {

	/**
	 * Method joinGroup.
	 * @param token String
	 * @param uuid UUID
	
	 * @return Group */
	Group joinGroup(String token, UUID uuid);

}
