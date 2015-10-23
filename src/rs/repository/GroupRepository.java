package rs.repository;

import org.springframework.stereotype.Repository;

import rs.model.Group;

@Repository
public class GroupRepository extends Neo4jRepository<Group> {

}
