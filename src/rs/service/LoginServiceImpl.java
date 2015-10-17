package rs.service;


import java.util.Map;

import org.springframework.stereotype.Service;

import rs.model.LoginRequest;

@Service
public class LoginServiceImpl extends GenericServiceImpl<LoginRequest>
		implements LoginService {

	public LoginRequest verify(Map<String, Object> t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public LoginRequest create(LoginRequest t) {
		boolean sent =sendSMS(t.getOtp());
		if(sent){
			t.setStatus("VERIFICATION_PENDING");
		}
		return super.create(t);
	}
	private boolean sendSMS(String otp) {
		// TODO Auto-generated method stub
		return true;
	}


}
