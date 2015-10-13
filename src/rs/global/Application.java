package rs.global;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

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
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
@ComponentScan(basePackages = {"rs.controller", "rs.service", "rs.repository", "rs.validate"})
@PropertySource("classpath:config.properties")
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
			setBasePackage("rs");
		}

		@Bean(destroyMethod="shutdown")
	    public GraphDatabaseService graphDatabaseService(){
			return new SpringCypherRestGraphDatabase("http://localhost:7474/db/data", "neo4j", "neo4j1");
		}
		
		@Override
		@Bean
		protected ConversionService neo4jConversionService() throws Exception{
			ConversionService service = super.neo4jConversionService();
			ConverterRegistry registry = (ConverterRegistry)service;
			registry.addConverter(new LocalDateTimeToLongConverter());
			registry.addConverter(new StringToLocalDateTimeConverter());
			return service;
		}
		
		public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

		    @Value("${neo4j.dateTime.format:yyyy-MM-dd HH:mm:ss}")
		    private String dateTimeFormat;
		    
		   

		   //@Override
		    public LocalDateTime convert( final String source) {
		        return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(dateTimeFormat));
		    }
		}
		public static class LocalDateTimeToLongConverter implements Converter<LocalDateTime, Long> {

		    //@Override
		    public Long convert(final LocalDateTime source) {
		        return source.getLong(ChronoField.EPOCH_DAY);
		    }
		}

		public static class LongToLocalDateTimeConverter implements Converter<Long, LocalDateTime> {

		    //@Override
		    public LocalDateTime convert(final Long source) {
		        //return new Date(source.longValue());
		    	return LocalDateTime.now();
		    }
		}
	}
    
}
