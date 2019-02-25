package com.qa.MicroForm.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.qa.MicroForm.persistence.domain.ReflectionForm;


public interface FormService {

	ReflectionForm createForm(ReflectionForm reflectionForm);
	
	List<ReflectionForm> getAllForms();
	
	ReflectionForm getForm(Long id);
	
	ResponseEntity<Object> deleteForm(Long id);
}
