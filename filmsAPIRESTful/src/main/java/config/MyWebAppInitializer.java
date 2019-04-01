package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Equivalent to Web.xml configuration file. Configures the DispatcherServlet
 * and defines all URLs under its domain.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@Configuration
public class MyWebAppInitializer implements WebApplicationInitializer {

	/**
	 * ServletDispatcher and URL mapping configuration.
	 */
    @Override
    public void onStartup(ServletContext container) {
      // Equivalent to web.xml
      XmlWebApplicationContext appContext = new XmlWebApplicationContext();
      appContext.setConfigLocation("/WEB-INF/dispatcher-servlet-config.xml");

      ServletRegistration.Dynamic dispatcher =
    		  container.addServlet("dispatcher", new DispatcherServlet(appContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
    }
 }