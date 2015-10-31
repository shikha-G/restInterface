package rs.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@NodeEntity
public class Group extends BaseNeo4jEntity{

	/**
	 * Field _50.
	 * (value is 50)
	 */
	private static final int _50 = 50;

	/**
	 * Field _100.
	 * (value is 100)
	 */
	private static final int _100 = 100;

	/**
	 * Field _10.
	 * (value is 10)
	 */
	private static final int _10 = 10;

	/**
	 * Field serialVersionUID.
	 * (value is -4305823415241622110)
	 */
	private static final long serialVersionUID = -4305823415241622110L;
	
	/**
	 * Field name.
	 */
	@NotNull
	@NotEmpty
	private String name;
	
	/**
	 * Field description.
	 */
	private String description;
	/**
	 * Field percentVote.
	 */
	@Min(_10)
	@Max(_100)
	private Integer percentVote =_50;
	/**
	 * Field location.
	 */
	private String location;
	/**
	 * Method getName.
	
	 * @return String */
	public String getName() {
		return name;
	}
	/**
	 * Method setName.
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Method getDescription.
	
	 * @return String */
	public String getDescription() {
		return description;
	}
	/**
	 * Method setDescription.
	 * @param description String
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Method getPercentVote.
	
	 * @return Integer */
	public Integer getPercentVote() {
		return percentVote;
	}
	/**
	 * Method setPercentVote.
	 * @param percentVote Integer
	 */
	public void setPercentVote(Integer percentVote) {
		this.percentVote = percentVote;
	}
	/**
	 * Method getLocation.
	
	 * @return String */
	public String getLocation() {
		return location;
	}
	/**
	 * Method setLocation.
	 * @param location String
	 */
	public void setLocation(String location) {
		this.location = location;
	}

}
