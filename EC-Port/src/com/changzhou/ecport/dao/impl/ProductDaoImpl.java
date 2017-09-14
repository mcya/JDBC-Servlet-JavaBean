package com.changzhou.ecport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.changzhou.ecport.dao.ProductDao;
import com.changzhou.ecport.entity.Catagory;
import com.changzhou.ecport.entity.Order;
import com.changzhou.ecport.entity.Product;
import com.changzhou.ecport.util.JdbcUtil;

public class ProductDaoImpl implements ProductDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	List product = new ArrayList();

	private String sql = "";

	public List ShowProductInfo() {//显示所有商品信息
		con = JdbcUtil.getConnection();
		sql = "select a.productid,a.name,a.description,a.baseprice,"
				+ "a.author,a.publish,a.pages,a.image,c.description from "
				+ "product a,category c where a.categoryid = c.categoryid ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String key = String.valueOf(rs.getInt(1));
				Product prod = new Product(rs.getInt(1), rs.getString(2), rs
						.getFloat(4), rs.getString(5), rs.getString(6), rs
						.getInt(7), rs.getString(3), rs.getString(8), rs
						.getString(9));
				product.add(prod);
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
		return product;
	}

	public Product ShowProductInfoById(String id) {//通过ID得到商品详细信息
		con = JdbcUtil.getConnection();
		sql = "select a.productid,a.name,a.description,a.baseprice,"
				+ "a.author,a.publish,a.pages,a.image,c.description from "
				+ "product a,category c where a.categoryid = c.categoryid and productid=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product prod = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String key = String.valueOf(rs.getInt(1));
				prod = new Product(rs.getInt(1), rs.getString(2), rs
						.getFloat(4), rs.getString(5), rs.getString(6), rs
						.getInt(7), rs.getString(3), rs.getString(8), rs
						.getString(9));
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
		return prod;
	}

	public void AddOrders(int id, String name, float cost, String uid,
			int statusid, int paywayid) {
		con = JdbcUtil.getConnection();
		sql = "insert into orders values(?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product prod = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setFloat(3, cost);
			ps.setString(4, uid);
			ps.setInt(5, statusid);
			ps.setInt(6, paywayid);
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
	}

	public int getMaxid() {
		con = JdbcUtil.getConnection();
		sql = "select max(orderid) from orders";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 1;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
		return id;
	}

	public void addOrderLine(int orderid, int productid, int amount) {
		con = JdbcUtil.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Product prod = null;
		sql = "select max(lineid) from orderline";
		int id = 1;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1) + 1;
			}
			sql = "insert into orderline values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, orderid);
			ps.setInt(3, productid);
			ps.setInt(4, amount);
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
	}

	public List showOrder(String name) {
		List order = new ArrayList();
		con = JdbcUtil.getConnection();
		sql = "select a.paystyle,s.description,b.cost,"
				+ "b.name from orders b,payway a,users u,"
				+ "orderstatus s where a.paywayid=b.paywayid "
				+ "and b.userid=u.userid and b.statusid = s.statusid "
				+ "and u.userid =?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			int id = 1;
			while (rs.next()) {
				Order ord = new Order(rs.getString(4), rs.getString(3), rs
						.getString(2), rs.getString(1));
				order.add(ord);
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
		return order;
	}

	public void removeOrder(String name) {
		con = JdbcUtil.getConnection();
		sql = "select orderid from orders where name =?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			int oid = 0;
			if (rs.next()) {
				oid = rs.getInt(1);
			}
			sql = "delete from orderline where orderid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, oid);
			ps.executeUpdate();
			con.commit();
			con = JdbcUtil.getConnection();
			sql = "delete from orders where orderid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, oid);
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
	}

	public List getProductOrder(String name) {

		con = JdbcUtil.getConnection();
		sql = "select p.name,p.basePrice,l.amount,p.productid from orders o,"
				+ "orderline l,product p where o.name=? and "
				+ "l.productid=p.productid and o.orderid=l.orderid;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product pro = new Product(rs.getInt(4),rs.getString(1), rs.getInt(2), rs
						.getInt(3));
				product.add(pro);
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
		return product;
	}

	public String getPayway(String name) {
		sql = "select p.paystyle from orders o,payway p where "
				+ "p.paywayid = o.paywayid and o.name=?";
		String payway = "";
		con = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				payway = rs.getString(1);
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
		return payway;
	}

	public List findByProName(String name) {
		sql = "select a.productid,a.name,a.description,a.baseprice,"
				+ "a.author,a.publish,a.pages,a.image,c.description from "
				+ "product a,category c where  " 
				+ " a.name like ?";
		Product pro=null;
		con = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
//			name ="%"+name+"%";
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			if (rs.next()) {
				pro = new Product(rs.getInt(1), rs.getString(2), rs
						.getFloat(4), rs.getString(5), rs.getString(6), rs
						.getInt(7), rs.getString(3), rs.getString(8), rs
						.getString(9));
				product.add(pro);
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
		return product;
		
	}
	public Product findByPro(String name) {
		sql = "select a.productid,a.name,a.description,a.baseprice,"
			+ "a.author,a.publish,a.pages,a.image,c.description from "
			+ "product a,category c where  " 
			+ " a.name like ?";
	Product pro=null;
	con = JdbcUtil.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
//		name ="%"+name+"%";
		con.setAutoCommit(false);
		ps = con.prepareStatement(sql);
		ps.setString(1, "%"+name+"%");
		rs = ps.executeQuery();
		if (rs.next()) {
			pro = new Product(rs.getInt(1), rs.getString(2), rs
					.getFloat(4), rs.getString(5), rs.getString(6), rs
					.getInt(7), rs.getString(3), rs.getString(8), rs
					.getString(9));
			product.add(pro);
		}
		con.commit();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.release(rs, ps, con);
	}
	return pro;
	
}
}
