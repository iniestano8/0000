package com.dbdou.admin.auth.dao;

import java.util.List;

import com.dbdou.admin.auth.model.Auth;

public interface IAuthDao {

	public void save(Auth auth);

	public void update(Auth auth);
	
	public void delete(int id);
	
	public Auth getById(int id);
	
	public List<Auth> getList(Auth auth);
	
	public List<Auth> getByIds(List<String> ids);
	
}
