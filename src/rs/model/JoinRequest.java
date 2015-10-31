package rs.model;

import java.util.UUID;

import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@NodeEntity
public class JoinRequest extends BaseNeo4jEntity {

	/**
	 * Field serialVersionUID.
	 * (value is -9067335192670436959)
	 */
	private static final long serialVersionUID = -9067335192670436959L;
	
	/**
	 * Field userUUID.
	 */
	private UUID userUUID;
	
	/**
	 * Field groupUUID.
	 */
	private UUID groupUUID;
	
	/**
	 * Field voteCount.
	 */
	private Integer voteCount;
	
	/**
	 * Field inviteCount.
	 */
	private Integer inviteCount;
	
	/**
	 * Field status.
	 */
	private String status;

	/**
	 * Method getUserUUID.
	
	 * @return UUID */
	public UUID getUserUUID() {
		return userUUID;
	}

	/**
	 * Method setUserUUID.
	 * @param userUUID UUID
	 */
	public void setUserUUID(UUID userUUID) {
		this.userUUID = userUUID;
	}

	/**
	 * Method getGroupUUID.
	
	 * @return UUID */
	public UUID getGroupUUID() {
		return groupUUID;
	}

	/**
	 * Method setGroupUUID.
	 * @param groupUUID UUID
	 */
	public void setGroupUUID(UUID groupUUID) {
		this.groupUUID = groupUUID;
	}

	/**
	 * Method getVoteCount.
	
	 * @return Integer */
	public Integer getVoteCount() {
		return voteCount;
	}

	/**
	 * Method setVoteCount.
	 * @param voteCount Integer
	 */
	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

	/**
	 * Method getStatus.
	
	 * @return String */
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
	 * Method getInviteCount.
	
	 * @return Integer */
	public Integer getInviteCount() {
		return inviteCount;
	}

	/**
	 * Method setInviteCount.
	 * @param inviteCount Integer
	 */
	public void setInviteCount(Integer inviteCount) {
		this.inviteCount = inviteCount;
	}

}
