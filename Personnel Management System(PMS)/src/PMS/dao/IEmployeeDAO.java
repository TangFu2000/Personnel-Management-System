package PMS.dao;

import java.util.List;

import PMS.vo.Employee;

/**
 * ����Employee���ݲ������׼
 * @author Administrator
 *
 */
public interface IEmployeeDAO {
	/**
	 * ���ݵ����Ӳ�����ִ�е���INSERT��� 
	 * @param em ������Ҫ���ӵ�������Ϣ
	 * @return ����������ӳɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerExceptino,���SQL�������׳�SQLException
	 */
	public abstract boolean doCreate(Employee em) throws Exception;
	/**
	 * ���ݵ��޸Ĳ�����ִ�е���UPDATE��䣬���ε��޸Ļ����ID���������ݽ��б��
	 * @param em ������Ҫ�޸����ݵ���Ϣ
	 * @return ��������޸ĳɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerExceptino,���SQL�������׳�SQLException
	 */
	public boolean doUpdate(Employee em) throws Exception;
	/**
	 * ���ݵ�ɾ����������Ҫ��ִ��ǰ����Ҫɾ���ı�ţ�ƴ�ճ�SQL���
	 * @param em ������Ҫɾ�����ݵ���Ϣ
	 * @return �������ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerExceptino,���SQL�������׳�SQLException
	 */
	public boolean doRemove(Employee em) throws Exception;
	/**
	 * ����em��Ϣ��ѯ��Ա����������Ϣ��ÿ������ͨ��Employee��װ������ͨ��List���������ؽ��
	 * @param em ������Ҫ��ѯ��������Ϣ
	 * @return ����ѯ����������List����ʽ����
	 * @throws Exception ������ݿ�û�����ӣ����׳�NullPointerExceptino,���SQL�������׳�SQLException
	 */
	public List<Employee> findByAll(Employee em) throws Exception;
	/**
	 * ��ѯ���ݱ��е�ȫ�����ݣ�ÿ������ͨ��Employee��װ������ͨ��List���������ؽ��
	 * @return ȫ����ѯ�����У����û�����ݷ����򼯺ϳ���Ϊ0(size()==0)
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerExceptino,���SQL�������׳�SQLException
	 */
	public List<Employee> findAll() throws Exception;
}
