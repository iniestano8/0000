package com.dbdou.admin.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbdou.admin.auth.dao.IAuthDao;
import com.dbdou.admin.auth.model.Auth;
import com.dbdou.admin.auth.service.IAuthService;

@Service("authService")
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private IAuthDao authDao;
	
	public boolean save(Auth auth) {
		authDao.save(auth);
		return true;
	}

	public boolean update(Auth auth) {
		authDao.update(auth);
		return true;
	}

	public boolean delete(int id) {
		authDao.delete(id);
		return true;
	}

	public Auth getById(int id) {
		return authDao.getById(id);
	}

	public List<Auth> getList(Auth auth) {
		return authDao.getList(auth);
	}

	public List<Auth> getByIds(List<String> ids) {
		return authDao.getByIds(ids);
	}

}
