package com.changzhou.ecport.entity;

import com.changzhou.ecport.biz.ServiceBiz;
import com.changzhou.ecport.biz.ServiceBizFactory;

public class User {
	private String name;
	private String pwd;
	private String address1;// 地址1
	private String address2;// 地址2
	private String zipcode;// 邮编
	private String hostPhone;// 家庭电话
	private String officePhone;// 办公室电话
	private String mobile;// 手机
	private String email;// 电子邮件地址
    public User(){};
	public User(String name, String pwd, String address1, String address2,
			String zipcode, String hostPhone, String officePhone,
			String mobile, String email) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.address1 = isNull(address1);
		this.address2 = isNull(address2);
		this.zipcode = isNull(zipcode);
		this.hostPhone = isNull(hostPhone);
		this.officePhone = isNull(officePhone);
		this.mobile = isNull(mobile);
		this.email = isNull(email);
	}
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getHostPhone() {
		return hostPhone;
	}

	public void setHostPhone(String hostPhone) {
		this.hostPhone = hostPhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String isNull(String s){
		if(s==null){
			return "";
		}else{
			return s;
		}
	}
	public boolean isLogin(String name,String pwd){
		ServiceBiz getSer = ServiceBizFactory.getServ();
		if(getSer.IsLogin(name, pwd)==null){
			System.out.println("Ui");
			return false;
		}
		System.out.println("true");
		return true;
	}
}
