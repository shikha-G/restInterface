package rs.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rs.model.Rumour;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Repository
public interface RumourRepository extends JpaRepository<Rumour, UUID> {

}
