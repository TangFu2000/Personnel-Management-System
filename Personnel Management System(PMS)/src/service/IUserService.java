package service;

import java.sql.SQLException;

import PMS.vo.User;

public interface IUserService {
	/**
	 * ʵ���û���¼����,���õ���IUserDAO.login������¼
	 * @param username �û���
	 * @param password ����
	 * @return ��¼�ɹ�����true,ʧ�ܷ���false
	 * @throws SQLException 
	 */
	public abstract boolean login(User user)throws Exception ;	
}
