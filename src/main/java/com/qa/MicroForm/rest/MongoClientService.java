package com.qa.MicroForm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.MicroForm.persistence.domain.ReflectionForm;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class MongoClientService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${url.mongoclient}")
	private String mongoURL;

	@Value("${path.mongoClientServiceBasePath}")
	private String mongoClientServiceBasePath;
	
	@Value("${path.mongoGetAllForms}")
	private String mongoClientGetAllFormsPath;
	
	@Value("${path.mongoClientGetFormById}")
	private String mongoClientGetFormById;
	
	
	
	public ReflectionForm readFormById(Long id) {
		return restTemplate.getForObject(mongoURL + mongoClientServiceBasePath 
				+ mongoClientGetFormById + id, ReflectionForm.class);
	}
}
