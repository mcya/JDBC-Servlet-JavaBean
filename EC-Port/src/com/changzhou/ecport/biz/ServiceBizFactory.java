package com.changzhou.ecport.biz;

import com.changzhou.ecport.biz.impl.ServiceBizImpl;

public class ServiceBizFactory {
	public static ServiceBiz getServ(){
		return new ServiceBizImpl();
	}
}
