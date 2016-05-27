package com.cantine.app.repoImplement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public User findByUserame(String username) {
		List<User> users = new ArrayList<User>();
		users = sf.getCurrentSession()
			.createQuery("from User where username=:username")
			.setString("username", username)
			.list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

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
