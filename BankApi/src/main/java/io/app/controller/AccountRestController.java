package io.app.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import io.app.model.AccountsFilter;
import io.app.validator.FilterValidator;


/**
 * @author shaiksha 
 * created on 27/11/2018
 */
@RestController
public class AccountRestController {


	private FilterValidator filterValidor;
	public AccountRestController(){
		filterValidor=new FilterValidator();
	}

	@GetMapping("/api/accounts")
	public ResponseEntity<?> getAccounts(@ModelAttribute AccountsFilter af, BindingResult errors
			){

		//preparing an AccountFilter object with request parameters
		/*AccountsFilter af=new AccountsFilter();
		af.setFilterType(filterType);
		af.setZipCode(zipCode);
		af.setCity(city);
		af.setState(state);
		af.setLatitude(latitude);
		af.setLongitude(longitude);
       */
		
		filterValidor.validate(af, errors);

		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else {
			return ResponseEntity.ok().body("Valid data");
		}
	}

}
