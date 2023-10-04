package com.jonathanruiz.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jonathanruiz.authentication.models.LoginUser;
import com.jonathanruiz.authentication.models.User;
import com.jonathanruiz.authentication.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    public User create(User u) {
    	return userRepo.save(u);
    }
    
    public User find(Long id) {
		return userRepo.findById(id).orElse(null);
	}
    
    // TO-DO: Write register and login methods!
    // This method will be called from the controller
    // whenever a user submits a registration form.
    
    // TO-DO: Additional validations!
	// TO-DO - Reject values or register if no errors:
	// Reject if password doesn't match confirmation
	// Return null if result has errors
	// Hash and set password, save user to database
    public User register(User newUser, BindingResult result) {
    	
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
       
    	if (potentialUser.isPresent()) {
    		result.rejectValue("email", "Email exists in database");
    		return null; 
    	}
        
        if (!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("confirm", "Matches", "Password must match confirm password");
        	System.out.println(result.getAllErrors());
        }
        
        if (result.hasErrors()) {
        	return null;
        }
    
        
        String hash = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hash);
         
        return newUser;
    }
    
    // This method will be called from the controller
    // whenever a user submits a login form.
    
    // TO-DO: Additional validations!
	// TO-DO - Reject values:
	// Find user in the DB by email
    // Reject if NOT present
	// Reject if BCrypt password match fails
	// Return null if result has errors
    // Otherwise, return the user object
    public User login(LoginUser newLoginObject, BindingResult result) {

    	Optional<User> login = userRepo.findByEmail(newLoginObject.getEmail());
    	
        if (!login.isPresent()) {
        	result.rejectValue("email", "Exists", "Invalid Login");
        	return null;
        }
        
        User user = login.get();
        
        if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
        	result.rejectValue("email", "Matches", "Invalid login");
        }
        
        if (result.hasErrors()) {
        	return null;
        }
    	
        return user;
    }
}