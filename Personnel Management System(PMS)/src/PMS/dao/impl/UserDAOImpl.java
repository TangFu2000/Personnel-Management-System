package PMS.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import PMS.vo.User;

public class UserDAOImpl implements PMS.dao.IUserDAO{
	private Connection conn;	//数据库连接对象
	private PreparedStatement pstmt ;	//数据库的操作对象
	/**
	 * 实例化数据层子类对象，同时传入一个数据库连接对象
	 * @param conn Connection连接对象，如果为null，表示数据库没有打开
	 */
	public UserDAOImpl(Connection conn) {
		this.conn=conn;
	}
	@Override
	public boolean login(User user) throws Exception {
		boolean flag=false;
		List<User> all=new ArrayList<User>();
		String sql="select * from UserTable";
		this.pstmt=this.conn.prepareStatement(sql.toString());
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()){
			User u=new User();
			u.setUsername(rs.getString(1));
			u.setPassword(rs.getString(2));
			all.add(u);
		}
		for(User u:all) {
			if(user.getUsername().equals(u.getUsername())&&user.getPassword().equals(u.getPassword())) {
				flag=true;
				break;
			}
		}	
		return flag;
	}
}
