package tcs.project.limits.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tcs.project.limits.microservice.bean.Limits;
import tcs.project.limits.microservice.configuration.Configuration;

@RefreshScope
@RestController
public class LimitsController {
	
	@Autowired
	private Configuration config; 
	
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
//		return new Limits(10,20);
		return new Limits(config.getMinimum(),config.getMaximum(),config.getMessage());
	}
}
