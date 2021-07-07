# Spring-Configuration-Repository
Spring Cloud Config provides server-side and client-side support for externalized configuration in a distributed system. With the Config Server, you have a central place to manage external properties for applications across all environments. 
As an application moves through the deployment pipeline from dev to test and into production, you can manage the configuration between those environments and be certain that applications have everything they need to run when they migrate.
The default implementation of the server storage backend uses git, so it easily supports labelled versions of configuration environments as well as being accessible to a wide range of tooling for managing the content.

## Quick Start

### Build code

```bash
git clone git@github.com:ericdahl/spring-cloud-config-example.git
cd spring-cloud-config-example
mvn clean package
```

### Start Config Server

```bash
java -jar server/target/spring-cloud-config-example-server-1.0-SNAPSHOT.jar
```

Load [http://localhost:8888/master/development](http://localhost:8888/master/development). 
This displays the config properties which are being retrieved from the git repo defined 
in bootstrap.yml. This currently is the [`server-config` directory in this repository](https://github.com/ericdahl/spring-cloud-config-example/tree/master/server-config).

Note: keep the server running in backround. The client app in the next step needs to connect to it.

### Start Client App
```bash
java -jar client/target/*jar
```

Load [http://localhost:8080](http://localhost:8080) to see the property from the server. 
Alternatively, you can inspect the properties and their sources from the spring-boot-actuator
endpoint at [http://localhost:8080/env](http://localhost:8080/env)

### Reload configuration from server (at runtime)

Spring Cloud Config has a `@RefreshScope` mechanism to allow beans to be reinitialized
on demand to fetch updated configuration values. The AppController on the client
has this annotation, so it will display the new config value once the refresh
endpoint is called.

```bash
curl -X POST 'http://localhost:8080/actuator/refresh'
```
