package Utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import PMS.vo.Employee;

public class EmployeeTable extends JTable{
	// JTable���ҳ��Ϣ��ر���
    public int currentPage = 1;
    public int pageCount = 20;
    public int totalPage = 0;
    public int totalRowCount = 0;
    public int column = 0;
    public int restCount;
    public Object[][] resultData;
    // JTable����Ϣ��ر���
    private  List<Employee> arraylist=new ArrayList<Employee>();
    public String[] columnNames = { "ְ�����", "����", "���֤��", "����", "�Ա�", "��������", "ѧ��", "����", "ְ��", "סַ","�ֻ�����", "�����ʼ�","�༭ʱ��", "��ע" };
    public DefaultTableModel model = null;
    
    public String[] getColumnNames() {
    	return this.columnNames ;
    }
    public int getArraylistLength() {
    	return arraylist.size();
    }
    public int getTotalRowCount() {
		return totalRowCount;
	}
	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}
	public EmployeeTable() {
    	initTable();
    }
    public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	/**
     * ���õ�ǰҳ
     * @param currentPage
     */
    public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
    
	public  void setArraylist(List<Employee> arraylist) {
    	this.arraylist=arraylist;
    }
	public List<Employee> getArraylist(){
		return this.arraylist;
	}
	
    /**
     * ��ȡ��һҳ
     */
    public int getNextPage() {
        if (this.currentPage != this.totalPage) {
            return ++currentPage;
        }
        return -1;
    }

    /**
     * ��ȡ��һҳ
     */
    public int getPreviousPage() {
        if (this.currentPage != 1) {
            return --currentPage;
        }
        return -1;
    }

    /**
     * ��ȡ���һҳ
     */
    public int getLastPage() {
        return this.totalPage;
    }

    /**
     * ��ȡ��һҳ
     */
    public int getFirstPage() {
        return 1;
    }

    /**
     * ��ȡ��ҳ��
     */
    public int getTotolPage() {
        return this.totalPage;
    }

    /**
     * ��ȡ��ǰҳ
     */
    public int getCurrentPage() {
        return this.currentPage;
    }
	
	/**
	 * ���ԭʼ���ݼ�
	 * @param arraylist
	 * @return
	 */
	public Object[][] getData(List<Employee> arraylist){
		if(arraylist.size()>0) {
			Object[][] data=new Object[arraylist.size()][14];
			for(int i=0;i<arraylist.size();i++) {
				Employee em= arraylist.get(i);
				Object[] a={em.getEmployeeID(),em.getName(),em.getCardNumber(),em.getNation(),em.getSex(),em.getBirthday(),em.getSchoolRecord(),em.getDepartment(),em.getPositionName(),em.getRoad(),em.getTellphone(),em.getEmail(),em.getEditTime(),em.getInfo()};
				data[i]=a;
			}
			return data;
		}
		return null;
}
				
	public void initResultData(Object[][] data) {
		if(data!=null) {
			resultData=data;//�ܵĽ����
			column=data[0].length;//�������
			totalRowCount=data.length;//��ĳ���
			totalPage=totalRowCount%pageCount==0?totalRowCount/pageCount:totalRowCount/pageCount+1;//���������ҳ��
			restCount=totalRowCount%pageCount==0?20:totalRowCount%pageCount;//���һҳ��������
		}
	}
	/**
	 * ��ȡ��ҳ����
	 * @return
	 */
	public Object[][] getPageData(){
		Object[][] currentPageData=new Object[pageCount][column];//����ÿҳ���ݼ�
		if(this.getCurrentPage()<this.totalPage) {//�����ǰҳ��С����ҳ������ôÿҳ��ĿӦ���ǹ涨����Page Count
			for(int i=pageCount*(this.getCurrentPage()-1);i<pageCount*(this.getCurrentPage()-1)+pageCount;i++) {
				for(int j=0;j<column;j++) {//�ѽ�����ж�Ӧ��ÿһ������ȫ����ֵ����ǰҳ��ÿһ��ÿһ��
					currentPageData[i%pageCount][j]=resultData[i][j];
				}
			}
		}
		else {
			//�ڶ�̬�ı����ݽ������ʱ�������ǰҳû�������ˣ���ص�ǰһҳ��һ��������һҳ���ԣ�
			if(pageCount*(this.getCurrentPage()-1)>=totalRowCount) 
				this.currentPage=this.getTotolPage();
			for(int i=pageCount*(this.getCurrentPage()-1);i<pageCount*(this.getCurrentPage()-1)+restCount;i++) {
				for(int j=0;j<column;j++) {
					currentPageData[i%pageCount][j]=resultData[i][j];
				}
			}
		}
		return currentPageData;
	}
    
	/**
	 * ��ʼ���������
	 */
    public void initTable() {
    	Object[][] data=getData(arraylist);
    	if(data!=null) {
    		initResultData(data);
    		model=new DefaultTableModel(getPageData(),columnNames);
    	}else {
    		//����������û�����ݣ���ô���ÿ����������ݼ��е�ÿһ��
    		Object[][] nothing= {{},{},{},{},{},{},{},{},{},{},{},{},{},{}};
    		model=new DefaultTableModel(nothing,columnNames);
    		totalRowCount=0;
    	}
    	this.setModel(model);
    	this.setRowHeight(20);
    	DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(Object.class, r);
    }   
}
