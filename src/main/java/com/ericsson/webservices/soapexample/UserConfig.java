package com.ericsson.webservices.soapexample;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class UserConfig {
	
	    
	    @Bean
	    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context){
	        MessageDispatcherServlet dispatcherServlet= new MessageDispatcherServlet();
	        dispatcherServlet.setApplicationContext(context);
	        dispatcherServlet.setTransformWsdlLocations(true);
	        return new ServletRegistrationBean<MessageDispatcherServlet>(dispatcherServlet,"/service/*");
	    }
	    
	    @Bean(name="userdetailswsdl")
	    public DefaultWsdl11Definition defaultWsdl11Definition (XsdSchema schema) {
	        DefaultWsdl11Definition  defaultWsdl11Definition = new DefaultWsdl11Definition();
	        defaultWsdl11Definition.setPortTypeName("userdetails");
	        defaultWsdl11Definition.setLocationUri("/service/");
	        defaultWsdl11Definition.setTargetNamespace("http://www.ericsson.com/user");
	        defaultWsdl11Definition.setSchema(schema);
	        return defaultWsdl11Definition;
	        
	    }
	    
	    @Bean
	    public XsdSchema userSchema() {
	        return new SimpleXsdSchema(new ClassPathResource("user.xsd"));
	    }
	    
	    
	    
}
