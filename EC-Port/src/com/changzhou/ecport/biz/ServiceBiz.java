package com.changzhou.ecport.biz;

import java.util.List;

import com.changzhou.ecport.entity.Product;
import com.changzhou.ecport.entity.User;

public interface ServiceBiz {
	public User IsLogin(String name,String pwd);//判断是否登录
	public void UpdateUser(User user);//更改用户信息
	public List ShowProInfo();//得到所有商品信息
	public Product ShowProInfoById(String id);//通过商品ID得到商品详细信息
	public boolean IsUse (String name);//判断是否有此用户名
	public void InsertUser(User user);//注册用户
	public void addOrders(int id,float cost, String name,int paywayid);//增加订单
	public void addOrderLine(int orderid, int productid, int amount);//在订单中增加商品
	public int getMaxid();//用于实现ID的自增加一
	public List getOrders(String name);//用于查找订单
	public void removeOrder(String name);//通过订单编号,删除订单
	public List getProOrder(String name);//通过订单得到所购买的商品列表
	public String getPay(String name);//得到付款方式
//	public List findByName(String name);//
}
