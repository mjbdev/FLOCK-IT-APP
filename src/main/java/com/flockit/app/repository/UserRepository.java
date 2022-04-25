package com.flockit.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flockit.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUsernameAndPassword(String username, String password);
}
