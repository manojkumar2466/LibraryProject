package com.library.DigitalLibrary.Service;

import com.library.DigitalLibrary.Entity.User;
import com.library.DigitalLibrary.Payload.LoginDTO;
import com.library.DigitalLibrary.Payload.UserDTO;

public interface UserService {
	
	public UserDTO createUser(UserDTO dto);
	
	public boolean validateUser(LoginDTO loginDTO);
	
	public User GetUser(LoginDTO loginDTO);

}
