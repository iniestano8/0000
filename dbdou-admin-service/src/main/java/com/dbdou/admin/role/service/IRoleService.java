package com.dbdou.admin.role.service;

import java.util.List;

import com.dbdou.admin.role.model.Role;

public interface IRoleService {

	public boolean save(Role role);
	
	public boolean update(Role role);
	
	public boolean delete(int id);
	
	public Role getById(int id);
	
	public List<Role> getList(Role role);
	
}
