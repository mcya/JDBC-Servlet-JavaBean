package com.changzhou.ecport.dao;

import com.changzhou.ecport.dao.impl.ProductDaoImpl;

public class ProductDaoFactory {
	public static ProductDao getProductDao(){
		return new ProductDaoImpl();
	}
}
