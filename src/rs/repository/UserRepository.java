package rs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import rs.model.User;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
