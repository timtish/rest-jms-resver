package ru.timtish.stub.soap;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class SoapConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean
    public XsdSchema xsdSchema() {
        return new SimpleXsdSchema(new InputStreamResource(getClass().getResourceAsStream("/schema.xsd")));
    }

    @Bean("test")
    public DefaultWsdl11Definition service1Definition(XsdSchema xsdSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("service1");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(Service1.NAMESPACE_URI);
        wsdl11Definition.setSchema(xsdSchema);
        return wsdl11Definition;
    }
}
