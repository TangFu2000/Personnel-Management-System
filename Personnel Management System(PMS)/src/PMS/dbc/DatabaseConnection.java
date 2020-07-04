package PMS.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 本类负责数据库的链接操作，在进行本类对象实例化时自动进行数据库的连接处理
 * @author Administrator
 *
 */
public class DatabaseConnection {
	// 数据库驱动程序
	public static final String DBdriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// 数据库连接地址
	public static final String DBurl = "jdbc:sqlserver://localhost:1433;DatabaseName=Personnel Management System";
	// 数据库连接用户名
	public static final String DBuser = "sa";
	// 数据库连接密码
	public static final String DBpass = "666666";
	// 数据库连接
	public static Connection conn = null;
	/**
	 * 在构造方法调用时将进行数据库连接对象的取得
	 */
	public DatabaseConnection() {
		// 加载数据库驱动程序
		try {
			Class.forName(DBdriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取连接
		try {
			conn = DriverManager.getConnection(DBurl, DBuser, DBpass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 取得数据库连接对象
	 * @return
	 */
	public Connection getConnection() {
		return this.conn;
	}
	/**
	 * 进行数据库的关闭操作
	 */
	public  void close() {
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
