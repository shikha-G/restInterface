package rs.service;

import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import rs.model.LoginRequest;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Service
public interface LoginService extends GenericService<LoginRequest> {

	/**
	 * Method verify.
	 * @param t Map<String,Object>
	
	 * @return LoginRequest */
	LoginRequest verify(Map<String, Object> t);
	
	UUID getLoggedInUser(String token);

	LoginRequest create(LoginRequest t);

}
