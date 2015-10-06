package test.global;

import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.RestAPIImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

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
    	return new RestAPIImpl("http://localhost:7474/db/data", "neo4j", "neo4j");
    }
    
    @Bean
    ObjectMapper objectMapper(){
    	ObjectMapper objMapper = new ObjectMapper().findAndRegisterModules();
    	objMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    	return objMapper;
    }
    
}
