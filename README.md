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
