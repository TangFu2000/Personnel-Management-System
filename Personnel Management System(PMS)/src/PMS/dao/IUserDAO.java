package PMS.dao;

import java.sql.SQLException;

import PMS.vo.User;

/**
 * ����User���ݲ������׼
 * @author ASUS
 *
 */
public interface IUserDAO {
	
	/**
	 * �����û���¼����
	 * @param username �û���
	 * @param password ����
	 * @return ��¼�ɹ�����true,ʧ�ܷ���false
	 * @throws SQLException 
	 */
	public abstract boolean login(User user)throws Exception ;	
}
