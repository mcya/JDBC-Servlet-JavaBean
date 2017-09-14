package com.changzhou.ecport.entity;

import java.util.HashMap;
import java.util.Map;

public class ShopCartList {
	Map cartList = new HashMap();
	Product pro;

	public ShopCartList() {
		super();
	}

	public void clearAll() {
		this.cartList.clear();
	}
	public void addCart(Product pro){
		String id = String.valueOf(pro.getId());
		if(cartList.get(id)!=null){
			pro.setAmount(pro.getAmount()+1);
		}
		
		cartList.put(id, pro);
	}
	public void changeProduct(int ids,int amount){
		
		Product pro=(Product) cartList.get(String.valueOf(ids));
		pro.setAmount(amount);
		
		cartList.put(String.valueOf(ids), pro);
	}
    public Map getCartList(){
		
		return cartList;
	}
    public void removeProduct(String id){
    	cartList.remove(id);
    }
}
