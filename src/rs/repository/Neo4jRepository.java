package rs.repository;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.support.Neo4jTemplate;

import rs.model.BaseNeo4jEntity;

import com.google.common.reflect.TypeToken;

public abstract class Neo4jRepository<T extends BaseNeo4jEntity> implements GenericRepository<T> {	
	
	@Autowired
	Neo4jTemplate template;
	private final TypeToken<T> token;
	protected final Class<? super T> type;
	 
	public Neo4jRepository() {
		super();
		token = new TypeToken<T>(getClass()){
			private static final long serialVersionUID = 1L;};
		this.type = token.getRawType();
	}

	public T findByUUID(Object uuid){
		StringBuilder query = new StringBuilder("Match (n:"+type.getSimpleName()+") ");
		query.append("WHERE n.uuid = {uuid} ");//where 
		query.append("RETURN n");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uuid", uuid);
		Map<String, Object> result = template.query(query.toString(), params).singleOrNull();
		if(result!=null)
			return (T)template.projectTo(result.get("n"), type);
		else
			return null;
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
			whereClause.append("n."+param.getKey());
			if(param.getValue() instanceof List)
				whereClause.append(" IN ");
			else
				whereClause.append(" = ");
			whereClause.append("{"+param.getKey()+"}");
		}
		
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
	} 



	public T update(T t) {	
		Map<String, Object> propMap = convertBeanToMap(t);
		//params.put("uuid", t.getUuid());
		//params.put("propMap",convertBeanToMap(t));
		StringBuilder query = new StringBuilder("Match (n:"+type.getSimpleName()+" {uuid: {uuid}}) ");
		//query.append("SET ");
		for(String key:propMap.keySet()){
			appendSet(query);
			query.append(" n."+key+"={"+key+"} ");
		}
		query.append("RETURN n");
		Map<String, Object> result = template.query(query.toString(), propMap).singleOrNull();
		if(result!=null)
			return (T)template.projectTo(result.get("n"), type);
		else
			return null;
	}

	private void appendSet(StringBuilder query) {
		if(query.toString().contains("SET "))
			query.append(" , ");
		else
			query.append("SET ");
		
		
	}

	public T delete(T t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void createRelationShip(String uuid, List<?> relations, String relType){
		if(!relations.isEmpty()){
			String nodeType=relations.get(0).getClass().getSimpleName();
			List<String> uuidList= new ArrayList<String>();
			for(Object rel: relations){
				uuidList.add(((BaseNeo4jEntity)rel).getUuid().toString());
			}
			StringBuilder query = new StringBuilder("Match (n:"+type.getSimpleName()+" {uuid: {uuid}}) ");
			query.append(", (m:"+nodeType+") WHERE m.uuid IN {uuidList} ");
			query.append("CREATE (n)-[r:"+relType+"]->(m) RETURN r");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("uuid", uuid);
			params.put("uuidList", uuidList);
			Result<Map<String, Object>> result = template.query(query.toString(), params );
			//Iterator<Map<String, Object>> itr = result.iterator();
			//return convertToList(result);
		}
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

	public T createOrUpdate(T t) {
		T existing = findByUUID(t.getUuid());
		if(existing != null){	// update
			return update(t);
		}else
			return create(t);
	}

	private Map<String, Object> convertBeanToMap(T t) {
		Map<String, Object> objectAsMap = new HashMap<String, Object>();
		
	    BeanInfo info;
		try {
			info = Introspector.getBeanInfo(t.getClass());
		
	    for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
	        Method reader = pd.getReadMethod();
	        if (reader != null && reader.invoke(t)!=null){
	        	Object value= reader.invoke(t);
	        	if(value instanceof LocalDateTime)
	        		value=((LocalDateTime)value).format(DateTimeFormatter.ISO_DATE_TIME);
	            objectAsMap.put(pd.getName(),value);
	        }
	    }
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException |InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    return objectAsMap;
	}

}
