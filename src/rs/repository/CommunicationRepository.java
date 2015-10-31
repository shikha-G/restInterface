package rs.repository;

import org.springframework.stereotype.Repository;

import rs.model.Communication;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Repository
public class CommunicationRepository extends Neo4jRepository<Communication> {

}
