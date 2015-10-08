package rs.repository;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.query.CypherResult;
import org.neo4j.rest.graphdb.util.DefaultConverter;
import org.neo4j.rest.graphdb.util.QueryResult;
import org.neo4j.rest.graphdb.util.ResultConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;

@Service
public class Neo4jRepository<T> implements GenericRepository<T> {

	
	@Autowired
	RestAPI restApi;
	
	@Autowired
	Neo4jTemplate template;
	
	public List<T> findByFields(Map<String, Object> searchParams) {
		
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
