package com.dbdou.admin.user.dao;

import java.util.List;

import com.dbdou.admin.user.model.User;

public interface IUserDao {

	public void save(User user);

	public void update(User user);

	public void delete(int id);

	public User getById(int id);

	public List<User> getList(User user);

	public User getByNameAndPwd(User user);
}
