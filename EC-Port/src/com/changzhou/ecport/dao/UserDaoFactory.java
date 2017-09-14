package com.changzhou.ecport.dao;

import com.changzhou.ecport.dao.impl.UserDaoImpl;

public class UserDaoFactory {
	public static UserDao getDao(){
		return new UserDaoImpl();
	}
}
