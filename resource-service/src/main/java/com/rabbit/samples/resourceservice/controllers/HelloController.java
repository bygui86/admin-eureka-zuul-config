package com.rabbit.samples.resourceservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * This controller will get the external.property from the Spring Cloud Configuration Server and return it when you hit the controller through the Zuul router.
 * This is how we will know that everything is connected the right way.
 *
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 15 Mar 2019
 */
/* @RefreshScope
	. Refresh the properties once the Configuration Server has updated.
	. Must be applied to the component leveraging the property, not on the Application Class!
 */
@RefreshScope
@RestController
public class HelloController {

	@Value("${external.property}")
	String property;

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {

		return ResponseEntity.ok(property);
	}

}
