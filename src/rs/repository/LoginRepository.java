package rs.repository;

import org.springframework.stereotype.Service;

import rs.model.LoginRequest;

@Service
public class LoginRepository extends Neo4jRepository<LoginRequest> {

}
