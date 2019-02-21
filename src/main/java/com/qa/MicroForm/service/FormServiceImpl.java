package com.qa.MicroForm.service;


import java.util.List;



import com.qa.MicroForm.persistence.domain.ReflectionForm;



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


	

}
