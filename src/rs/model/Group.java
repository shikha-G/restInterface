package rs.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Group extends BaseNeo4jEntity{

	private static final long serialVersionUID = -4305823415241622110L;
	
	@NotNull
	@NotEmpty
	private String name;
	
	private String description;
	@Min(10)
	@Max(100)
	private Integer percentVote =50;
	private String location;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPercentVote() {
		return percentVote;
	}
	public void setPercentVote(Integer percentVote) {
		this.percentVote = percentVote;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
