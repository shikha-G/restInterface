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
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.support.Neo4jTemplate;

import rs.model.BaseNeo4jEntity;

import com.google.common.reflect.TypeToken;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 * @param <T>
 */
public abstract class Neo4jRepository<T extends BaseNeo4jEntity> implements GenericRepository<T> {	
	
	/**
	 * Field template.
	 */
	@Autowired
	Neo4jTemplate template;
	/**
	 * Field token.
	 */
	private final TypeToken<T> token;
	/**
	 * Field type.
	 */
	protected final Class<? super T> type;
	 
	/**
	 * Constructor for Neo4jRepository.
	 */
	public Neo4jRepository() {		
		token = new TypeToken<T>(getClass()){
			/*
			 * 
			 */
			private static final long serialVersionUID = 1L;};
		type = token.getRawType();
	}

	/**
	 * Method findByUUID.
	 * @param uuid UUID
	
	
	 * @return T * @see rs.repository.GenericRepository#findByUUID(UUID) * @see rs.repository.GenericRepository#findByUUID(UUID)
	 */
	public T findByUUID(@NotNull final UUID uuid){
		StringBuilder query = new StringBuilder("Match (n:"+type.getSimpleName()+") ");
		query.append("WHERE n.uuid = {uuid} ");//where 
		query.append("RETURN n");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uuid", uuid);
		Map<String, Object> result = template.query(query.toString(), params).singleOrNull();
		if(result!=null){
			return ((T)template.projectTo(result.get("n"), type));
		} else {
			return null;
		}
	}
	
	/**
	 * Method findByFields.	
	 * @param searchParams Map<String,Object>
	 * @return List<T> * @see rs.repository.GenericRepository#findByFields(Map<String,Object>) * @see rs.repository.GenericRepository#findByFields(Map<String,Object>)
	 */
	public List<T> findByFields(@NotNull final Map<String, Object> searchParams) {
		StringBuilder query = new StringBuilder("Match (n:"+type.getSimpleName()+") ");
		query.append(getWhereClause(searchParams));//where 
		query.append("RETURN n");
		Result<Map<String, Object>> result = template.query(query.toString(), searchParams);
		return convertToList(result);
	}

	/**
	 * Method convertToList.
	 * @param result Result<Map<String,Object>>
	
	 * @return List<T> */
	private List<T> convertToList(Result<Map<String, Object>> result) {
		List<T> list = new ArrayList<T>();
		if(result !=null){
			Iterator<Map<String, Object>> itr = result.iterator();
			while(itr.hasNext()){
				Map<String, Object> next = itr.next();
				for(Entry<String, Object> entry:next.entrySet()){
					T entity = (T)template.projectTo(entry.getValue(), type);
					list.add(entity);
				}
			}
		}
		return list;
	}


	/**
	 * Method getWhereClause.
	
	
	 * @param searchParams Map<String,Object>
	 * @return Object */
	private Object getWhereClause(@NotNull final Map<String, Object> searchParams) {
		StringBuilder whereClause = new StringBuilder();
			for(Entry<String, Object> param:searchParams.entrySet()){
					appendPrefix(whereClause);
					whereClause.append("n."+param.getKey());
					if(param.getValue() instanceof List) {
						whereClause.append(" IN ");
					} else {
						whereClause.append(" = ");
					}
					whereClause.append("{"+param.getKey()+"}");
			}
		
		return whereClause;
	}


	/**
	 * Method appendPrefix.
	 * @param whereClause StringBuilder
	 */
	private void appendPrefix(StringBuilder whereClause) {
		if(whereClause !=null){
			if(whereClause.toString().contains("WHERE ")) {
				whereClause.append(" AND ");
			} else {
				whereClause.append("WHERE ");
			}
		}
	}

	/**
	 * Method create.
	
	
	
	 * @param t T
	 * @return T * @see rs.repository.GenericRepository#create(T) * @see rs.repository.GenericRepository#create(T)
	 */
	public T create(@NotNull final T t) {
		return template.save(t);
	} 



	/**
	 * Method update.
	
	
	
	 * @param t T
	 * @return T * @see rs.repository.GenericRepository#update(T) * @see rs.repository.GenericRepository#update(T)
	 */
	public T update(@NotNull final T t) {	
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
		return result!=null ? (T)template.projectTo(result.get("n"), type) : null;
	}

	/**
	 * Method appendSet.
	 * @param query StringBuilder
	 */
	private void appendSet(@NotNull StringBuilder query) {
		if(query.toString().contains("SET ")) {
			query.append(" , ");
		} else {
			query.append("SET ");
		}
		
		
	}

	/**
	 * Method delete.
	
	
	
	 * @param t T
	 * @return T * @see rs.repository.GenericRepository#delete(T) * @see rs.repository.GenericRepository#delete(T)
	 */
	public T delete(T t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Method createRelationShip.
	
	 * @param relations List<?>
	
	
	 * @param uuid String
	 * @param relType String
	 * @see rs.repository.GenericRepository#createRelationShip(String, List<?>, String) */
	public void createRelationShip(String uuid, List<?> relations, String relType){
		if(relations!=null && !relations.isEmpty()){
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
			template.query(query.toString(), params );
			//Iterator<Map<String, Object>> itr = result.iterator();
			//return convertToList(result);
		}
	}

	/**
	 * Method createMultiple.
	 * @param list List<T>
	
	
	 * @return List<T> * @see rs.repository.GenericRepository#createMultiple(List<T>) * @see rs.repository.GenericRepository#createMultiple(List<T>)
	 */
	public List<T> createMultiple(List<T> list) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method updateMultiple.
	 * @param list List<T>
	
	
	 * @return List<T> * @see rs.repository.GenericRepository#updateMultiple(List<T>) * @see rs.repository.GenericRepository#updateMultiple(List<T>)
	 */
	public List<T> updateMultiple(List<T> list) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method deleteMultiple.
	 * @param list List<T>
	
	
	 * @return List<T> * @see rs.repository.GenericRepository#deleteMultiple(List<T>) * @see rs.repository.GenericRepository#deleteMultiple(List<T>)
	 */
	public List<T> deleteMultiple(List<T> list) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method createOrUpdate.
	 * @param t T
	
	
	 * @return T * @see rs.repository.GenericRepository#createOrUpdate(T) * @see rs.repository.GenericRepository#createOrUpdate(T)
	 */
	public T createOrUpdate(T t) {
		T existing = findByUUID((t).getUuid());
		if(existing != null){	// update
			return update(t);
		} else {
			return create(t);
		}
	}


	/**
	 * Method convertBeanToMap.
	
	
	 * @param t T
	 * @return Map<String,Object> */
	private Map<String, Object> convertBeanToMap(@NotNull final T t) {
		Map<String, Object> objectAsMap = new HashMap<String, Object>();
		
	    BeanInfo info;
		try {
			info = Introspector.getBeanInfo(t.getClass());
		
	    for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
	        Method reader = pd.getReadMethod();
	        if (reader != null && reader.invoke(t)!=null){
	        	Object value= reader.invoke((t));
	        	if(value instanceof LocalDateTime) {
					value=((LocalDateTime)value).format(DateTimeFormatter.ISO_DATE_TIME);
				}
	            objectAsMap.put(pd.getName(),value);
	        }
	    }
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException |InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		} 
	    return objectAsMap;
	}

}
