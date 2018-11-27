package io.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import io.app.model.AccountsFilter;



/**
 * @author shaiksha
 * Validar for validatinng a filter data
 *
 */
public class FilterValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return AccountsFilter.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		
		AccountsFilter af=(AccountsFilter)target;
		
		if(af.getFilterType().equalsIgnoreCase("zip")||af.getFilterType().equalsIgnoreCase("city&state")||af.getFilterType().equalsIgnoreCase("lon&lat")) {
		if(af.getFilterType().equalsIgnoreCase("zip")) {
			if(af.getZipCode().equals("")||af.getZipCode().length()<0||af.getZipCode()==null)
			errors.rejectValue("zipCode","","Please provide a zip code");			
		}
		else if(af.getFilterType().equalsIgnoreCase("city&state")){
			 if(af.getCity().length()<0||af.getCity().equals("")||af.getCity()==null) {
			    errors.rejectValue("city","","Please provide a city name");		
			 }
		    if(af.getState().length()<0||af.getState().equals("")||af.getState()==null) {
			    errors.rejectValue("state","400","Please provide a state name");		
		     }
		}else {
			
			if(af.getLatitude()==0.0) {
			    errors.rejectValue("latitude","","Please provide the value for  latitude  ");		
			 }
		    if(af.getLongitude()==0.0) {
			    errors.rejectValue("getLongitude","","Please provide the value for  longitued");		
		     }
	      	}
		}
		else {
		    errors.rejectValue("filterType","","Please choose a Filter Type in [ zip, city&state, lon&lat ] ");		
		}
	}
}
