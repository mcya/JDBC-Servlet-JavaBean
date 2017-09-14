package test;

import java.util.ArrayList;
import java.util.List;

import sun.text.CompactShortArray.Iterator;

import com.changzhou.ecport.biz.ServiceBiz;
import com.changzhou.ecport.biz.ServiceBizFactory;
import com.changzhou.ecport.dao.*;
import com.changzhou.ecport.dao.impl.*;
import com.changzhou.ecport.entity.Product;
import com.changzhou.ecport.entity.User;

public class test {
	public static void main(String[] args) {
		
//		ServiceBiz getSer = ServiceBizFactory.getServ();
		
//		List ord =(List)getSer.findByName("世界");
//		System.out.println(ord);
//		for (Iterator it =  ord.iterator(); it.hasNext();) {
//				Product product =  it.next();
//			System.out.println(it.next());
//		}
		ProductDaoImpl pro = (ProductDaoImpl) ProductDaoFactory.getProductDao();
		Product pros=pro.findByPro("世界");
		System.out.println(pros.getAmount());
		System.out.println(pros.getAuthor());
		System.out.println(pros.getName());
		
	}
}
