package rs.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author Shikha
 *
 * @version $Revision: 1.0 $
 */
@Entity
public class LoginRequest  {

	private static final int _1000 = 1000;

	private static final int _9999 = 9999;

	/**
	 * Field serialVersionUID.
	 * (value is 1400826655351790992)
	 */
	private static final long serialVersionUID = 1400826655351790992L;
	
	@Id
	private String uuid = UUID.randomUUID().toString();
	
	/**
	 * Field mobileNo.
	 */
	@NotNull
	private String mobileNo;
	

	//@Value("${requestStatus}")
	/**
	 * Field status.
	 */
	private String status = "NEW";
	
	/**
	 * Field otp.
	 */
	private String otp =generateOTP();
	
	/**
	 * Field otpExpireDate.
	 */
	private LocalDateTime otpExpireDate;
	
	/**
	 * Field accessToken.
	 */
	private String accessToken;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Method getMobileNo.
	 * @return String
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * Method generateOTP.
	 * @return String
	 */
	private String generateOTP() {
		int max =_9999;
		int min =_1000;
		return Long.toString(Math.round(Math.random()* (max-min+1)+min));
	}

	/**
	 * Method setMobileNo.
	 * @param mobileNo String
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * Method getStatus.
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Method setStatus.
	 * @param status String
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Method getOtp.
	 * @return String
	 */
	public String getOtp() {
		return otp;
	}

	/**
	 * Method setOtp.
	 * @param otp String
	 */
	public void setOtp(String otp) {
		this.otp = otp;
	}

	/**
	 * Method getOtpExpireDate.
	 * @return LocalDateTime
	 */
	public LocalDateTime getOtpExpireDate() {
		return otpExpireDate;
	}

	/**
	 * Method setOtpExpireDate.
	 * @param otpExpireDate LocalDateTime
	 */
	public void setOtpExpireDate(LocalDateTime otpExpireDate) {
		this.otpExpireDate = otpExpireDate;
	}

	/**
	 * Method getAccessToken.
	 * @return String
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * Method setAccessToken.
	 * @param accessToken String
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * Method isOTPExpired.
	 * @return boolean
	 */
	public boolean isOTPExpired() {
		return otpExpireDate.isBefore(LocalDateTime.now()) ? true : false;
	}
	
}
