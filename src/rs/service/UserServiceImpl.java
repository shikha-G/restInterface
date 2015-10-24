package rs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.model.User;

@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService{

	@Override
	@Transactional
	public void createFriendShip(String uuid, List<User> friends) {
		// TODO Auto-generated method stub
		repo.createRelationShip(uuid, friends, "friend");
	}

}
