package rs.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;

public class BaseNeo4jEntity implements Serializable {

	private static final long serialVersionUID = 4056758614117409590L;

	@GraphId
	private Long id;
	
	//@Indexed
    private UUID uuid= UUID.randomUUID();
	
	private LocalDateTime createdDateTime = LocalDateTime.now();
	
	private LocalDateTime updatedDateTime = LocalDateTime.now();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid =uuid;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
}
