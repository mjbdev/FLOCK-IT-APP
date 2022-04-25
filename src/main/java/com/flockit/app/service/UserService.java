package com.flockit.app.service;

import com.flockit.app.exception.LoginException;
import com.flockit.app.model.User;

public interface UserService {

	public User findByCredentials(String username, String password) throws LoginException;

}
