package rs.service;

import java.util.List;

import rs.model.User;

public interface UserService extends GenericService<User> {

	void createFriendShip(String token, List<User> friends);

}
