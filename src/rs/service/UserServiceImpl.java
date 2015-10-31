package rs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.model.User;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService{

	/**
	 * Method createFriendShip.
	 * @param uuid String
	 * @param friends List<User>
	
	 * @see rs.service.UserService#createFriendShip(String, List<User>) */
	@Override
	@Transactional
	public void createFriendShip(String uuid, List<User> friends) {
		// TODO Auto-generated method stub
		repo.createRelationShip(uuid, friends, "friend");
	}

}
