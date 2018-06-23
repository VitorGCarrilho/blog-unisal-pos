package br.unisal.blogunisal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.unisal.blogunisal.model.enumerated.UserRole;
import br.unisal.blogunisal.service.AppUserDetailService;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
@EnableWebSecurity
@ComponentScan(basePackageClasses = AppUserDetailService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Value("${blog.uri.permitall}")
	private String[] permitAll;	
	
	@Value("${blog.uri.author}")
	private String[] permitAuthor;
	
	@Value("${blog.uri.normaluser.get}")
	private String[] permitNormalUserGet;
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("favicon.png");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http	
			.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
					.antMatchers(HttpMethod.GET, "/**").permitAll()
					.antMatchers(HttpMethod.GET, permitNormalUserGet).hasAnyAuthority(UserRole.AUTHOR.toString(), UserRole.NORMAL_USER.toString())
					.antMatchers("/**").hasAuthority(UserRole.AUTHOR.toString())
					.and()
					.csrf().disable()
			.httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
