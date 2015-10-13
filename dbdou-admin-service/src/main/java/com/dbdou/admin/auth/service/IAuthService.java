package com.dbdou.admin.auth.service;

import java.util.List;

import com.dbdou.admin.auth.model.Auth;

public interface IAuthService {

	public boolean save(Auth auth);

	public boolean update(Auth auth);
	
	public boolean delete(int id);
	
	public Auth getById(int id);
	
	public List<Auth> getList(Auth auth);
	
	public List<Auth> getByIds(List<String> ids);
	
}
