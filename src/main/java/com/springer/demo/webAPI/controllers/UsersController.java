package com.springer.demo.webAPI.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springer.demo.business.abstracts.UserService;
import com.springer.demo.core.entities.User;
import com.springer.demo.core.utilities.results.DataResult;
import com.springer.demo.core.utilities.results.ErrorDataResult;
import com.springer.demo.core.utilities.results.Result;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	
//	if there occurs an error in the system ---> it calls this method
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String,String>();
		for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		} 
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>("Validation errors", validationErrors);
		return errors;
	}
	
//	@GetMapping("/findByEmail")
//	public DataResult<User> findByEmail(@RequestParam String email){
//		return this.userService.findByEmail(email);
//	}
	 
}