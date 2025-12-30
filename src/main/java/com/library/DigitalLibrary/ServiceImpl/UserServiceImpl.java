package com.library.DigitalLibrary.ServiceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.DigitalLibrary.Entity.User;
import com.library.DigitalLibrary.Payload.LoginDTO;
import com.library.DigitalLibrary.Payload.UserDTO;
import com.library.DigitalLibrary.Repository.UserRepository;
import com.library.DigitalLibrary.Service.UserService;

@Service

public class UserServiceImpl implements UserService{
	
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserDTO dto) {
		
	    return 	entityToDto(userRepo.save(dtoToEntity(dto)));
		
	}
	
	private User dtoToEntity(UserDTO dto) {
		
		User user = modelMapper.map(dto,User.class);
		
		return user;
	}
	
	private UserDTO entityToDto(User user) {
		
		UserDTO dto = modelMapper.map(user,UserDTO.class);
		
		return dto;
	}
	
	@Override
	public User GetUser(LoginDTO loginDTO) {
		
	  Optional<User> userOpt= userRepo.findByEmail(loginDTO.getEmail());
	  
	  if(userOpt.isPresent()) {
		  return userOpt.get();
	  }
	  return null;
	}

	@Override
	public boolean validateUser(LoginDTO loginDTO) {
		
		
		Optional<User> userOpt= userRepo.findByEmail(loginDTO.getEmail());
		
		if(userOpt.isEmpty()) {
			return false;
		}
		
		User user= userOpt.get()
;
		if(!user.getPassword().equals(loginDTO.getPassword())) {
			return false;
		}
//	 User user= userRepo.findByEmail(loginDTO.getEmail()).orElseThrow(
//			()-> new UserNotFound(String.format("email '%s' not found",loginDTO.getEmail())
//			));
//	 
//	 if(!user.getPassword().equals(loginDTO)) {
//		 throw new InvalidPassword("Password Incorrect");
//		 
//	 }
		
		return true;
	}

}
