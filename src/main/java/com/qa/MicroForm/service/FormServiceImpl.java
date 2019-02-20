package com.qa.MicroForm.service;


import com.qa.MicroForm.persistence.domain.ReflectionForm;


public class FormServiceImpl implements FormService{

	
	@Override
	public ReflectionForm createForm(String reflectionForm) {
		return new ReflectionForm();
	}

}
