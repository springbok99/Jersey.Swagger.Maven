package cot.gcc.service;

import org.apache.log4j.Logger;
//import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
//import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

public class Application extends ResourceConfig {
	static Logger logger = Logger.getLogger(Application.class);

	public Application() {
		logger.info("--------------start--------------");

//		BeanConfig beanConfig = new BeanConfig();
//		beanConfig.setVersion("1.0.0");
//		beanConfig.setTitle("Jersey2Exam REST API");
//        beanConfig.setSchemes(new String[]{"http"});
//        beanConfig.setHost("localhost:8080");
//		beanConfig.setBasePath("/Jersey2Exam/api");
//		beanConfig.setResourcePackage("cot.gcc.service");
//		beanConfig.setScan(true);
//		logger.info("--------------start BeanConfig--------------");

		// SLF4JBridgeHandler.removeHandlersForRootLogger();
		// SLF4JBridgeHandler.install();
		// REQ_RESP_LOGGER.setLevel(Level.FINE);
		// LoggingFeature lf = new LoggingFeature(REQ_RESP_LOGGER);
		// register(lf);

		register(HelloResource.class);

//		register(UserResource.class);

		logger.info("--------------start HelloResource--------------");

//		register(JacksonJsonProvider.class);

		register(LoggingFilter.class);
		logger.info("--------------start LoggingFilter--------------");

		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);
		logger.info("--------------start ApiListingResource--------------");
		
		property(ServerProperties.TRACING, "ALL");
	}

}
