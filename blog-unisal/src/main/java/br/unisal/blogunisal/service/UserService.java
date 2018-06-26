package br.unisal.blogunisal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.unisal.blogunisal.exeption.NotFoundException;
import br.unisal.blogunisal.model.User;
import br.unisal.blogunisal.repository.UserRepository;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public User findOne(String id){
		User user = User.builder()
				.id(id)
				.build();	
		return userRepository.findOne(Example.of(user)).orElseThrow(NotFoundException::new);
	}
	
	public User findByEmail(String email) {
		User user = User.builder()
				.email(email)
				.build();	
		return userRepository.findOne(Example.of(user)).orElseThrow(NotFoundException::new);
	}

	/**
	 * @return
	 */
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void delete(String id) {
		userRepository.delete(this.findOne(id));
	}
}
