package com.library.DigitalLibrary.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.DigitalLibrary.Entity.User;
import com.library.DigitalLibrary.Payload.LoginDTO;
import com.library.DigitalLibrary.Payload.UserDTO;
import com.library.DigitalLibrary.Service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/registration")
	public ResponseEntity<UserDTO> createUSer(@RequestBody @Validated UserDTO dto) {
		return new ResponseEntity<>(userService.createUser(dto), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDTO logindto){
		
		User user=userService.GetUser(logindto);
		
		if(user!=null) {

			if(userService.validateUser(logindto))return ResponseEntity.ok(user);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("worng password or use");
		}	
		
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid email or password");
	}

	
}
