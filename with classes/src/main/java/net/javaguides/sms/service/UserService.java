
package net.javaguides.sms.service;

import net.javaguides.sms.model.User;
import net.javaguides.sms.repository.UserRepository;
import net.javaguides.sms.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public abstract class UserService implements UserDetailsService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	public abstract UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;


	public abstract User save(UserRegistrationDto registrationDto);

	public abstract void deleteUserById(Long id);
}
