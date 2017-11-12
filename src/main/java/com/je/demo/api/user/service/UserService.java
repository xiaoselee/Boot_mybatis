package com.je.demo.api.user.service;

import com.je.demo.commons.service.BaseService;
import com.je.demo.api.user.domain.User;
import com.je.demo.api.user.domain.UserCriteria;

public interface UserService extends BaseService<User, UserCriteria> {
	User findOneByUsername(String username);
	
	void changePassword(String newPassword);
}
