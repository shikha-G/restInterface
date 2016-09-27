package rs.service;


import java.util.List;

import org.springframework.stereotype.Service;

import rs.model.User;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService{

	//@Autowired
	//UserRepository repo;
	
	@Override
	public User createOrUpdate(User user) {

		return repo.save(user);
		//return null;
	}

	@Override
	public List<User> findByMobileNo(List<String> contacts) {
		//return repo.findByMobileNo(contacts);
		return null;
	}

	/**
	 * Method createFriendShip.
	 * @param uuid String
	 * @param friends List<User>
	
	 * @see rs.service.UserService#createFriendShip(String, List<User>) */
	/*@Override
	@Transactional
	public void createFriendShip(String uuid, List<User> friends) {
		// TODO Auto-generated method stub
		repo.createRelationShip(uuid, friends, "friend");
	}*/

}
