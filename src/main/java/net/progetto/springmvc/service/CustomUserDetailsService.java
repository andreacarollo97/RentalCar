package net.progetto.springmvc.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserService userService;

	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException
	{

		 net.progetto.springmvc.entity.User user = userService.getUserByUsername(username);

		 UserBuilder builder;

		 builder = User.withUsername(user.getUsername());
		 builder.disabled(false);
		 builder.password(user.getPassword());

		 String[] ruoli = new String[1];
		 if (user.getStatus() == 1){
			 ruoli[0] = "ROLE_ADMIN";
		 }
		 else {
			 ruoli[0] = "ROLE_CUSTOMER";
		 }

		 builder.authorities(ruoli);
		 
		 return builder.build();
	}
	 
}
