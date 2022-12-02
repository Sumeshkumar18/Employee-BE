package com.learning.backend.Service;

import java.util.List;

import com.learning.backend.Entity.User;

public interface UserService {

	User add(User user);

	List<User> getAllUsers();

	User getUserById(Long id);

	User updateUser(User newUser, Long id);

	User deleteUser(Long id);
;
}
