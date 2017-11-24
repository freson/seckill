package org.seckill.service.impl;

import org.seckill.dao.UserDao;
import org.seckill.entity.User;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	
	@Override
	public User getUserbyId(String usrID) {
		return userDao.getUser(usrID);
	}
	
}
