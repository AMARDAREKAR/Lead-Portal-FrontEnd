package com.yoan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class YoanSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()	// We don't need CSRF for this example
			.authorizeRequests()
			.antMatchers("/**").permitAll() // don't authenticate this particular request
			.antMatchers("/login").permitAll() // don't authenticate this particular request
			.antMatchers(HttpMethod.GET, "/employees").hasAnyRole("BDM","TEAM LEADER")
		  	.antMatchers(HttpMethod.GET, "/changeEmployeeStatus").hasAnyRole("BDM","TEAM LEADER")
		  	.antMatchers(HttpMethod.GET, "/employee/*").hasAnyRole("BDM","TEAM LEADER")
		  	.antMatchers(HttpMethod.POST, "/employee").hasAnyRole("BDM","TEAM LEADER")
		  	.antMatchers(HttpMethod.PUT, "/employee").hasAnyRole("BDM","TEAM LEADER")
		  	.antMatchers(HttpMethod.DELETE, "/employee/*").hasAnyRole("BDM","TEAM LEADER")
		  	.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()  // when using jwt need to add this as angular sends the options calls
			.anyRequest().authenticated() // all other requests need to be authenticated
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // make sure we use stateless session, session won't be used to store user's state.
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // Add a filter to validate the tokens with every request
	}
}