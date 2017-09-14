package com.changzhou.ecport.biz.impl;

import java.util.Date;
import java.util.List;

import com.changzhou.ecport.biz.ServiceBiz;
import com.changzhou.ecport.dao.ProductDao;
import com.changzhou.ecport.dao.ProductDaoFactory;
import com.changzhou.ecport.dao.UserDao;
import com.changzhou.ecport.dao.UserDaoFactory;
import com.changzhou.ecport.entity.Product;
import com.changzhou.ecport.entity.User;

public class ServiceBizImpl implements ServiceBiz{
	UserDao dao = UserDaoFactory.getDao();;
	ProductDao dpo = ProductDaoFactory.getProductDao();
	public User IsLogin(String name, String pwd) {
		User user = dao.UserInfo(name, pwd);
		return user;
	}
	public void UpdateUser(User user){
			try {
				dao.Modify(user);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		
		
	}
	public List ShowProInfo() {
		List pro =  dpo.ShowProductInfo();
		return pro;
	}
	
	public Product ShowProInfoById(String id) {
		Product pro=dpo.ShowProductInfoById(id);
		return pro;
	}
	public boolean IsUse(String name) {
		
		return dao.IsEmpty(name);
	}
	public void InsertUser(User user) {
		dao.Insert(user);
	}
	
	public void addOrderLine(int orderid, int productid, int amount) {
		dpo.addOrderLine(orderid, productid, amount);
	}
	public int getMaxid(){
		return dpo.getMaxid();
	}
	public void addOrders(int id,float cost, String uid,int paywayid) {
		String name =(new Date()).toString();
		dpo.AddOrders(id, name, cost, uid, 1, paywayid);
	}
	public List getOrders(String name) {
		List pro =  dpo.showOrder(name);
		return pro;
	}
	public void removeOrder(String name) {
		dpo.removeOrder(name);
		
	}
	public List getProOrder(String name) {
		List pro=dpo.getProductOrder(name);
		return pro;
	}
	public String getPay(String name){
		return dpo.getPayway(name);
	}
//	public List findByName(String name){
//		return dpo.findByProName(name);
//	}
}
