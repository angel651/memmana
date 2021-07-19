package com.example.memmana6.service;
/*
 * 服务层接口
 */
import com.example.memmana6.dao.entity.User;

public interface UserService {
	
	public User queryUserByUsername(String username);

	public User queryUserByUserNameAndPassword(String username, String password);
	
	public void addUser(User user);
	
	public void updateUser(User user);

	public void deleteUser(User user);



}