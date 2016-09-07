package rs.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Document
public class Rumour {

	/**
	 * Field serialVersionUID.
	 * (value is 6462903511232782685)
	 */
	private static final long serialVersionUID = 6462903511232782685L;
	
	@Id
	private String uuid = UUID.randomUUID().toString();
	
	private String title;


	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
