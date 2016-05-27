package com.cantine.app.security;

import java.security.Principal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cantine.app.serviceImplement.MyUserDetailServiceImplement;

@Configuration
//@EnableWebSecurity(debug=true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Autowired 
	@Qualifier("userDetailServiceImplement")
	MyUserDetailServiceImplement userDetailsService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
		// auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
		// auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");//dba
		// have two roles.
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.passwordEncoder(passwordEncoder())
//				.usersByUsernameQuery("select username,password,isactive from tbl_user where username=?")
//				.authoritiesByUsernameQuery("select username,rolename from tbl_user u INNER join tbl_user_role ur on u.userid=ur.userid inner join tbl_role r on ur.roleid=r.roleid where u.username=?");
//	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/**")
		.access("hasRole('ROLE_ADMIN')").and().formLogin()
		.loginPage("/login").failureUrl("/login?error").permitAll()
		.usernameParameter("username")
		.passwordParameter("password")
		.and().logout().logoutSuccessUrl("/login?logout")
		.and().csrf()
		.and().exceptionHandling().accessDeniedPage("/403");

	}

}
