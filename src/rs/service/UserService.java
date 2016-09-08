package rs.service;

import java.util.List;

import rs.model.User;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
public interface UserService extends GenericService<User> {

	User createOrUpdate(User user);

	List<User> findByMobileNo(List<String> contacts);

	/**
	 * Method createFriendShip.
	 * @param token String
	 * @param friends List<User>
	 */
	//void createFriendShip(String token, List<User> friends);

}
