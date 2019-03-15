
# Sample of Eureka, Zuul and Cloud Config usage

## Sub-projects

* [Eureka server](eureka-server/)
* [Config server](config-server/)
* [Gateway](gateway/)
* [Resource service](resource-service/)
* [Boot Admin server](admin-server/)

---

## Run

1. Start Eureka server
	```
	cd <PROJECT_ROOT_FOLDER>/eureka-server
	mvnw clean spring-boot:run
	```

2. Start Admin server
	```
	cd <PROJECT_ROOT_FOLDER>/admin-server
	mvnw clean spring-boot:run
	```

3. Start Cloud Config server
	```
	cd <PROJECT_ROOT_FOLDER>/config-server
	mvnw clean spring-boot:run
	```

4. Start Gateway
	```
	cd <PROJECT_ROOT_FOLDER>/gateway
	mvnw clean spring-boot:run
	```

5. Start resource service
	```
	cd <PROJECT_ROOT_FOLDER>/resource-service
	mvnw clean spring-boot:run
	```

6. Test if everything works
	```
	curl http://localhost:8080/resource-service/hello
	```

### Refresh external property

1. Update property file
	```
	cd <PROJECT_ROOT_FOLDER>/config-server/src/main/resources/
	nano resource-service.properties
	...
		comment
			external.property = hello world!
		uncomment
			external.property = hello everybody!
	...
	```

2. Restart Cloud Config server
	```
	cd <PROJECT_ROOT_FOLDER>/config-server
	mvnw clean spring-boot:run
	```

3. Refresh the resource service (`WARN`: directly not through the gateway)
	```
	curl -X POST http://localhost:9081/actuator/refresh
	```

---

## Links

* http://engineering.pivotal.io/post/local-eureka-zuul-cloud_config-with-spring/
* http://cloud.spring.io/spring-cloud-static/Finchley.SR1/single/spring-cloud.html#netflix-zuul-reverse-proxy
* http://cloud.spring.io/spring-cloud-netflix/single/spring-cloud-netflix.html#_why_is_it_so_slow_to_register_a_service
* https://www.devglan.com/spring-cloud/refresh-property-config-runtime
