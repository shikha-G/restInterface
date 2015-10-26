package rs.service;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.model.LoginRequest;
import rs.model.User;

@Service
public class LoginServiceImpl extends GenericServiceImpl<LoginRequest>
		implements LoginService {
	
	@Autowired
	GenericService<User> userService;
	
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
	
	@Override
	public LoginRequest create(LoginRequest t) {
		boolean sent =sendSMS(t.getOtp());
		if(sent){
			t.setStatus("VERIFICATION_PENDING");
			t.setOtpExpireDate(LocalDateTime.now().plusMinutes(15));
		}
		return super.create(t);
	}
	private boolean sendSMS(String otp) {
		// TODO Auto-generated method stub
		return true;
	}


}
