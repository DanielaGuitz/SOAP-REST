package com.umg.proyecto.soap;

import com.umg.proyecto.soap.generated.ConvertirTemperaturaRequest;
import com.umg.proyecto.soap.generated.ConvertirTemperaturaResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TemperaturaEndpoint {

    private static final String NAMESPACE_URI = "http://umg.com/compiladores/temperatura";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "convertirTemperaturaRequest")
    @ResponsePayload
    public ConvertirTemperaturaResponse convertirTemperatura(@RequestPayload ConvertirTemperaturaRequest request) {

        double celsius = request.getCelsius();
        double fahrenheit = (celsius * 9.0 / 5.0) + 32;

        ConvertirTemperaturaResponse response = new ConvertirTemperaturaResponse();
        response.setCelsius(celsius);
        response.setFahrenheit(fahrenheit);

        return response;
    }
}