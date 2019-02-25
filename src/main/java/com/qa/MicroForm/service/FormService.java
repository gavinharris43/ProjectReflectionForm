package com.qa.MicroForm.service;


import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.qa.MicroForm.persistence.domain.ReflectionForm;


public interface FormService {

	ReflectionForm createForm(ReflectionForm reflectionForm);
	
	ArrayList<ReflectionForm> getAllForms();
	
	ReflectionForm getForm(Long id);
	
	ResponseEntity<Object> deleteForm(Long id);
}
