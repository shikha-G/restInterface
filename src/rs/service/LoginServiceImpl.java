package rs.service;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.model.LoginRequest;
import rs.model.User;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Service
public class LoginServiceImpl extends GenericServiceImpl<LoginRequest>
		implements LoginService {
	
	/**
	 * Field _15.
	 * (value is 15)
	 */
	private static final int _15 = 15;
	/**
	 * Field userService.
	 */
	@Autowired
	GenericService<User> userService;
	
	/**
	 * Method verify.
	 * @param map Map<String,Object>
	
	
	 * @return LoginRequest * @see rs.service.LoginService#verify(Map<String,Object>) * @see rs.service.LoginService#verify(Map<String,Object>)
	 */
	public LoginRequest verify(Map<String, Object> map) {
		validator.validateMap(map);
		LoginRequest login= repo.findByUUID((UUID)map.get("uuid"));
		if(!login.isOTPExpired() && login.getOtp().equals(map.get("otp"))){
			// Create or update User
			User user = new User();
			user.setMobileNo(login.getMobileNo());
			user=userService.createOrUpdate(user);
			login.setStatus("VARIFIED");
			login.setAccessToken(user.getUuid().toString());				
		}else{
			login.setStatus("LOGIN_FAILED");
		}
		return repo.update(login);
	}
	
	/**
	 * Method create.
	 * @param t LoginRequest
	
	 * @return LoginRequest */
	@Override
	public LoginRequest create(LoginRequest t) {
		boolean sent =sendSMS(t.getOtp());
		if(sent){
			t.setStatus("VERIFICATION_PENDING");
			t.setOtpExpireDate(LocalDateTime.now().plusMinutes(_15));
		}
		return super.create(t);
	}
	/**
	 * Method sendSMS.
	 * @param otp String
	
	 * @return boolean */
	private boolean sendSMS(String otp) {
		// TODO Auto-generated method stub
		return true;
	}


}
