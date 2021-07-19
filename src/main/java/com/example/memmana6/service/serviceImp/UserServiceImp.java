package com.example.memmana6.service.serviceImp;
/*
 * 服务层的实现类，调用DAO层
 * 实现类类名可以任意（组件扫描只要求能扫描到服务接口的实现方法）
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.memmana6.dao.entity.User;
import com.example.memmana6.dao.mapper.IUserMapper;
import com.example.memmana6.service.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private IUserMapper userDao;  //注入DAO层对象
	
	public User queryUserByUsername(String un) {
		return userDao.getUserByUsername(un);
	}

	public User queryUserByUserNameAndPassword(String username, String password) {
		return userDao.getUserByUsernameAndPassword(username, password);
	}

	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		//userDao.deleteUser(user);
		userDao.deleteUser(user.getUsername());
	}

}
