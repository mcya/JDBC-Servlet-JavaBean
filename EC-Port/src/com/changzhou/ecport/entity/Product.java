package com.changzhou.ecport.entity;

import java.util.HashMap;
import java.util.Map;

public class Product {
	private int id;//
	private String name;// 书名
	private float price;// 价格
	private String author;// 作者
	private String publish;// 出版社
	private int pages;// 页数
	
	private String desc;// 简介
	private String image;// 图片位置
	private String cata;//类型
	
	private int amount=1;
	private double totle;

	Map cartList= new HashMap();
	public Product(int id, String name, float price, String author,
			String publish, int pages, String desc, String image, String cata,
			int amount, double totle) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
		this.publish = publish;
		this.pages = pages;
		this.desc = desc;
		this.image = image;
		this.cata = cata;
		this.amount = amount;
		this.totle = totle;
	}

	public Product(int id,String name, float price, int amount) {
		super();
		this.id=id;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.totle = price*amount;
	}

	public String getCata() {
		return cata;
	}

	public void setCata(String cata) {
		this.cata = cata;
	}

	

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	public Map getCartList(){
		
		return cartList;
	}
	public void addCart(Product pro){
		String id = String.valueOf(pro.getId());
		cartList.put(id, pro);
	}
	public void changeProduct(int ids,int amount){
		Product pro=(Product) cartList.get(ids);
		pro.setAmount(amount);
		
		cartList.put(id, pro);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTotle() {
		return totle;
	}

	public void setTotle(double totle) {
		this.totle = totle;
	}

	public Product(int id, String name, float price, String author,
			String publish, int pages, String desc, String image, String cata) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
		this.publish = publish;
		this.pages = pages;
		this.desc = desc;
		this.image = image;
		this.cata = cata;
	}

	

}
