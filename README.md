# Conversor de Temperatura — SOAP vs REST

Proyecto desarrollado para el curso de **Desarrollo Web** de la Universidad Mariano Gálvez.

El objetivo de este proyecto es implementar la conversión de **grados Celsius a Fahrenheit** utilizando dos enfoques diferentes para servicios web: **SOAP** y **REST**. La idea es comparar cómo funciona cada uno, las diferencias en su implementación y en la forma de consumirlos.

---
**DANIELA GUITZ**

**0905-23-15374**
## Tecnologías que se utilizaron fueron:

- Java 17
- Spring Boot 3.3.4
- Maven
- Spring Web Services (Spring-WS)
- Postman
- IntelliJ IDEA

---

## LA estructura del proyecto esta desglosado de manera:

```
src/main/java/com/umg/proyecto/
 ├── ProyectoApplication.java
 ├── soap/
 │    ├── TemperaturaEndpoint.java
 │    ├── WebServiceConfig.java
 │    └── generated/
 └── rest/
      ├── TemperaturaController.java
      └── TemperaturaResponse.java

src/main/resources/
 └── xsd/
      └── temperatura.xsd
```

---

## Se puede ejecutar:

1. Clonar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Esperar a que Maven descargue las dependencias.
4. Ejecutar la clase `ProyectoApplication`.
5. Una vez iniciado Spring Boot, el proyecto estará disponible en:

```
http://localhost:8080
```

---

## Servicio SOAP

### WSDL

```
GET http://localhost:8080/ws/temperaturaSchema.wsdl
```

### Endpoint

```
POST http://localhost:8080/ws
```

Header:

```
Content-Type: text/xml
```

Ejemplo de petición:

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:tem="http://umg.com/compiladores/temperatura">
   <soapenv:Header/>
   <soapenv:Body>
      <tem:convertirTemperaturaRequest>
         <tem:celsius>25</tem:celsius>
      </tem:convertirTemperaturaRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

Respuesta:

```xml
<SOAP-ENV:Envelope>
   ...
</SOAP-ENV:Envelope>
```

---

## Servicio REST

Endpoint:

```
GET http://localhost:8080/api/temperatura/celsius/{valor}
```

Ejemplo:

```
GET http://localhost:8080/api/temperatura/celsius/25
```

Respuesta:

```json
{
  "celsius": 25.0,
  "fahrenheit": 77.0
}
```

---

## Pruebas

Las pruebas se realizaron con **Postman** verificando:

- Consulta del WSDL.
- Consumo del servicio SOAP.
- Consumo del servicio REST.

Todas las peticiones respondieron correctamente con código **200 OK**.

Las capturas utilizadas para comprobar el funcionamiento se encuentran en la carpeta correspondiente del proyecto.

---

## Comparación entre SOAP y REST

Durante el desarrollo fue fácil notar que ambos enfoques trabajan de manera diferente.

SOAP requiere definir primero un contrato (XSD), generar clases automáticamente y configurar varios componentes para publicar el servicio. Además, las pruebas deben enviarse utilizando XML dentro de un SOAP Envelope, por lo que su implementación lleva un poco más de tiempo.

REST fue mucho más sencillo de desarrollar. Solo fue necesario crear un controlador, recibir el valor desde la URL y devolver la respuesta en formato JSON, haciendo que tanto el desarrollo como las pruebas fueran más rápidas.

Las evidencias del funcionamiento del proyecto se encuentran adjuntas para ser visible el éxito de las tecnologías aplicadas.


En general, SOAP es una buena opción cuando se necesita un contrato bien definido entre sistemas y una comunicación más estructurada. REST, por otro lado, resulta más práctico para aplicaciones web y móviles donde se busca simplicidad y facilidad de integración.


---
