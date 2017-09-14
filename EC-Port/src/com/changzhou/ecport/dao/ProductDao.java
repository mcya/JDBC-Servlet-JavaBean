package com.changzhou.ecport.dao;

import java.util.List;

import com.changzhou.ecport.entity.Product;
import com.changzhou.ecport.entity.User;

public interface ProductDao {

	public List ShowProductInfo();

	public Product ShowProductInfoById(String id);

	public void AddOrders(int id, String name, float cost, String uid,
			int statusid, int paywayid);

	public int getMaxid();

	public void addOrderLine(int orderid, int productid, int amount);
	public List showOrder(String name);
	public void removeOrder(String name);
	public List getProductOrder(String name);
	public String getPayway(String name);
	public List findByProName(String name);
}
