package rs.service;

import rs.model.Group;

public interface GroupService extends GenericService<Group> {

	Group joinGroup(String token, String groupUUID);

}
