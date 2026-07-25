package com.umg.proyecto.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    // Registra el "motor" que recibe y responde peticiones SOAP en /ws/*
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            org.springframework.context.ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    // Carga nuestro XSD como el esquema del servicio
    @Bean(name = "temperatura")
    public XsdSchema temperaturaSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/temperatura.xsd"));
    }

    // Genera el WSDL automáticamente a partir del XSD
    @Bean(name = "temperaturaSchema")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema temperaturaSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TemperaturaPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://umg.com/compiladores/temperatura");
        wsdl11Definition.setSchema(temperaturaSchema);
        return wsdl11Definition;
    }
}