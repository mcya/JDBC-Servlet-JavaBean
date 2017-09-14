package com.changzhou.ecport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.changzhou.ecport.dao.UserDao;
import com.changzhou.ecport.entity.User;
import com.changzhou.ecport.util.JdbcUtil;

public class UserDaoImpl implements UserDao {
	private String sql;

	// 根据用户名,密码查找资料
	public User UserInfo(String name, String pwd) {
		Connection con = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		sql = "select * from users where userid =? and password =?";
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()){
				User user = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getString(8),rs.getString(10),rs.getString(9),rs.getString(7));
			    return user;
			}
			 con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
		return null;
	}

	public User FindbyName(String name) {
		Connection con = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		sql = "select * from users where userid =?";
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()){
				User user = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getString(8),rs.getString(10),rs.getString(9),rs.getString(7));
			    return user;
			}
			 con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
		return null;
	}
	
	// 判断用户是否存在
	public boolean IsEmpty(String name) {
		Connection con = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		sql = "select * from users where userid =?";
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			 con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
		return false;
	}

	// 用户注册信息的录入
	public void Insert(User user) {
		Connection con = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (!IsEmpty(user.getName())) {
			String name = user.getName();
			String pwd = user.getPwd();
			String address1 = user.getAddress1();
			String address2 = user.getAddress2();
			String zipcode = user.getZipcode();
			String hostPhone = user.getHostPhone();
			String officePhone = user.getOfficePhone();
			String mobile = user.getMobile();
			String email = user.getEmail();
			sql = "select max(contactid) from users";
			try {
				con.setAutoCommit(false);
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				String id = null;
				if (rs.next()) {
					id = String.valueOf(rs.getInt(1) + 1);
				}
				sql = "insert users values(?,?,?,?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3, pwd);
				ps.setString(4, address1);
				ps.setString(5, address2);
				ps.setString(6, zipcode);
				ps.setString(7, hostPhone);
				ps.setString(8, officePhone);
				ps.setString(9, mobile);
				ps.setString(10, email);

				ps.executeUpdate();

				 con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				if (con != null) {
					try {
						con.rollback();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} finally {
				JdbcUtil.release(rs, ps, con);
			}

		} else {
			System.out.println("用户已经存在，请重新输入");
		}
	}

	public void Modify(User user) {//用户信息的更改
		Connection con = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String name = user.getName();
		String pwd = user.getPwd();
		String address1 = user.getAddress1();
		String address2 = user.getAddress2();
		String zipcode = user.getZipcode();
		String hostPhone = user.getHostPhone();
		String officePhone = user.getOfficePhone();
		String mobile = user.getMobile();
		String email = user.getEmail();
		try {
			con.setAutoCommit(false);
		sql = "update users set userid=? ,password =?,"
			  +" address1 =?,address2 =?,zip =?,email=?,homephone =?,"
		      +"cellphone =? ,officephone =? where userid = ?";
		ps =con.prepareStatement(sql);
//		ps.setString(1, id);
		ps.setString(1, name);
		ps.setString(2, pwd);
		ps.setString(3, address1);
		ps.setString(4, address2);
		ps.setString(5, zipcode);
		ps.setString(6, hostPhone);
		ps.setString(7, officePhone);
		ps.setString(8, mobile);
		ps.setString(9, email);
		ps.setString(10, name);
		ps.executeUpdate();
        con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if(con != null){
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally{
			JdbcUtil.release(rs, ps, con);
		}
	}
	public void Delete(User user) {
		Connection con = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String name = user.getName();
		try {
			con.setAutoCommit(false);
			sql = "delete from users where userid =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeUpdate();
			System.out.println("删除成功!");
			 con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			JdbcUtil.release(rs, ps, con);
		}
	}
}
