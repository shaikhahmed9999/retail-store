package com.store.retail.services;

import org.springframework.stereotype.Service;

import com.store.retail.modals.UserDetail;
import com.store.retail.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@SuppressWarnings("deprecation")
	public UserDetail getUserDetailById(long id) {
		return userRepository.getById(id);
	}

}
