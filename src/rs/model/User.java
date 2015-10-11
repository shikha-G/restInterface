package rs.model;

import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class User extends BaseNeo4jEntity{

	private static final long serialVersionUID = -2831325011817444203L;
	
	private String firstName;
	
	private String lastname;
	
	
	private String mobileNo;

}
