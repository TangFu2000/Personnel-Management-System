package PMS.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import PMS.vo.User;

public class UserDAOImpl implements PMS.dao.IUserDAO{
	private Connection conn;	//���ݿ����Ӷ���
	private PreparedStatement pstmt ;	//���ݿ�Ĳ�������
	/**
	 * ʵ�������ݲ��������ͬʱ����һ�����ݿ����Ӷ���
	 * @param conn Connection���Ӷ������Ϊnull����ʾ���ݿ�û�д�
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
