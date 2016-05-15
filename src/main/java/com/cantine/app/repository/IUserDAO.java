package com.cantine.app.repository;

import java.util.List;

import com.cantine.app.entity.User;

public interface IUserDAO {
	public void addUser(User users);
	public User findByUserame(String username);
	public User getUserByID(int id);
	public String activateUser(int id);
	public String dsableUser(int id);
	public void updateUser(User user);
	public List listUser();
	public void removeUser(int id);
}
