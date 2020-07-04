package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelExporter{
	public ExcelExporter() { }
	public void exportTable(JTable table, File file) throws IOException, RowsExceededException, WriteException {
	    try {
	        OutputStream out = new FileOutputStream(file);
	        TableModel model = table.getModel();
	        WritableWorkbook wwb = Workbook.createWorkbook(out);
	        // �����ӱ���д������
	        WritableSheet ws = wwb.createSheet("��Ա��Ϣ", 0);
	        // ��ӱ���
	        for (int i = 0; i < model.getColumnCount(); i++) {
	            jxl.write.Label labelN = new jxl.write.Label(i, 0, model.getColumnName(i));
	            try {
	                ws.addCell(labelN);
	            } catch (RowsExceededException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (WriteException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        // �����Ϣ
	        for (int i = 0; i < model.getColumnCount(); i++) {
	            for (int j = 1; j <= model.getRowCount(); j++) {
	            	if(model.getValueAt(j - 1, i)==null) {//���пգ�д��ᱨ��
	            		jxl.write.Label labelN = new jxl.write.Label(i, j, "");
	            		ws.addCell(labelN);
	            	}
	            	else {
	            		jxl.write.Label labelN = new jxl.write.Label(i, j, model.getValueAt(j - 1, i).toString());
	            		ws.addCell(labelN);
	            	}
	            }
	        }
	        wwb.write();
	        JOptionPane.showMessageDialog(null, "����������ɹ���");
	        try {
	            wwb.close();
	            out.close();
	        } catch (WriteException e) {
	            e.printStackTrace();
	        }
	    } catch (FileNotFoundException e) {
	        JOptionPane.showMessageDialog(null, "��������ǰ��رչ�����");
	    }
	}

}