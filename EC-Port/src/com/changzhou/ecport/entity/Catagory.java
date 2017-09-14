package com.changzhou.ecport.entity;

public class Catagory {
	private String name;
	private String desc;
	public Catagory() {
		super();
	}
	public Catagory(String desc) {
		super();
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
