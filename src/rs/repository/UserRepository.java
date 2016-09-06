package rs.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import rs.model.User;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@Repository
public class UserRepository  {

	/**
	 * Method createOrUpdate.
	 * @param t User
	
	 * @return User */
	/*@Override
	public User createOrUpdate(User t) {
		User existing = findByMobileNo(t.getMobileNo());
		if(existing != null){	// update
			t.setUuid(existing.getUuid());
			return update(t);
		} else {
			return create(t);
		}
	}*/

	/**
	 * Method findByMobileNo.
	 * @param mobileNo String
	
	 * @return User */
	/*private User findByMobileNo(String mobileNo) {
		StringBuilder query = new StringBuilder("Match (n:"+type.getSimpleName()+") ");
		query.append("WHERE n.mobileNo = {mobileNo} ");//where 
		query.append("RETURN n");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mobileNo", mobileNo);
		//Map<String, Object> result = template.query(query.toString(), params).singleOrNull();
		//return result!=null ? (User)template.projectTo(result.get("n"), type) : null;
		return null;
	}*/
}
