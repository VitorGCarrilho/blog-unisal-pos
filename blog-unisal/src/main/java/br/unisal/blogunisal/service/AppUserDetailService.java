package br.unisal.blogunisal.service;



import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
@Service
public class AppUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		br.unisal.blogunisal.model.User user = userService.findByEmail(email);
		Set<SimpleGrantedAuthority> authorities = new HashSet<>(); 
		authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
		
		return new User(user.getEmail(), user.getPassword(), authorities);
	}

}
