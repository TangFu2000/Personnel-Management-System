package PMS.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ฺ�����ݿ�����Ӳ������ڽ��б������ʵ����ʱ�Զ��������ݿ�����Ӵ���
 * @author Administrator
 *
 */
public class DatabaseConnection {
	// ���ݿ���������
	public static final String DBdriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// ���ݿ����ӵ�ַ
	public static final String DBurl = "jdbc:sqlserver://localhost:1433;DatabaseName=Personnel Management System";
	// ���ݿ������û���
	public static final String DBuser = "sa";
	// ���ݿ���������
	public static final String DBpass = "666666";
	// ���ݿ�����
	public static Connection conn = null;
	/**
	 * �ڹ��췽������ʱ���������ݿ����Ӷ����ȡ��
	 */
	public DatabaseConnection() {
		// �������ݿ���������
		try {
			Class.forName(DBdriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ��ȡ����
		try {
			conn = DriverManager.getConnection(DBurl, DBuser, DBpass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * ȡ�����ݿ����Ӷ���
	 * @return
	 */
	public Connection getConnection() {
		return this.conn;
	}
	/**
	 * �������ݿ�Ĺرղ���
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
