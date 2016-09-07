package rs.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import rs.model.LoginRequest;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Repository
public interface LoginRepository extends MongoRepository<LoginRequest, String> {

}
