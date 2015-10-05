package test.repository;

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
import org.neo4j.rest.graphdb.util.ResultConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Neo4jRepository<T> implements GenericRepository<T> {

	//@Autowired
	//Neo4jTemplate template;
	
	@Autowired
	RestAPI restApi;
	
	public List<T> findByFields(Map<String, Object> searchParams) {
		
		return null;
	}

	public T create(T t) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("propmap", convertBeanToMap(t));
		String query = "create (n: MyModel {propmap}) return n";
		ResultConverter arg2 = null;
		restApi.query(query, params, arg2);
		return null;
	}

	private Map<String, Object> convertBeanToMap(T t) {
		Map<String, Object> objectAsMap = new HashMap<String, Object>();
		
	    BeanInfo info;
		try {
			info = Introspector.getBeanInfo(t.getClass());
		
	    for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
	        Method reader = pd.getReadMethod();
	        if (reader != null)
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
	
	

}
