package rs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.model.User;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
	
	//List<User> findByMobileNo(List<String> mobileNos);


}
