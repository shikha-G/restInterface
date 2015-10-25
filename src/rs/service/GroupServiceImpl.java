package rs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import rs.model.Group;

@Service
public class GroupServiceImpl extends GenericServiceImpl<Group> implements GroupService{

	@Override
	public Group joinGroup(String token, String groupUUID) {
		Group group = repo.findByUUID(groupUUID);
		List<Group> groupList = new ArrayList<Group>();
		groupList.add(group);
		repo.createRelationShip(token, groupList, "member");
		return group;
	}

}
