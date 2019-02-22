package com.qa.MicroForm.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.MicroForm.persistence.domain.ReflectionForm;


public interface FormService {

	ReflectionForm createForm(ReflectionForm reflectionForm);
	
	List<ReflectionForm> getAllForms();
	
	ReflectionForm getForm(Long id);
}
