package rs.repository;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.neo4j.rest.graphdb.RestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;

public class Neo4jRepository<T> implements GenericRepository<T> {

	
	
	@Autowired
	RestAPI restApi;
	@Autowired
	Neo4jTemplate template;
	private final TypeToken<T> token;
	private final Class<? super T> type;
	 
	public Neo4jRepository() {
		super();
		token = new TypeToken<T>(getClass()){};
		this.type = token.getRawType();
	}

	public T findByUUID(Object uuid){
		StringBuilder query = new StringBuilder("Match (n:"+type.getSimpleName()+") ");
		query.append("WHERE n.uuid = {uuid} ");//where 
		query.append("RETURN n");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uuid", uuid);
		Map<String, Object> result = template.query(query.toString(), params).singleOrNull();
		return (T)template.projectTo(result.get("n"), type);
	}
	
	public List<T> findByFields(Map<String, Object> searchParams) {
		StringBuilder query = new StringBuilder("Match (n:"+type.getSimpleName()+") ");
		query.append(getWhereClause(searchParams));//where 
		query.append("RETURN n");
		Result<Map<String, Object>> result = template.query(query.toString(), searchParams);
		return convertToList(result);
	}

	private List<T> convertToList(Result<Map<String, Object>> result) {
		List<T> list = new ArrayList<T>();
		if(result !=null){
			Iterator<Map<String, Object>> itr = result.iterator();
			while(itr.hasNext()){
				Map<String, Object> map = itr.next();
				for(Entry<String, Object> entry:map.entrySet()){
					T t = (T)template.projectTo(entry.getValue(), type);
					list.add(t);
				}
			}
		}
		return list;
	}



	private Object getWhereClause(Map<String, Object> searchParams) {
		StringBuilder whereClause = new StringBuilder();
		for(Entry<String, Object> param:searchParams.entrySet()){
			appendPrefix(whereClause);
			whereClause.append("n."+param.getKey()+" = {"+param.getKey()+"}");
		}
		//whereClause.append("WHERE");
		
		return whereClause;
	}

	private void appendPrefix(StringBuilder whereClause) {
		if(whereClause.toString().contains("WHERE "))
			whereClause.append(" AND ");
		else
			whereClause.append("WHERE ");
		
	}



	public T create(T t) {
		return template.save(t);
		/*Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> propmap = convertBeanToMap(t);
		params.put("propmap", convertBeanToMap(t));
		String query = "create (n: MyModel {propmap}) return n";
		Object node = template.createNodeAs(t.getClass(), propmap);
		CypherResult result = restApi.query(query, params);
		 Map map = result.asMap();
		  Map resData = (Map)(result.getData().iterator().next().get(0));
		  Object prop = resData.get("data");
		// resData.iterator().next().
		//QueryResult<Map<String, Object>> res = restApi.query(query, params, new DefaultConverter<Map<String, Object>, T>());
		return t;//(T) res.to(t.getClass()).single();*/
	} 

	private Map<String, Object> convertBeanToMap(T t) {
		Map<String, Object> objectAsMap = new HashMap<String, Object>();
		
	    BeanInfo info;
		try {
			info = Introspector.getBeanInfo(t.getClass());
		
	    for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
	        Method reader = pd.getReadMethod();
	        if (reader != null && reader.invoke(t)!=null)
	            objectAsMap.put(pd.getName(),reader.invoke(t));
	    }
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return objectAsMap;
	}

	public T update(T t) {		
		return template.save(t);
	}

	public T delete(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> createMultiple(List<T> list) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> updateMultiple(List<T> list) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> deleteMultiple(List<T> list) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
