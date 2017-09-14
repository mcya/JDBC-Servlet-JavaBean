package com.changzhou.ecport.util;

import java.sql.*;

public class JdbcUtil {

	private static String[] props = { "com.mysql.jdbc.Driver",
			"jdbc:mysql://127.0.0.1:3306/changzhou?useUnicode=true&characterEncoding=gbk", "root", "86525517" };

	//1、加载驱动
	static {
		try {
			Class.forName(props[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//2、获取连接
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(props[1], props[2], props[3]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	//3、释放资源
	public static void release(Object o) {
		try {
			if (o instanceof ResultSet) {
				((ResultSet) o).close();
			} else if (o instanceof Statement) {
				((PreparedStatement) o).close();
			} else if (o instanceof Connection) {
				((Connection) o).close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void release(ResultSet rs, PreparedStatement ps,
			Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from product");
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			System.out.println(new String(rs.getString(6).getBytes(),"utf-8"));
		}
	}

}
