package rs.model;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class LoginRequest extends BaseNeo4jEntity {

	private static final long serialVersionUID = 1400826655351790992L;
		
	@NotNull
	private String mobileNo;
	
	@Value("${requestStatus}")
	private String status = "NEW";

	public String getMobileNo() {
		return mobileNo;
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
	
}
