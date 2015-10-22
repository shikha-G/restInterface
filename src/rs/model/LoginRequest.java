package rs.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * @author Shikha
 *
 */
@NodeEntity
public class LoginRequest extends BaseNeo4jEntity {

	private static final long serialVersionUID = 1400826655351790992L;
		
	@NotNull
	private String mobileNo;
	
	//@Value("${requestStatus}")
	private String status = "NEW";
	
	private String otp =generateOTP();
	
	private LocalDateTime otpExpireDate;
	
	private String accessToken;

	public String getMobileNo() {
		return mobileNo;
	}

	private String generateOTP() {
		int max =9999;
		int min =1000;
		return Long.toString(Math.round(Math.random()* (max-min+1)+min));
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public LocalDateTime getOtpExpireDate() {
		return otpExpireDate;
	}

	public void setOtpExpireDate(LocalDateTime otpExpireDate) {
		this.otpExpireDate = otpExpireDate;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public boolean isOTPExpired() {
		if(otpExpireDate.isBefore(LocalDateTime.now()))
			return true;
		else
			return false;
	}
	
}
