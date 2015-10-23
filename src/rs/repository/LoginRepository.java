package rs.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import rs.model.LoginRequest;

@Repository
public class LoginRepository extends Neo4jRepository<LoginRequest> {

}
