package com.flockit.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flockit.app.exception.LoginException;
import com.flockit.app.model.User;
import com.flockit.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository repository;

	@Value("${salt}")
	private String salt;

	@Override
	public User findByCredentials(String username, String password) throws LoginException {

		String hashedPassword = EncoderService.encode(salt + password);

		User user = repository.findByUsernameAndPassword(username, hashedPassword);

		if (user == null) {
			logger.error("Invalid username: " + username + " or password");
			throw new LoginException("Invalid username or password");
		}

		return user;
	}
}
