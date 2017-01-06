package br.com.zteste.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.zteste.model.Place;

@Component
public class PlaceValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Place.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Place Place = (Place) target;
		
		Double x = Place.getX();
		Double y = Place.getY();
		
		ValidationUtils.rejectIfEmpty(errors, "name", "place.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "x", "place.x.empty");
		ValidationUtils.rejectIfEmpty(errors, "y", "place.y.empty");

	}

}