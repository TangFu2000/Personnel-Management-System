package PMS.dao;

import java.util.List;

import PMS.vo.Employee;

/**
 * 定义Employee数据层操作标准
 * @author Administrator
 *
 */
public interface IEmployeeDAO {
	/**
	 * 数据的增加操作，执行的是INSERT语句 
	 * @param em 包含了要增加的数据信息
	 * @return 如果数据增加成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerExceptino,如果SQL语句错误抛出SQLException
	 */
	public abstract boolean doCreate(Employee em) throws Exception;
	/**
	 * 数据的修改操作，执行的是UPDATE语句，本次的修改会根据ID将所有数据进行变更
	 * @param em 包含了要修改数据的信息
	 * @return 如果数据修改成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerExceptino,如果SQL语句错误抛出SQLException
	 */
	public boolean doUpdate(Employee em) throws Exception;
	/**
	 * 数据的删除操作，需要在执行前根据要删除的编号，拼凑出SQL语句
	 * @param em 包含了要删除数据的信息
	 * @return 如果数据删除成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerExceptino,如果SQL语句错误抛出SQLException
	 */
	public boolean doRemove(Employee em) throws Exception;
	/**
	 * 根据em信息查询出员工的完整信息，每行数据通过Employee包装，而后通过List保存多个返回结果
	 * @param em 包含了要查询的数据信息
	 * @return 将查询到的内容以List的形式返回
	 * @throws Exception 如果数据库没有连接，则抛出NullPointerExceptino,如果SQL语句错误抛出SQLException
	 */
	public List<Employee> findByAll(Employee em) throws Exception;
	/**
	 * 查询数据表中的全部数据，每行数据通过Employee包装，而后通过List保存多个返回结果
	 * @return 全部查询数据行，如果没有数据返回则集合长度为0(size()==0)
	 * @throws Exception 如果数据库没有连接，则出现NullPointerExceptino,如果SQL语句错误抛出SQLException
	 */
	public List<Employee> findAll() throws Exception;
}
