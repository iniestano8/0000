package com.dbdou.admin.user.service;

import java.util.List;

import com.dbdou.admin.user.model.User;

public interface IUserService {

	public boolean save(User user);

	public boolean update(User user);

	public boolean delete(int id);

	public User getById(int id);

	public List<User> getList(User user);

	public User getByNameAndPwd(User user);

}
