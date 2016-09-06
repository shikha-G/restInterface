package rs.global;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.RestAPIImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author s.gupta
 * @version $Revision: 1.0 $
 */
@SpringBootApplication
@ComponentScan(basePackages = {"rs.controller", "rs.service", "rs.repository", "rs.validate"})
@PropertySource("classpath:config.properties")
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
    
    
    
}
