package com.learning.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.backend.Entity.User;
import com.learning.backend.Exception.UserNotFoundException;
import com.learning.backend.Repository.UserRepository;
import com.learning.backend.Service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User add(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException(id));
	}

//	@Override
//	public User updateUser(User newUser, Long id) {
//		
//		return userRepository.findById(id).map( user ->{
//			user.setName(newUser.getName());
//			user.setUserName(newUser.getUserName());
//			user.setEmail(newUser.getEmail());
//			userRepository.save(newUser);
//		}).orElseThrow(() ->new UserNotFoundException(id));
//	 }

	@Override
	public User updateUser(User user, Long id) {
	
		User newUser = userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
		newUser.setUserName(user.getUserName());
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		return userRepository.save(newUser);
	}

	@Override
	public User deleteUser(Long id) {
		
		if(!userRepository.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		userRepository.deleteById(id);
		return null;
	}

}
