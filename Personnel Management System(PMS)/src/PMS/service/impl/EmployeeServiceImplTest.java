package PMS.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import PMS.factory.EmloyeeServiceFactory;
import PMS.vo.Employee;
import Utils.FileControl;
import Utils.RandomValue;

public class EmployeeServiceImplTest {

	@Test
	public void testInsert() {
		String str = null;
		for (int i = 0; i < 1; i++) {
			str = RandomValue.getData();
			if (str == null || str.length() == 0) {
				i--;
				continue;
			}
			String[] s = str.split("，");
			Employee em = new Employee();
			em.setEmployeeID(s[0]);
			em.setName(s[1]);
			em.setCardNumber(s[2]);
			em.setNation(s[3]);
			em.setSex(s[4]);
			em.setBirthday(s[5]);
			em.setSchoolRecord(s[6]);
			em.setDepartment(s[7]);
			em.setPositionName(s[8]);
			em.setRoad(s[9]);
			em.setTellphone(s[10]);
			em.setEmail(s[11]);
			em.setEditTime(s[12]);
			em.setInfo(s[13]);
			try {
				EmloyeeServiceFactory.getIEmpServiceInstance().insert(em);
				SimpleDateFormat df1 = new SimpleDateFormat("yyMMdd");// 设置日期格式
				String numDate = df1.format(new Date());
				String str1 = em.getEmployeeID().trim();
				int id = Integer.valueOf(str1.substring(8));
				StringBuffer ID = new StringBuffer();
				id++;
				ID.append(numDate);
				ID.append("-");
				ID.append(id);
				FileControl.writeFile(ID.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Test
	public void testUpdate() {
		String str = null;
		while(str == null || str.length() == 0) {
			str = RandomValue.getData();
		}
			
		String[] s = str.split("，");
		Employee em = new Employee();
		em.setEmployeeID("012006273785");
		em.setName(s[1]);
		em.setCardNumber(s[2]);
		em.setNation(s[3]);
		em.setSex(s[4]);
		em.setBirthday(s[5]);
		em.setSchoolRecord(s[6]);
		em.setDepartment(s[7]);
		em.setPositionName(s[8]);
		em.setRoad(s[9]);
		em.setTellphone(s[10]);
		em.setEmail(s[11]);
		em.setEditTime(s[12]);
		em.setInfo(s[13]);
		try {
			EmloyeeServiceFactory.getIEmpServiceInstance().update(em);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Employee em = new Employee();
		em.setEmployeeID("052006272905");
		
		try {
			EmloyeeServiceFactory.getIEmpServiceInstance().delete(em);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindByAll() {
		Employee em = new Employee();
		em.setEmployeeID("");
		em.setName("王");
		em.setCardNumber("");
		em.setNation("");
		em.setSex("");
		em.setBirthday("");
		em.setSchoolRecord("");
		em.setDepartment("");
		em.setPositionName("");
		em.setRoad("");
		em.setTellphone("");
		em.setEmail("");
		em.setEditTime("");
		em.setInfo("");
		try {
			List<Employee> arraylist = EmloyeeServiceFactory.getIEmpServiceInstance().findByAll(em);
			for(Employee e:arraylist) {
				System.out.println(e.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
