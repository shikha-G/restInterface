package rs.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.neo4j.annotation.GraphId;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
public class BaseNeo4jEntity implements Serializable {

	/**
	 * Field serialVersionUID.
	 * (value is 4056758614117409590)
	 */
	private static final long serialVersionUID = 4056758614117409590L;

	/**
	 * Field id.
	 */
	@GraphId
	private Long id;
	
	//@Indexed
    /**
     * Field uuid.
     */
    private UUID uuid= UUID.randomUUID();
	
    //@GraphProperty(propertyType=Long.class)
    /**
     * Field createdDateTime.
     */
    @JsonIgnore
    @CreatedDate
	private LocalDateTime createdDateTime = LocalDateTime.now();
	
    /**
     * Field updatedDateTime.
     */
    @JsonIgnore
    @LastModifiedDate
	private LocalDateTime updatedDateTime = LocalDateTime.now();
	
	/**
	 * Method getId.
	
	 * @return Long */
	public Long getId() {
		return id;
	}

	/**
	 * Method setId.
	 * @param id Long
	 */
	public void setId(Long id) {
		this.id = id;
	} 
	
	/**
	 * Method getUuid.
	
	 * @return UUID */
	public UUID getUuid() {
		return uuid;
	}

	/**
	 * Method setUuid.
	 * @param uuid UUID
	 */
	public void setUuid(UUID uuid) {
		this.uuid =uuid;
	}

	/**
	 * Method getCreatedDateTime.
	
	 * @return LocalDateTime */
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * Method setCreatedDateTime.
	 * @param createdDateTime LocalDateTime
	 */
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	/**
	 * Method getUpdatedDateTime.
	
	 * @return LocalDateTime */
	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	/**
	 * Method setUpdatedDateTime.
	 * @param updatedDateTime LocalDateTime
	 */
	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
}
