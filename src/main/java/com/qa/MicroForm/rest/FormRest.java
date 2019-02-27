package com.qa.MicroForm.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.MicroForm.persistence.domain.ReflectionForm;
import com.qa.MicroForm.persistence.domain.SentReflectionForm;
import com.qa.MicroForm.service.FormService;

@RequestMapping("${path.base}")
@RestController
public class FormRest {
	
	@Autowired
	private FormService service;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${queue.formQueue}")
	private String formQueue;
	
	@PostMapping("${path.createForm}")
	public ReflectionForm createForm(@RequestBody ReflectionForm reflectionForm) {
		sendToQueue(reflectionForm);
		return service.createForm(reflectionForm);
	}
	
	private void sendToQueue(ReflectionForm form){
        SentReflectionForm formToStore = new SentReflectionForm(form);
        jmsTemplate.convertAndSend(formQueue, formToStore);
    }
	

}
