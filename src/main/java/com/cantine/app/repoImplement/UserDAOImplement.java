package com.cantine.app.repoImplement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cantine.app.entity.User;
import com.cantine.app.repository.IUserDAO;

@Repository
public class UserDAOImplement  implements IUserDAO{
	
	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public void addUser(User users) {
		Session ss = sf.getCurrentSession();
		ss.save(users);
		
	}

	@Override
	public User findByUserame(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String activateUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dsableUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		
	}

}
