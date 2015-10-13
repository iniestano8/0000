package com.dbdou.admin.role.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbdou.admin.role.dao.IRoleDao;
import com.dbdou.admin.role.model.Role;
import com.dbdou.admin.role.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;
	
	public boolean save(Role role) {
		roleDao.save(role);
		return true;
	}

	public boolean update(Role role) {
		roleDao.update(role);
		return true;
	}

	public boolean delete(int id) {
		roleDao.delete(id);
		return true;
	}

	public Role getById(int id) {
		return roleDao.getById(id);
	}

	public List<Role> getList(Role role) {
		return roleDao.getList(role);
	}

}
