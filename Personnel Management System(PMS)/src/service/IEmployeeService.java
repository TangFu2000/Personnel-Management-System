package service;

import java.util.List;

import PMS.vo.Employee;
 
public interface IEmployeeService {
	/**
	 * ʵ��Ա�����ݵ����Ӳ��������õ���IEmployeeDAO.doCreate()��������Ա����Ϣ
	 * @param em ������Ҫ�������ݵ�Employee�����
	 * @return �������ӳɹ�����true�����򷵻�false
	 * @throws Exception IEmployeeDAO�ӿ��е��׳��쳣
	 */
	public boolean insert(Employee em) throws Exception;
	/**
	 * ��ʾ���ݵ��޸Ĳ��������õ���IEmployeeDAO.doUpdate()�����޸�Ա����Ϣ
	 * @param em ������Ҫ�޸ĵ�������Ϣ
	 * @return 
	 * @throws Exception IEmployeeDAO�ӿ��е��׳��쳣
	 */
	public boolean update(Employee em)throws Exception;
	/**
	 * ʵ�����ݵ�ɾ�����������õ���IEmployeeDAO.doRemove()����ɾ��Ա����Ϣ
	 * @param em ������Ҫɾ����������Ϣ
	 * @return ɾ���ɹ�����true�� ���򷵻�false
	 * @throws Exception IEmployeeDAO�ӿ��е��׳��쳣
	 */
	public boolean delete(Employee em)throws Exception;	
	/**
	 * ��ѯ����������Ա����������Ϣ�����õ���IEmployeeDAO.findByAll()������ѯԱ����Ϣ
	 * @param em ������Ҫ��ѯ��������Ϣ
	 * @return ����ѯ����������List����ʽ����
	 * @throws Exception ������ݿ�û�����ӣ����׳�NullPointerExceptino,���SQL�������׳�SQLException
	 */
	public List<Employee> findByAll(Employee em) throws Exception;
	/**
	 * ��ѯ���ݱ��е�ȫ�����ݣ����õ���IEmployeeDAO.findAll()������ѯԱ����Ϣ
	 * @return ȫ����ѯ�����У����û�����ݷ����򼯺ϳ���Ϊ0(size()==0)
	 * @throws Exception ������ݿ�û�����ӣ����׳�NullPointerExceptino,���SQL�������׳�SQLException
	 */
	public List<Employee> findAll() throws Exception;
	
}
