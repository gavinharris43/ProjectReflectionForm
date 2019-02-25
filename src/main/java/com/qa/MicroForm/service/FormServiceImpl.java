package com.qa.MicroForm.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.MicroForm.persistence.domain.ReflectionForm;


@Service
public class FormServiceImpl implements FormService{

	
	
	@Override
	public ReflectionForm createForm(ReflectionForm reflectionForm) {
		int oneToTen = reflectionForm.getHowsYourWeek();
		if(oneToTen == 0) {
			return null;
		}
		else {
			return reflectionForm;	
		}
	}


	@Override
	public List<ReflectionForm> getAllForms() {
		return null;
	}


	@Override
	public ReflectionForm getForm(Long id) {
		return null;
	}


	@Override
	public ResponseEntity<Object> deleteForm(Long id) {
		return null;
	}


	

}
