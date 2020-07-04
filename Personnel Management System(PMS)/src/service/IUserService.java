package service;

import java.sql.SQLException;

import PMS.vo.User;

public interface IUserService {
	/**
	 * 实现用户登录功能,调用的是IUserDAO.login方法登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录成功返回true,失败返回false
	 * @throws SQLException 
	 */
	public abstract boolean login(User user)throws Exception ;	
}
