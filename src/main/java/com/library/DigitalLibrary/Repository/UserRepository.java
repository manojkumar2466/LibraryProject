package com.library.DigitalLibrary.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.DigitalLibrary.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	Optional<User> findByEmail(String email);

}
