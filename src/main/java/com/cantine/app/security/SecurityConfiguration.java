package com.cantine.app.security;

import java.security.Principal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity(debug=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
		// auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
		// auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");//dba
		// have two roles.
		auth.jdbcAuthentication().dataSource(dataSource)
//				.passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("select username,password,isactive from tbl_user where username=?")
				.authoritiesByUsernameQuery("select * from tbl_user_role a inner join tbl_user b on a.userroleid =b.userroleid where b.username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
//		.antMatchers("/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/**").hasAnyRole("ADMIN","USER")
		.and()
		  .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
		  .usernameParameter("username").passwordParameter("password")
		.and()
		  .logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll()
		.and()
		  .exceptionHandling().accessDeniedPage("/403")
		.and()
		  .csrf();

	}

}
