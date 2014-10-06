package com.c503.lbs.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 
 * 连接数据库
 * @author huchaofeng
 *
 */
public class Dao {
	private Connection conn = null;
	PreparedStatement statement = null;
	
	private static Dao dao = null;
	private Dao() {
		String url = "jdbc:mysql://localhost:3306/808?characterEncoding=UTF-8"; // 数据库地址，端口，数据库名称，字符集
		String username = "root"; // 数据库用户名
		String password = "hcf"; // 数据库密码
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载驱动，必须导入包mysql-connector-java-5.1.6-bin.jar
			conn = DriverManager.getConnection(url, username, password);
		}
		// 捕获加载驱动程序异常
		catch (ClassNotFoundException cnfex) {
			System.err.println("装载 JDBC/ODBC 驱动程序失败。");
			cnfex.printStackTrace();
		}
		// 捕获连接数据库异常
		catch (SQLException sqlex) {
			System.err.println("无法连接数据库");
			sqlex.printStackTrace();
		}
	}
	public static Dao getInstance() {
	   if (dao == null) {
		   dao = new Dao();
	   }
	   return dao;
	}

	// 关闭数据库
	public void deconnSQL() {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println("关闭数据库异常：");
			e.printStackTrace();
		}
	}

	/**
	 * 执行查询sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet selectSQL(String sql) {
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 执行创建表sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public boolean createSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("create表出错：");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("create表成功：");
			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * 执行插入sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public boolean insertSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("插入数据库时出错：");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("插入时出错：");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 执行删除sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public boolean deleteSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("删除数据库时出错：");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("删除时出错：");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 执行更新sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public boolean updateSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("更新数据库时出错：");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("更新时出错：");
			e.printStackTrace();
		}
		return false;
	}

}