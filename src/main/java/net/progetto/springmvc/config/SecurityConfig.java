package net.progetto.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    ;


    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    private static final String[] ADMIN_MATCHER =
            {
                    "/user/**",
                    "/auto/showForm/**",
                    "/auto/updateForm/**",
                    "/auto/saveAuto/**",
                    "/auto/delete/**",
                    "/prenotazione/list/**",
                    "/prenotazione/delete/**",
                    "/prenotazione/conferma/**"

            };

    private static final String[] CUSTOMER_MATCHER =
            {
                    "/prenotazione/listPrenotazioniConfermate/**",
                    "/prenotazione/showForm/**",
                    "/prenotazione/savePrenotazione/**",
                    "/prenotazione/listAuto/**"

            };

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/auto/list").permitAll()
                .antMatchers(ADMIN_MATCHER).access("hasRole('ADMIN')")
                .antMatchers(CUSTOMER_MATCHER).access("hasRole('CUSTOMER')")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .failureUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login")
                .and()
                .logout()
                .logoutUrl("/logout")

                .and().csrf().disable();

    }
	

	

	


	
	/*
	@Bean
    public PersistentTokenRepository persistentTokenRepository() 
	{
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        tokenRepositoryImpl.setDataSource(dataSource);
        
        return tokenRepositoryImpl;
    }
    */

}



/*
@Bean
@Override
public UserDetailsService userDetailsService()
{
	UserBuilder users = User.builder();
	
	InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	
	//Utente 1
	manager.createUser(
			users
			.username("Nicola")
			.password(new BCryptPasswordEncoder().encode("123Stella"))
			.roles("USER")
			.build());
	
	manager.createUser(
			users
			.username("Admin")
			.password(new BCryptPasswordEncoder().encode("VerySecretPwd"))
			.roles("USER", "ADMIN")
			.build());
	
	return manager;

}
*/