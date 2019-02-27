package com.qa.InspectorFacade.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.InspectorFacade.persistence.domain.ReflectionForm;
import com.qa.InspectorFacade.persistence.domain.SentReflectionForm;
import com.qa.InspectorFacade.service.FormService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class FormRest {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${queue.formQueue}")
	private String formQueue;
	
	@PostMapping("${path.createForm}")
	public ReflectionForm createForm(@RequestBody ReflectionForm form) {
		sendToQueue(form);
		return form;
	}
	
	private void sendToQueue(ReflectionForm form){
        SentReflectionForm formToStore = new SentReflectionForm(form);
        jmsTemplate.convertAndSend(formQueue, formToStore);
    }
	

}
