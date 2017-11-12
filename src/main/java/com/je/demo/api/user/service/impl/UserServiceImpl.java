package com.je.demo.api.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.je.demo.commons.dao.BaseDao;
import com.je.demo.commons.service.BaseServiceImpl;
import com.je.demo.api.user.dao.UserMapper;
import com.je.demo.api.user.domain.User;
import com.je.demo.api.user.domain.UserCriteria;
import com.je.demo.api.user.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, UserCriteria>
		implements UserService {

	@Autowired
	private UserMapper userDao;

	@Override
	public User findOneByUsername(String username) {
		Assert.notNull(username);
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.or().andUsernameEqualTo(username);
		List<User> userList = userDao.selectByExample(userCriteria);
		if(userList.size()>0)
			return userList.get(0);
		else
			return null;
	}

	@Override
	public void changePassword(String newPassword) {
		Assert.notNull(newPassword);
		
	}
	
	@Override
	protected BaseDao<User, UserCriteria, String> getDao() {
		return userDao;
	}
}
