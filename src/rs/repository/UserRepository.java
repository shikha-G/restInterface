package rs.repository;

import java.util.HashMap;
import java.util.Map;

import rs.model.User;


public class UserRepository extends Neo4jRepository<User> {

	@Override
	public User createOrUpdate(User t) {
		User existing = findByMobileNo(t.getMobileNo());
		if(existing != null){	// update
			t.setUuid(existing.getUuid());
			return update(t);
		}else
			return create(t);
	}

	private User findByMobileNo(String mobileNo) {
		StringBuilder query = new StringBuilder("Match (n:"+type.getSimpleName()+") ");
		query.append("WHERE n.mobileNo = {mobileNo} ");//where 
		query.append("RETURN n");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mobileNo", mobileNo);
		Map<String, Object> result = template.query(query.toString(), params).singleOrNull();
		if(result!=null)
			return (User)template.projectTo(result.get("n"), type);
		else
			return null;
	}
}
