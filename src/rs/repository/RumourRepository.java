package rs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import rs.model.Rumour;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Repository
public interface RumourRepository extends MongoRepository<Rumour, String> {

}
