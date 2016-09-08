package rs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import rs.model.User;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Repository
public class UserRepository extends JPARepositoryImpl<User> {
	
	//List<User> findByMobileNo(List<String> mobileNos);

}
