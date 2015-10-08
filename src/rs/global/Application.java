package rs.global;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.RestAPIImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
@ComponentScan(basePackages = {"test.controller", "test.service", "test.repository", "test.validate"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public RestAPI restAPI(){
    	return new RestAPIImpl("http://localhost:7474/db/data", "neo4j", "neo4j1");
    }
    
    @Bean
    ObjectMapper objectMapper(){
    	ObjectMapper objMapper = new ObjectMapper().findAndRegisterModules();
    	objMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    	return objMapper;
    }
    
    @Configuration
	static class ApplicationConfig extends Neo4jConfiguration {

		public ApplicationConfig() {
			setBasePackage("test");
		}

		@Bean(destroyMethod="shutdown")
	    public GraphDatabaseService graphDatabaseService(){//@Value("${neo4j.database.location}") String dbUrl) {
			return new SpringCypherRestGraphDatabase("http://localhost:7474/db/data", "neo4j", "neo4j1");
	}
	}
    
}
