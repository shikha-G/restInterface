package rs.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Entity
public class User {

	/**
	 * Field serialVersionUID.
	 * (value is -2831325011817444203)
	 */
	private static final long serialVersionUID = -2831325011817444203L;
	
	@Id
	private UUID uuid;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * Field firstName.
	 */
	private String firstName;
	
	/**
	 * Field lastname.
	 */
	private String lastname;
	
	/**
	 * Field mobileNo.
	 */

	private String mobileNo;

	
	/**
	 * Method getMobileNo.
	
	 * @return String */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * Method setMobileNo.
	 * @param mobileNo String
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * Method getFirstName.
	
	 * @return String */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Method setFirstName.
	 * @param firstName String
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Method getLastname.
	
	 * @return String */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Method setLastname.
	 * @param lastname String
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
