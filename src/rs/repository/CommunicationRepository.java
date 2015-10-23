package rs.repository;

import org.springframework.stereotype.Repository;

import rs.model.Communication;

@Repository
public class CommunicationRepository extends Neo4jRepository<Communication> {

}
