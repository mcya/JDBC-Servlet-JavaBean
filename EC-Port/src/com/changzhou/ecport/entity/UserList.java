package com.changzhou.ecport.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class UserList {
	List users = new ArrayList();
	User user;

	public UserList() {
		super();
	}

	public User getUserList() {
		User user=null;
		for(Iterator it=users.iterator();it.hasNext();){
			user =(User)it.next();
		}
		return user;
	}

	public void removeUser() {
		users.clear();
	}
	public void add(User use){
		users.add(use);
	}
}
