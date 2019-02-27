package com.qa.MicroForm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("${path.createForm}")
	public String createForm(@RequestBody ReflectionForm form) {
		sendToQueue(form);
		return "form created successfully";
	}
	
	private void sendToQueue(ReflectionForm form){
        SentReflectionForm formToStore = new SentReflectionForm(form);
        jmsTemplate.convertAndSend(formQueue, formToStore);
    }
	

}
