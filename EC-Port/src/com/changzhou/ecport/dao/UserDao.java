package com.changzhou.ecport.dao;

import com.changzhou.ecport.entity.User;

public interface UserDao {
	public User UserInfo(String name,String pwd);
	public boolean IsEmpty (String name);
	public void Insert(User user);
	public void Modify(User user);
	public void Delete(User user);
	public User FindbyName(String name);
}
