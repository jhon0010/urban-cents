# Urban Cents Microservices Project

This project demonstrates the capabilities of microservices architecture using a multi-module Gradle setup. The project is structured into multiple modules to exhibit different aspects and functionalities of a microservices ecosystem. The initial setup includes `payment` and `common` modules, among others, to showcase the application's modular structure and inter-service communication.

## Multi-Module Setup with Gradle

Utilizing Gradle's `allprojects` and `subprojects` configurations, this project is structured to have a common build and dependency management across all modules while allowing specific configurations for individual modules.

### Common Configuration

The `allprojects` block in the root `build.gradle` file defines common configurations, repositories, and dependencies that are shared across all modules.

```gradle
allprojects {
    repositories {
        mavenCentral()
    }
    // ... other common configurations
}
```

# Building and Running
To build the project, navigate to the project root directory and run:


```bash
./gradlew build
```
To run a specific module, navigate to the module directory and run:

```bash
./gradlew :moduleName:bootRun
```
Replace moduleName with the name of the module you wish to run.


# Eureka server and enable service discovery 

## Start the Eureka server

To start the Eureka server, navigate to the `eureka-server` directory and run:

```bash
./gradlew clen build bootRun
```
Now you can access to http://localhost:8761/ Eureka service.

## Enable service discovery

To enable service discovery, we need to add the following configuration to the application.properties of the service we want to register with the Eureka server.

```bash
# eureka server client configuration
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.client.service-url.default-zone=http://localhost:8761/eureka/


spring.config.import=optional:configserver:http://localhost:8761

# Actuator Configuration to expose all endpoints
management.endpoints.web.exposure.include=*
```
