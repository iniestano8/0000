package com.dbdou.admin.role.dao;

import java.util.List;

import com.dbdou.admin.role.model.Role;

public interface IRoleDao {
	
	public void save(Role role);

	public void update(Role role);

	public void delete(int id);

	public Role getById(int id);

	public List<Role> getList(Role role);
}
