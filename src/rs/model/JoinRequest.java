package rs.model;

import java.util.UUID;

import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class JoinRequest extends BaseNeo4jEntity {

	private static final long serialVersionUID = -9067335192670436959L;
	
	private UUID userUUID;
	
	private UUID groupUUID;
	
	private Integer voteCount;
	
	private Integer inviteCount;
	
	private String status;

	public UUID getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(UUID userUUID) {
		this.userUUID = userUUID;
	}

	public UUID getGroupUUID() {
		return groupUUID;
	}

	public void setGroupUUID(UUID groupUUID) {
		this.groupUUID = groupUUID;
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getInviteCount() {
		return inviteCount;
	}

	public void setInviteCount(Integer inviteCount) {
		this.inviteCount = inviteCount;
	}

}
