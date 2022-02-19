package br.com.jamesson.services.v1;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.jamesson.repository.UserRepository;

@Service
public class UserServices implements UserDetailsService {

	private UserRepository repository;
	
	public UserServices(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = repository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Username " + username + " not found.");
		}
		
		return user;
	}
	

}
