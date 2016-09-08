package rs.global;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@SpringBootApplication
@ComponentScan(basePackages = {"rs.controller", "rs.service", "rs.repository", "rs.validate"})
//@PropertySource("classpath:config.properties")
public class Application {

    /**
     * Method main.
     * @param args String[]
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    /**
     * Method restAPI.
    
     * @return RestAPI */
    /*@Bean
    public RestAPI restAPI(){
    	return new RestAPIImpl("http://localhost:7474/db/data", "neo4j", "neo4j1");
    }*/
    
    /**
     * Method objectMapper.
    
     * @return ObjectMapper */
    @Bean
    ObjectMapper objectMapper(){
    	ObjectMapper objMapper = new ObjectMapper().findAndRegisterModules();
    	objMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    	return objMapper;
    }
    
   /* @Configuration
    @EnableMongoRepositories("rs.repository")
    static class ApplicationConfig extends AbstractMongoConfiguration {

    	@Override
    	public String getDatabaseName() {
    		return "yourdb";
    	}

    	@Override
    	@Bean
    	public Mongo mongo() throws Exception {
    		return new MongoClient("127.0.0.1");
    	}
    }*/

    	
    
}
