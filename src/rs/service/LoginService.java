package rs.service;

import java.util.Map;

import rs.model.LoginRequest;

public interface LoginService extends GenericService<LoginRequest> {

	LoginRequest verify(Map<String, Object> t);

}
