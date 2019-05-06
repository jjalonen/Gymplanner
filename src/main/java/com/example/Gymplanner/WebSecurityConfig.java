package com.example.Gymplanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.Gymplanner.service.UserService;
import com.example.Gymplanner.service.UserServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	 private UserService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		  http
	        .authorizeRequests().antMatchers("/css/**", "/registration", "/js/**", "/img/**", "/webjars/**").permitAll()
	        .and()
	        .authorizeRequests()
	        .antMatchers("/", "addexercise", "editexercise", "exerciselist", "save", "delete/{id}").permitAll()
	          .anyRequest().authenticated()
	          .and()
	      .formLogin()
	          .loginPage("/login")
	          .defaultSuccessUrl("/exerciselist")
	          .permitAll()
	          .and()
	      .logout()
	      .invalidateHttpSession(true)
          .clearAuthentication(true)
          .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
          .logoutSuccessUrl("/login?logout")
	          .permitAll();
		
	}
	
	 
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }
	 
	 @Bean
	    public DaoAuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
	        auth.setUserDetailsService(userService);
	        auth.setPasswordEncoder(passwordEncoder());
	        return auth;
	    }

    @Override
	    	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	 
}
