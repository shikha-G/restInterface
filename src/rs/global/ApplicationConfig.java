package rs.global;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;

/**
 * @author s.gupta
 */
//@Configuration
public class ApplicationConfig extends Neo4jConfiguration {

	/*
	 * Constructor for ApplicationConfig.
	 */
	public ApplicationConfig() {
		setBasePackage("rs");
	}

	/**
	 * Method graphDatabaseService.
	 * 
	 * @return GraphDatabaseService
	 */
	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {
		return new SpringCypherRestGraphDatabase("http://localhost:7474/db/data", "neo4j", "neo4j1");
	}

	/**
	 * Method neo4jConversionService.
	 * 
	 * 
	 * @return ConversionService
	 * @throws Exception
	 */
	@Override
	@Bean
	protected ConversionService neo4jConversionService() throws Exception {
		ConversionService service = super.neo4jConversionService();
		ConverterRegistry registry = (ConverterRegistry) service;
		registry.addConverter(new LocalDateTimeToStringConverter());
		registry.addConverter(new StringToLocalDateTimeConverter());

		return service;
	}

	/**
	 * @author s.gupta
	 */
	public static class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
		/**
		 * Method convert.
		 * 
		 * @param source
		 *            String
		 * 
		 * @return LocalDateTime
		 */
		public LocalDateTime convert(final String source) {
			return LocalDateTime.parse(source, DateTimeFormatter.ISO_DATE_TIME);
		}
	}

	/**
	 * @author s.gupta
	 */
	public static class LocalDateTimeToStringConverter implements Converter<LocalDateTime, String> {
		/**
		 * Method convert.
		 * 
		 * @param source
		 *            LocalDateTime
		 * 
		 * @return String
		 */
		public String convert(final LocalDateTime source) {
			return source.format(DateTimeFormatter.ISO_DATE_TIME);
		}
	}

}