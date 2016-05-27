package com.cantine.app.serviceImplement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cantine.app.entity.User;
import com.cantine.app.repository.IUserDAO;


@Service("userDetailServiceImplement")
public class MyUserDetailServiceImplement implements UserDetailsService {

	@Autowired
	private IUserDAO userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userDao.findByUserame(username);
	        System.out.println("User : "+user);
	        if(user==null){
	            System.out.println("User not found");
	            throw new UsernameNotFoundException("Username not found");
	        }
	            return new User(user.getUserId(), user.getName(), user.getUsername(),user.getPassword(),user.isActive(), user.getRoles());

	}
	
//	 private List<GrantedAuthority> getGrantedAuthorities(User user){
//	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//	         
//	        for(Role userRole : user.getRoles()){
//	            System.out.println("UserProfile : "+userRole);
//	            authorities.add(new SimpleGrantedAuthority("ROLE_"+userRole.getRoleName()));
//	        }
//	        System.out.print("authorities :"+authorities);
//	        return authorities;
//	    }
}
