package rs.repository;

import org.springframework.stereotype.Repository;

import rs.model.Rumour;

@Repository
public class RumourRepository extends Neo4jRepository<Rumour> {

}
