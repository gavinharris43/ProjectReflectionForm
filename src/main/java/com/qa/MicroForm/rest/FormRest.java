package com.qa.MicroForm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.MicroForm.persistence.domain.ReflectionForm;
import com.qa.MicroForm.service.FormService;

@RequestMapping("${path.base}")
@RestController
public class FormRest {
	
	@Autowired
	private FormService service;
	
	@PostMapping("${path.createForm}")
	public ReflectionForm createForm(@PathVariable String reflectionForm) {
		return service.createForm(reflectionForm);
	}
	

}
