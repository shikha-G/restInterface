package rs.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import rs.model.LoginRequest;

@Service
public class LoginServiceImpl extends GenericServiceImpl<LoginRequest>
		implements LoginService {

	
	public LoginRequest verify(Map<String, Object> map) {
		LoginRequest login = null;
		validator.validateMap(map);
		List<LoginRequest> list = repo.findByFields(map);
		if(!list.isEmpty()){
			login = list.get(0);
			if(!login.isOTPExpired() && login.getOtp().equals(map.get("otp"))){
				login.setStatus("VARIFIED");
				login.setAccessToken(login.getUuid().toString());
			}else{
				login.setStatus("LOGIN_FAILED");
			}
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
