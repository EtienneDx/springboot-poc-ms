# Read Me First
This project is a proof of concept for dividing riseclipse into micro-services.

# Getting Started
This project builds to a jar that you can start with `java -jar .\target\riseclipse-ms-poc-0.0.1-SNAPSHOT.jar`, or to a docker image. The next step is to use this docker image to launch three instances of the project in a kubernetes cluster, with one instance's /dispatch endpoint calling the other two.

## Next steps

- Write kubernetes definitions
- test proper splitting of requests
- Create docker images for different components of riseclipse (NSD vs OSD constraints)
- Create a new main image to call the other two images
- Re-use the kubernetes definitions with the new images

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

