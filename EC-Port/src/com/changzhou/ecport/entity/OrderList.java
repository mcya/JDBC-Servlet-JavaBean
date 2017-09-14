package com.changzhou.ecport.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderList {
	List orderList = new ArrayList();
	Order order;

	

	public OrderList() {
		super();
	}

	public Order getOrderList() {
		Order order=null;
		for(Iterator it=orderList.iterator();it.hasNext();){
			order =(Order)it.next();
		}
		return order;
	}

	public void removeUser() {
		orderList.clear();
	}
	public void add(Order order){
		orderList.add(order);
	}
}
