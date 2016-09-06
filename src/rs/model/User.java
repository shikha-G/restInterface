package rs.model;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@NodeEntity
public class User {

	/**
	 * Field serialVersionUID.
	 * (value is -2831325011817444203)
	 */
	private static final long serialVersionUID = -2831325011817444203L;
	
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
	@Indexed(unique=true, failOnDuplicate = true)
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
