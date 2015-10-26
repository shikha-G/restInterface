package rs.service;

import java.util.UUID;

import rs.model.Group;

public interface GroupService extends GenericService<Group> {

	Group joinGroup(String token, UUID uuid);

}
