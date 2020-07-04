package PMS.dao;

import java.sql.SQLException;

import PMS.vo.User;

/**
 * 定义User数据层操作标准
 * @author ASUS
 *
 */
public interface IUserDAO {
	
	/**
	 * 这是用户登录功能
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录成功返回true,失败返回false
	 * @throws SQLException 
	 */
	public abstract boolean login(User user)throws Exception ;	
}
