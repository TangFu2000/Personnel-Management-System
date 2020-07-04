package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;

import PMS.factory.EmloyeeServiceFactory;
import PMS.vo.Employee;
import Utils.EmployeeTable;
import Utils.ExcelExporter;
import Utils.FileControl;
import Utils.RandomValue;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class mainFrame extends JFrame {
	int flagEmpty;
	int flagSeek;
	int flagSortID,flagSortIDCard,flagSortName,flagSortBrithday,flagSortDepartment,flagSortEditTime;

	EmployeeTable emTable;
	private List<Employee> arraylist = new ArrayList<Employee>();//�洢�������
	private List<Employee> array = new ArrayList<Employee>();//�洢�����õı������
	private JPanel contentPane;

	JMenu mnNewMenu;
	JMenuBar menuBar;
	JToolBar toolBar;
	JButton btnexcel;
	private JSplitPane splitPane;
	private JScrollPane treePane;
	private JSplitPane mainPane;
	private JScrollPane upPane;
	private JScrollPane downPane;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldIDCard;
	private JTextField textFieldNation;
	private JTextField textFieldBirthDay;
	private JTextField textFieldTellphone;
	private JTextField textFieldEmail;
	private JTextField textFieldEditTime;
	private JLabel labelInfo;
	private JTextField textField_11;
	private JTextField textField_12;
	private JLabel labelTellphone;
	private JTextArea textAreaInfo;
	private boolean isadd = false;
	JLabel lblxx, lblxx_1, label_13, label_14, label_15, LabelID, labelName, labelIDCard, labelNation, labelSex,
			labelBirthDay, labelPosition, labelSchoolRecord, labelDepartment, labelEmail, labelEditTime;
	JComboBox comboBoxSchoolReCord, comboBoxPosition, comboBoxDepartment;
	JButton button_1, button_2, button_3;
	JRadioButton ButtonM, ButtonF;
	ButtonGroup group;
	private JTextField textFieldAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public mainFrame() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		double width = Toolkit.getDefaultToolkit().getScreenSize().width; // �õ���ǰ��Ļ�ֱ��ʵĸ�
		double height = Toolkit.getDefaultToolkit().getScreenSize().height;// �õ���ǰ��Ļ�ֱ��ʵĿ�
		this.setSize((int) width, (int) height);// ���ô�С
		this.setResizable(false);// ������󻯰�ť
		// setBounds(100, 100, 1600, 800);
		setLocationRelativeTo(null);// ���ھ���

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1914, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("\u6587\u4EF6");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.this.dispose();	
			}
		});
		mnNewMenu_1.add(menuItem);

		mnNewMenu = new JMenu("\u5E2E\u52A9");
		menuBar.add(mnNewMenu);
		
		JMenuItem aboutMenuItem = new JMenuItem("\u5173\u4E8E");
		aboutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "������:����xxx\nʱ��: 2020/07/01\n�汾V1.0");
			}
		});
		mnNewMenu.add(aboutMenuItem);

		toolBar = new JToolBar();
		toolBar.setBounds(0, 28, 1914, 20);
		contentPane.add(toolBar);

		btnexcel = new JButton("\u5BFC\u51FA\u4E3AExcel\u8868");
		btnexcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformed();
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		toolBar.add(btnexcel);

		splitPane = new JSplitPane();
		splitPane.setBounds(0, 50, 1914, 995);
		splitPane.setDividerLocation(0.6);
		splitPane.setDividerSize(3);// ���÷ָ��ߵ���ʽ
		contentPane.add(splitPane);

		JTree tree;
		DefaultMutableTreeNode root, t1, t2, t3, t4, t5;

		// �����ĸ�����㸳ֵ
		root = new DefaultMutableTreeNode(" ���¹���ϵͳ");

		t1 = new DefaultMutableTreeNode("������Ϣ����");
		t2 = new DefaultMutableTreeNode("Ա����Ϣ����");
		t3 = new DefaultMutableTreeNode("Ա�����ڹ���");
		t4 = new DefaultMutableTreeNode("Ա�����ʹ���");
		t5 = new DefaultMutableTreeNode("��Ա���˹���");

		root.add(t1);
		root.add(t2);
		root.add(t3);
		root.add(t4);
		root.add(t5);

		splitPane.setDividerLocation(0.1);

		tree = new JTree(root);
		tree.setBounds(0, 61, 159, 453);
		
		arraylist=EmloyeeServiceFactory.getIEmpServiceInstance().findAll();
		emTable = new EmployeeTable();
		emTable.setArraylist(arraylist);
		emTable.initTable();
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (selectionNode.isLeaf()) { // Ҷ�ӽڵ�ļ���
					System.out.println(selectionNode.toString());
					if (selectionNode.toString().trim() == "������Ϣ����") { // ������Ϣ����
						view1();
					}
					if (selectionNode.toString().trim() == "Ա����Ϣ����") { // Ա����Ϣ����
						try {
							arraylist=EmloyeeServiceFactory.getIEmpServiceInstance().findAll();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						emTable = new EmployeeTable();
						emTable.setArraylist(arraylist);
						emTable.initTable();
						try {
							flagSortID=flagSortIDCard=flagSortName=flagSortBrithday=flagSortDepartment=flagSortIDCard=0;
							emTable.setArraylist(arraylist);
							emTable.initTable();
							view2();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					if(selectionNode.toString().trim() == "Ա�����ڹ���") {//Ա�����ڹ���
						view3();
					}
					if(selectionNode.toString().trim() == "Ա�����ʹ���") {//Ա�����ʹ���
						view4();
					}
					if(selectionNode.toString().trim() == "��Ա���˹���") {//��Ա���˹���
						view5();
					}
				}
			}
		});

		treePane = new JScrollPane(tree);

		splitPane.setLeftComponent(treePane);

		/*mainPane = new JSplitPane(splitPane.VERTICAL_SPLIT, (Component) null, (Component) null);
		mainPane.setDividerLocation(500);
		mainPane.setDividerSize(3);// ���÷ָ��ߵ���ʽ
		splitPane.setRightComponent(mainPane);*/
		
		mainPane=new JSplitPane();

		JPanel p=new JPanel();
		p.setBounds(0, 50, 1500, 995);
		ImageIcon image = new ImageIcon("src\\source\\����.jpg");
		image.setImage(image.getImage().getScaledInstance(1750,950,Image.SCALE_DEFAULT));
		JLabel imagelabel = new JLabel(image);
		p.add(imagelabel);
		splitPane.setRightComponent(p);
		
		//EmployeeTable emTable = new EmployeeTable();emTable

		upPane = new JScrollPane();
		mainPane.setLeftComponent(upPane);

		downPane = new JScrollPane();
		mainPane.setRightComponent(downPane);

		JPanel Buttonpanel = new JPanel();
		downPane.setViewportView(Buttonpanel);
		Buttonpanel.setLayout(null);

		

	}

	public void view1() {
		JTable table;
		Object[][] Datas = { { "01", "����1", "0735-123456", "����XXX", "��ע" } };
		String[] headers = { "���", "����", "��ϵ��ʽ", "������", "��ע" };
		// Object[][] Datas = {{"row1-col1", "row1-col2"},{"row2-col1", "row2-col2"}};
		// String[] headers= {"col1", "col2"};
		
		table = new JTable(Datas, headers);

		upPane = new JScrollPane(table);
		mainPane.setLeftComponent(upPane);

		downPane = new JScrollPane();
		mainPane.setRightComponent(downPane);

	}

	public void view2() throws SQLException {
		mainPane = new JSplitPane(splitPane.VERTICAL_SPLIT, (Component) null, (Component) null);
		mainPane.setDividerLocation(500);
		mainPane.setDividerSize(3);// ���÷ָ��ߵ���ʽ
		splitPane.setRightComponent(mainPane);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��

		JPanel Buttonpanel;

		Buttonpanel = new JPanel();
		LabelID = new JLabel("\u804C\u5DE5\u7F16\u53F7\uFF1A");
		LabelID.setBounds(63, 72, 82, 18);
		Buttonpanel.add(LabelID);

		textFieldID = new JTextField();
		textFieldID.setBounds(155, 67, 105, 24);
		Buttonpanel.add(textFieldID);
		textFieldID.setColumns(10);
		textFieldID.setEditable(false); // ����Ϊ���ɱ༭״̬

		labelName = new JLabel("\u59D3\u540D\uFF1A");
		labelName.setBounds(334, 72, 86, 18);
		Buttonpanel.add(labelName);

		textFieldName = new JTextField();
		textFieldName.setBounds(454, 70, 105, 24);
		Buttonpanel.add(textFieldName);
		textFieldName.setColumns(10);

		labelIDCard = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		labelIDCard.setBounds(618, 75, 90, 18);
		Buttonpanel.add(labelIDCard);

		textFieldIDCard = new JTextField();
		textFieldIDCard.setBounds(731, 73, 373, 24);
		Buttonpanel.add(textFieldIDCard);
		textFieldIDCard.setColumns(10);

		labelNation = new JLabel("\u6C11\u65CF\uFF1A");
		labelNation.setBounds(63, 127, 72, 18);
		Buttonpanel.add(labelNation);

		textFieldNation = new JTextField();
		textFieldNation.setBounds(155, 123, 106, 24);
		Buttonpanel.add(textFieldNation);
		textFieldNation.setColumns(10);

		labelSex = new JLabel("\u6027\u522B:");
		labelSex.setBounds(334, 127, 44, 18);
		Buttonpanel.add(labelSex);

		group = new ButtonGroup();

		ButtonM = new JRadioButton("\u7537");
		ButtonM.setSelected(true);
		ButtonM.setBounds(385, 127, 44, 23);
		Buttonpanel.add(ButtonM);
		group.add(ButtonM);

		ButtonF = new JRadioButton("\u5973");
		ButtonF.setBounds(429, 127, 44, 23);
		Buttonpanel.add(ButtonF);
		group.add(ButtonF);

		labelBirthDay = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		labelBirthDay.setBounds(520, 127, 105, 18);
		Buttonpanel.add(labelBirthDay);

		textFieldBirthDay = new JTextField();
		textFieldBirthDay.setBounds(606, 124, 176, 24);
		Buttonpanel.add(textFieldBirthDay);
		textFieldBirthDay.setColumns(10);

		labelSchoolRecord = new JLabel("\u5B66\u5386\uFF1A");
		labelSchoolRecord.setBounds(854, 127, 72, 18);
		Buttonpanel.add(labelSchoolRecord);

		labelDepartment = new JLabel("\u90E8\u95E8\uFF1A");
		labelDepartment.setBounds(64, 178, 72, 18);
		Buttonpanel.add(labelDepartment);

		labelPosition = new JLabel("\u804C\u79F0\uFF1A");
		labelPosition.setBounds(323, 182, 72, 18);
		Buttonpanel.add(labelPosition);

		JLabel labelAddress = new JLabel("\u4F4F\u5740\uFF1A");
		labelAddress.setBounds(532, 182, 72, 18);
		Buttonpanel.add(labelAddress);

		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(594, 179, 262, 24);
		Buttonpanel.add(textFieldAddress);
		textFieldAddress.setColumns(10);

		labelTellphone = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		labelTellphone.setBounds(888, 182, 99, 18);
		Buttonpanel.add(labelTellphone);

		textFieldTellphone = new JTextField();
		textFieldTellphone.setBounds(977, 179, 143, 24);
		Buttonpanel.add(textFieldTellphone);
		textFieldTellphone.setColumns(10);

		JLabel labelEmail = new JLabel("\u7535\u5B50\u90AE\u4EF6\uFF1A");
		labelEmail.setBounds(63, 224, 89, 18);
		Buttonpanel.add(labelEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(155, 221, 272, 24);
		Buttonpanel.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel labelEditTime = new JLabel("\u7F16\u8F91\u65F6\u95F4\uFF1A");
		labelEditTime.setBounds(509, 224, 95, 18);
		Buttonpanel.add(labelEditTime);

		textFieldEditTime = new JTextField();
		textFieldEditTime.setBounds(618, 221, 147, 24);
		Buttonpanel.add(textFieldEditTime);
		textFieldEditTime.setColumns(10);
		textFieldEditTime.setEditable(false);//����Ϊ���ɱ༭״̬

		labelInfo = new JLabel("\u5907\u6CE8\uFF1A");
		labelInfo.setBounds(60, 279, 72, 18);
		Buttonpanel.add(labelInfo);

		textAreaInfo = new JTextArea();
		textAreaInfo.setLineWrap(true); // �����Զ����й���
		textAreaInfo.setWrapStyleWord(true); // ������в����ֹ���

		comboBoxSchoolReCord = new JComboBox();
		comboBoxSchoolReCord.setModel(new DefaultComboBoxModel(new String[] { "\u65E0", "\u5C0F\u5B66",
				"\u521D\u7EA7\u4E2D\u5B66", "\u9AD8\u7EA7\u4E2D\u5B66", "\u4E13\u79D1", "\u672C\u79D1",
				"\u7855\u58EB\u7814\u7A76\u751F", "\u535A\u58EB\u7814\u7A76\u751F" }));
		comboBoxSchoolReCord.setBounds(937, 124, 105, 24);
		Buttonpanel.add(comboBoxSchoolReCord);

		comboBoxPosition = new JComboBox();
		comboBoxPosition.setModel(new DefaultComboBoxModel(
				new String[] { "\u521D\u7EA7", "\u4E2D\u7EA7", "\u526F\u9AD8\u7EA7", "\u6B63\u9AD8\u7EA7" }));
		comboBoxPosition.setBounds(396, 179, 82, 24);
		Buttonpanel.add(comboBoxPosition);

		comboBoxDepartment = new JComboBox();
		comboBoxDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isadd) {
					textFieldID.setText(getID());
				}
			}
		});
		comboBoxDepartment.setModel(new DefaultComboBoxModel(new String[] { "\u4EBA\u529B\u8D44\u6E90\u90E8\u95E8",
				"\u8FD0\u8425\u90E8\u95E8", "\u4FE1\u606F\u6280\u672F\u90E8\u95E8", "\u8D22\u52A1\u90E8\u95E8",
				"\u9500\u552E\u548C\u5E02\u573A\u90E8\u95E8", "\u5BA2\u6237\u670D\u52A1\u90E8\u95E8",
				"\u91C7\u8D2D\u90E8\u95E8", "\u6CD5\u52A1\u90E8\u95E8",
				"\u7814\u7A76\u548C\u53D1\u5C55\u90E8\u95E8" }));
		comboBoxDepartment.setBounds(155, 175, 143, 24);
		Buttonpanel.add(comboBoxDepartment);
		
		setEmpty();

		// �������ӵ����¼�
		final JTableHeader header = emTable.getTableHeader();
		// ��ͷ���Ӽ���
		header.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				// ֻ��ȡ�����¼�
				if (e.getClickCount() == 1) {
					// ��ȡ�����������
					int pick = header.columnAtPoint(e.getPoint());
					System.out.println(pick);
					if(pick==0) {//���ְ����ű�ͷ
						if(flagSortID!=1) {
							Collections.sort(emTable.getArraylist(),new Comparator<Employee>() {
							@Override
							public int compare(Employee o1, Employee o2) {
								int flag;
								//��ְ���Ž�����������
								flag=o1.getEmployeeID().compareTo(o2.getEmployeeID());
								return flag;
							}
						});
						flagSortID=1;
						}else {
							Collections.sort(emTable.getArraylist(),new Comparator<Employee>() {
							@Override
							public int compare(Employee o1, Employee o2) {
								int flag;
								//��ְ���Ž��н�������
								flag=o2.getEmployeeID().compareTo(o1.getEmployeeID());
								return flag;
							}
						});
						flagSortID=-1;
						}
					}
					if(pick==1) {//���������ͷ
						if(flagSortName!=1) {
							Collections.sort(emTable.getArraylist(),new Comparator<Employee>() {
							@Override
							public int compare(Employee o1, Employee o2) {
								int flag;
								//������������������
								flag=o1.getName().compareTo(o2.getName());
								if(flag==0) {//ְ�����Ϊ�ڶ��ؼ���
									flag=o1.getEmployeeID().compareTo(o2.getEmployeeID());
								}
								return flag;
							}
						});
						flagSortName=1;
						}else {
							Collections.sort(emTable.getArraylist(),new Comparator<Employee>() {
							@Override
							public int compare(Employee o1, Employee o2) {
								int flag;
								//���������н�������
								flag=o2.getName().compareTo(o1.getName());
								if(flag==0) {//ְ�����Ϊ�ڶ��ؼ���
									flag=o2.getEmployeeID().compareTo(o1.getEmployeeID());
								}
								return flag;
							}
						});
						flagSortName=-1;
						}
					}
					if(pick==2) {//������֤�ű�ͷ
						if(flagSortIDCard!=1) {
							Collections.sort(emTable.getArraylist(),new Comparator<Employee>() {
							@Override
							public int compare(Employee o1, Employee o2) {
								int flag;
								//�����֤�Ž�����������
								flag=o1.getCardNumber().compareTo(o2.getCardNumber());
								return flag;
							}
						});
						flagSortIDCard=1;
						}else {
							Collections.sort(emTable.getArraylist(),new Comparator<Employee>() {
							@Override
							public int compare(Employee o1, Employee o2) {
								int flag;
								//�����֤�Ž��н�������
								flag=o2.getCardNumber().compareTo(o1.getCardNumber());
								return flag;
							}
						});
						flagSortIDCard=-1;
						}
					}
					if(pick==5) {//����������ڱ�ͷ
						if(flagSortBrithday!=1) {
							Collections.sort(emTable.getArraylist(),new Comparator<Employee>() {
							@Override
							public int compare(Employee o1, Employee o2) {
								int flag;
								//���������ڽ�����������
								flag=o1.getBirthday().compareTo(o2.getBirthday());
								if(flag==0) {//ְ�����Ϊ�ڶ��ؼ���
									flag=o1.getEmployeeID().compareTo(o2.getEmployeeID());
								}
								return flag;
							}
						});
						flagSortBrithday=1;
						}else {
							Collections.sort(emTable.getArraylist(),new Comparator<Employee>() {
							@Override
							public int compare(Employee o1, Employee o2) {
								int flag;
								//���������ڽ��н�������
								flag=o2.getBirthday().compareTo(o1.getBirthday());
								if(flag==0) {//ְ�����Ϊ�ڶ��ؼ���
									flag=o2.getEmployeeID().compareTo(o1.getEmployeeID());
								}
								return flag;
							}
						});
						flagSortBrithday=-1;
						}
					}
					if(pick==7) {//������ű�ͷ
						if(flagSortDepartment!=1) {
							Collections.sort(emTable.getArraylist(),new Comparator<Employee>() {
							@Override
							public int compare(Employee o1, Employee o2) {
								int flag;
								//�����Ž�����������
								flag=o1.getDepartment().compareTo(o2.getDepartment());
								if(flag==0) {//ְ�����Ϊ�ڶ��ؼ���
									flag=o1.getEmployeeID().compareTo(o2.getEmployeeID());
								}
								return flag;
							}
						});
						flagSortDepartment=1;
						}else {
							Collections.sort(emTable.getArraylist(),new Comparator<Employee>() {
							@Override
							public int compare(Employee o1, Employee o2) {
								int flag;
								//�����Ž��н�������
								flag=o2.getDepartment().compareTo(o1.getDepartment());
								if(flag==0) {//ְ�����Ϊ�ڶ��ؼ���
									flag=o2.getEmployeeID().compareTo(o1.getEmployeeID());
								}
								return flag;
							}
						});
						flagSortDepartment=-1;
						}
					}
					if(pick==12) {//����༭ʱ���ͷ
						if(flagSortEditTime!=1) {
							Collections.sort(emTable.getArraylist(),new Comparator<Employee>() {
							@Override
							public int compare(Employee o1, Employee o2) {
								int flag;
								//���༭ʱ�������������
								flag=o1.getEditTime().compareTo(o2.getEditTime());
								if(flag==0) {//ְ�����Ϊ�ڶ��ؼ���
									flag=o1.getEmployeeID().compareTo(o2.getEmployeeID());
								}
								return flag;
							}
						});
						flagSortEditTime=1;
						}else {
							Collections.sort(emTable.getArraylist(),new Comparator<Employee>() {
							@Override
							public int compare(Employee o1, Employee o2) {
								int flag;
								//���༭ʱ����н�������
								flag=o2.getEditTime().compareTo(o1.getEditTime());
								if(flag==0) {//ְ�����Ϊ�ڶ��ؼ���
									flag=o2.getEmployeeID().compareTo(o1.getEmployeeID());
								}
								return flag;
							}
						});
						flagSortEditTime=-1;
						}
					}
					emTable.setArraylist(emTable.getArraylist());//�������ˢ��
					emTable.initTable();
					
				}
			}
		});

		emTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {// ѡ����
			public void valueChanged(ListSelectionEvent e) {
				textFieldID.setEditable(false); // ����Ϊ���ɱ༭״̬
				textFieldEditTime.setEditable(false); // ����Ϊ���ɱ༭״̬
				flagEmpty=0;
				isadd = false;
				if (emTable.getSelectedRow() != -1) {
					// System.out.println("���");
					if (emTable.currentPage <= emTable.totalPage) {
						int index = emTable.getSelectedRow() + (emTable.getCurrentPage() - 1) * emTable.getPageCount();
						textFieldID.setText(emTable.getArraylist().get(index).getEmployeeID());
						textFieldName.setText(emTable.getArraylist().get(index).getName());
						textFieldIDCard.setText(emTable.getArraylist().get(index).getCardNumber());
						textFieldNation.setText(emTable.getArraylist().get(index).getNation());
						if (emTable.getArraylist().get(index).getSex().equals("��")) {
							ButtonM.setSelected(true);
						} else {
							ButtonF.setSelected(true);
						}
						// ������Դ���ţ���Ӫ���ţ���Ϣ�������ţ������ţ����ۺ��г����ţ��ͻ������ţ��ɹ����ţ������ţ��о��ͷ�չ����
						// Сѧ��������ѧ���߼���ѧ��ר�ƣ����ƣ�˶ʿ�о�������ʿ�о���
						// �������м������߼������߼�
						String[] departments = RandomValue.getDepartments().split("-");
						for (int i = 0; i < departments.length; i++) {
							if (emTable.getArraylist().get(index).getDepartment().trim().equals(departments[i])) {
								comboBoxDepartment.setSelectedIndex(i);
							}
						}
						String[] degrees = RandomValue.getDegrees().split("-");
						for (int i = 0; i < degrees.length; i++) {
							if (emTable.getArraylist().get(index).getSchoolRecord().trim().equals(degrees[i])) {
								comboBoxSchoolReCord.setSelectedIndex(i);
							}
						}
						String[] titles = RandomValue.getTitles().split("-");
						for (int i = 0; i < titles.length; i++) {
							if (emTable.getArraylist().get(index).getPositionName().trim().equals(titles[i])) {
								comboBoxPosition.setSelectedIndex(i);
							}
						}

						textFieldBirthDay.setText(emTable.getArraylist().get(index).getBirthday());
						textFieldAddress.setText(emTable.getArraylist().get(index).getRoad());
						textFieldTellphone.setText(emTable.getArraylist().get(index).getTellphone());
						textFieldEmail.setText(emTable.getArraylist().get(index).getEmail());
						textFieldEditTime.setText(emTable.getArraylist().get(index).getEditTime());
						textAreaInfo.setText(emTable.getArraylist().get(index).getInfo());
						System.out.println(comboBoxSchoolReCord.getSelectedItem().toString());
					}

				}
			}
		});

		upPane = new JScrollPane(emTable);
		mainPane.setLeftComponent(upPane);

		downPane = new JScrollPane();
		mainPane.setRightComponent(downPane);

		downPane.setViewportView(Buttonpanel);
		Buttonpanel.setLayout(null);

		lblxx = new JLabel("\u5171xx\u6761\u8BB0\u5F55");
		lblxx.setBounds(56, 13, 122, 18);
		lblxx.setText("��" + String.valueOf(emTable.getArraylistLength()) + "������");
		Buttonpanel.add(lblxx);

		lblxx_1 = new JLabel("\u5171xx\u9875");
		lblxx_1.setBounds(987, 13, 72, 18);
		lblxx_1.setText("��" + emTable.getTotolPage() + "ҳ");
		Buttonpanel.add(lblxx_1);

		label_13 = new JLabel("\u6BCF\u987520\u6761");
		label_13.setBounds(225, 13, 122, 18);
		label_13.setText("ÿҳ" + emTable.getPageCount() + "������");
		Buttonpanel.add(label_13);

		label_14 = new JLabel("\u5F53\u524D\u7B2C");
		label_14.setBounds(816, 13, 72, 18);
		Buttonpanel.add(label_14);

		label_15 = new JLabel("\u9875");
		label_15.setBounds(937, 13, 72, 18);
		Buttonpanel.add(label_15);

		textField_12 = new JTextField();
		textField_12.setBounds(874, 10, 59, 24);
		Buttonpanel.add(textField_12);
		textField_12.setColumns(10);
		textField_12.setText(String.valueOf(emTable.getCurrentPage()));

		button_1 = new JButton("\u4E0A\u4E00\u9875");
		button_1.setBounds(408, 9, 113, 27);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emTable.getPreviousPage();
				emTable.initTable();
				textField_12.setText(String.valueOf(emTable.getCurrentPage()));
			}
		});
		Buttonpanel.add(button_1);

		button_2 = new JButton("\u4E0B\u4E00\u9875");
		button_2.setBounds(631, 9, 113, 27);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emTable.getNextPage();
				emTable.initTable();
				textField_12.setText(String.valueOf(emTable.getCurrentPage()));
			}
		});
		Buttonpanel.add(button_2);

		button_3 = new JButton("\u8DF3\u8F6C");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emTable.setCurrentPage(Integer.valueOf((textField_12.getText().trim())));
				emTable.initTable();
				textField_12.setText(String.valueOf(emTable.getCurrentPage()));
			}
		});
		button_3.setBounds(1073, 9, 113, 27);
		Buttonpanel.add(button_3);

		JScrollPane scrollPane = new JScrollPane(textAreaInfo);
		scrollPane.setBounds(137, 274, 917, 149);
		Buttonpanel.add(scrollPane);

		// �ֱ�����ˮƽ�ʹ�ֱ���������ǳ���
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JButton buttonModify = new JButton("\u4FEE\u6539");
		buttonModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emTable.getSelectedRow() != -1) {//�ж��Ƿ�ѡ����
					textFieldEditTime.setEditable(false);
					if(flagEmpty!=1) {
						if(isEmpty()) {
							JOptionPane.showMessageDialog(null, "�뽫����ע���������Ϣ��д���!");
						}
						else{
							int index = emTable.getSelectedRow() + (emTable.getCurrentPage() - 1) * emTable.getPageCount();
							String sex = null;
							if (ButtonM.isSelected()) {
								sex = ButtonM.getText();
							} else {
								sex = ButtonF.getText();
							}
							comboBoxSchoolReCord.getSelectedItem().toString();
										
							Employee em = new Employee();
							em.setEmployeeID(textFieldID.getText());
							em.setName(textFieldName.getText());
							em.setCardNumber(textFieldIDCard.getText());
							em.setNation(textFieldNation.getText());
							em.setSex(sex);
							em.setBirthday(textFieldBirthDay.getText());
							em.setSchoolRecord(comboBoxSchoolReCord.getSelectedItem().toString());
							em.setDepartment(comboBoxDepartment.getSelectedItem().toString());
							em.setPositionName(comboBoxPosition.getSelectedItem().toString());
							em.setRoad(textFieldAddress.getText());
							em.setTellphone(textFieldTellphone.getText());
							em.setEmail(textFieldEmail.getText());
							em.setEditTime(df.format(new Date()));
							em.setInfo(textAreaInfo.getText());
							try {
								EmloyeeServiceFactory.getIEmpServiceInstance().update(em);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							emTable.getArraylist().set(index, em);//�޸�arraylist�������
							emTable.setArraylist(emTable.getArraylist());//�������ˢ��
							emTable.initTable();
							
							JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
						}
					}
				}
			}
		});
		buttonModify.setBounds(677, 447, 113, 27);
		Buttonpanel.add(buttonModify);

		JButton buttonDel = new JButton("\u5220\u9664");
		buttonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (emTable.getSelectedRow() != -1) {//�ж��Ƿ�ѡ����
					if(flagEmpty!=1) {
						int index = emTable.getSelectedRow() + (emTable.getCurrentPage() - 1) * emTable.getPageCount();
						
						try {
							EmloyeeServiceFactory.getIEmpServiceInstance().delete(emTable.getArraylist().get(index));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						emTable.getArraylist().remove(index); //ɾ��arraylist�������
						emTable.setArraylist(arraylist);//�������ˢ��
						emTable.initTable();
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					}	
				}
			}
		});
		buttonDel.setBounds(910, 447, 113, 27);
		Buttonpanel.add(buttonDel);
		
		JButton buttonAddTata = new JButton("\u6DFB\u52A0\u6570\u636E");
		buttonAddTata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setData();
			}
		});
		buttonAddTata.setBounds(429, 447, 113, 27);
		Buttonpanel.add(buttonAddTata);

		JButton buttonAdd = new JButton("\u6DFB\u52A0");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flagEmpty!=1) {
					if(isEmpty()) {
						JOptionPane.showMessageDialog(null, "�뽫����ע���������Ϣ��д��ϣ�");
					}
					else{
						SimpleDateFormat df1 = new SimpleDateFormat("yyMMdd");// �������ڸ�ʽ
						String numDate = df1.format(new Date());
						String str = textFieldID.getText().trim();
						int id = Integer.valueOf(str.substring(8));
						StringBuffer ID = new StringBuffer();
						id++;
						ID.append(numDate);
						ID.append("-");
						ID.append(id);
		
						String sex = null;
						if (ButtonM.isSelected()) {
							sex = ButtonM.getText();
						} else {
							sex = ButtonF.getText();
						}
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
						
						if (textFieldID.getText().trim().equals(getID())) {
							Employee em = new Employee();
							em.setEmployeeID(textFieldID.getText());
							em.setName(textFieldName.getText());
							em.setCardNumber(textFieldIDCard.getText());
							em.setNation(textFieldNation.getText());
							em.setSex(sex);
							em.setBirthday(textFieldBirthDay.getText());
							em.setSchoolRecord(comboBoxSchoolReCord.getSelectedItem().toString());
							em.setDepartment(comboBoxDepartment.getSelectedItem().toString());
							em.setPositionName(comboBoxPosition.getSelectedItem().toString());
							em.setRoad(textFieldAddress.getText());
							em.setTellphone(textFieldTellphone.getText());
							em.setEmail(textFieldEmail.getText());
							em.setEditTime(df.format(new Date()));
							em.setInfo(textAreaInfo.getText());
							
							try {
								EmloyeeServiceFactory.getIEmpServiceInstance().insert(em);
							} catch (Exception e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}		
							try {
								FileControl.writeFile(ID.toString());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							emTable.getArraylist().add(em);
							emTable.setArraylist(emTable.getArraylist());//�������ˢ��
							emTable.initTable();
							JOptionPane.showMessageDialog(null, "��ӳɹ���");
						} else {
							JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
						}
					}
				}
			}
			
		});
		buttonAdd.setBounds(182, 447, 113, 27);
		Buttonpanel.add(buttonAdd);
		
		JButton ButtonEmpty = new JButton("\u6E05\u7A7A");
		ButtonEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEmpty();
			}
		});
		ButtonEmpty.setBounds(1227, 447, 113, 27);
		Buttonpanel.add(ButtonEmpty);
		
		JButton buttonSeek = new JButton("\u67E5\u627E");
		buttonSeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flagSeek=1;
				array=new ArrayList<Employee>();
				String sex;
				Employee em = new Employee();
				em.setEmployeeID(textFieldID.getText());
				em.setName(textFieldName.getText());
				em.setCardNumber(textFieldIDCard.getText());
				em.setNation(textFieldNation.getText());
				if(ButtonM.isSelected()) {
					sex="��";
				}else {
					sex="Ů";
				}
				em.setSex(sex);
				em.setBirthday(textFieldBirthDay.getText());
				if(comboBoxSchoolReCord.getSelectedItem()==null) {
					em.setSchoolRecord("");
				}else {
					em.setSchoolRecord(comboBoxSchoolReCord.getSelectedItem().toString());
				}
				if(comboBoxDepartment.getSelectedItem()==null) {
					em.setDepartment("");
				}else {
					comboBoxDepartment.setSelectedItem(comboBoxDepartment.getSelectedItem().toString());
				}
				if(comboBoxPosition.getSelectedItem()==null) {
					em.setPositionName("");
				}else {
					comboBoxPosition.setSelectedItem(comboBoxPosition.getSelectedItem().toString());
				}
				em.setRoad(textFieldAddress.getText());
				em.setTellphone(textFieldTellphone.getText());
				em.setEmail(textFieldEmail.getText());
				em.setEditTime(textFieldEditTime.getText());
				em.setInfo(textAreaInfo.getText());
				try {
					emTable.setArraylist(EmloyeeServiceFactory.getIEmpServiceInstance().findByAll(em));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				emTable.initTable();
				lblxx.setText("��" + String.valueOf(emTable.getArraylistLength()) + "������");
				label_13.setText("ÿҳ" + emTable.getPageCount() + "������");
				textField_12.setText(String.valueOf(emTable.getCurrentPage()));
				lblxx_1.setText("��"+String.valueOf(emTable.getTotolPage())+"ҳ");
			}
		});
		buttonSeek.setBounds(1414, 447, 113, 27);
		Buttonpanel.add(buttonSeek);
	}
	
	public boolean isEmpty() {
		boolean flag=false;
		if(textFieldName.getText().equals("")||textFieldIDCard.getText().equals("")||textFieldNation.getText().equals("")||textFieldBirthDay.getText().equals("")||textFieldAddress.getText().equals("")||textFieldTellphone.getText().equals("")||textFieldEmail.getText().equals("")) {
			flag=true;
		}
		return flag;
	}
	/**
	 * ���Ա����Ϣ������������
	 */
	public void setEmpty() {
		flagEmpty=1;
		textFieldID.setText("");
		textFieldID.setEditable(true); // ����Ϊ�ɱ༭״̬
		textFieldName.setText("");
		textFieldIDCard.setText("");
		textFieldNation.setText("");
		textFieldBirthDay.setText("");
		ButtonM.setSelected(false);
		ButtonF.setSelected(false);
		comboBoxSchoolReCord.setSelectedItem(null);
		comboBoxDepartment.setSelectedItem(null);
		comboBoxPosition.setSelectedItem(null);
		textFieldAddress.setText("");
		textFieldTellphone.setText("");
		textFieldEmail.setText("");
		textFieldEditTime.setText("");
		textFieldEditTime.setEditable(true);//����Ϊ�ɱ༭״̬
		textAreaInfo.setText("");
	}
	/**
	 * �����Ϣ�������������ΪĬ��ѡ��
	 */
	public void setData() {
		flagEmpty=0;
		isadd = true;
		textFieldID.setEditable(false); // ����Ϊ���ɱ༭״̬
		textFieldEditTime.setEditable(false);
		comboBoxDepartment.setSelectedIndex(0);// Ĭ������Ϊ��һ������
		textFieldID.setText(getID());
		textFieldName.setText("");
		textFieldIDCard.setText("");
		textFieldNation.setText("");
		ButtonM.setSelected(true);
		textFieldBirthDay.setText("");
		comboBoxSchoolReCord.setSelectedIndex(0);
		comboBoxPosition.setSelectedIndex(0);
		textFieldAddress.setText("");
		textFieldTellphone.setText("");
		textFieldEmail.setText("");
		textFieldEditTime.setText("");
		textAreaInfo.setText("");
	}
	/**
	 * ����Ա�����
	 * @return
	 */
	public String getID() {
		StringBuffer ID = new StringBuffer();
		String[] s = RandomValue.getDepartments().split("-");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
			if (comboBoxDepartment.getSelectedIndex() == i) {
				ID.append("0" + (i + 1));
				SimpleDateFormat df1 = new SimpleDateFormat("yyMMdd");// �������ڸ�ʽ
				String numDate = df1.format(new Date());
				String line = null;
				int id;
				try {
					line = FileControl.readFile();
					System.out.println(":" + line);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String[] str = line.split("-");
				ID.append(numDate);
				if (str[0].equals(numDate)) {// �ļ��еı�����ںͽ��������һ��
					id = Integer.valueOf(str[1]);
				} else {// �ļ��еı�����ڲ�һ�£���1����
					id = 1;
				}
				ID.append(String.format("%04d", id));
				System.out.println(ID);
				textFieldID.setText(ID.toString());
				break;
			}
		}

		return ID.toString();
	}
	/**
	 * ���������д��Excel����
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	private void jButtonActionPerformed() throws RowsExceededException, WriteException {
		// TODO add your handling code here:����
		 FileDialog fd = new FileDialog(this, "����Ա����Ϣ", FileDialog.SAVE);
		 fd.setLocation(500, 350);
	     fd.setVisible(true);
	     String stringfile = fd.getDirectory()+fd.getFile()+".xls";  
         ExcelExporter export = new ExcelExporter();      
		 String[] columnNames = { "ְ�����", "����", "���֤��", "����", "�Ա�", "��������", "ѧ��", "����", "ְ��", "סַ","�ֻ�����", "�����ʼ�","�༭ʱ��", "��ע" };
		 					  							 	
		 //Object[][] nothing= {{"042006270029","�ξ���","653227198407293812","������","��","19840729","������ѧ","������","���߼�","��ɽ֧��90��-2-7","13703342594","940hicvxu@yeah.net","2020-06-27","17:15:31","NULL"}};
		 Object[][] Data=getData(emTable.getArraylist());
		 DefaultTableModel model=new DefaultTableModel(Data,columnNames);
		 JTable table = new JTable(model);
		 try {
			export.exportTable(table, new File(stringfile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
	
	public void view3() {
		JTable table;
		Object[][] Datas = { {"Ա�����", "Ա������", "�ٵ�", "����", "���ݼ�","����","�¼�","����ʱ��","������Ϣ"} };
		String[] headers = { "Ա�����", "Ա������", "�ٵ�", "����", "���ݼ�","����","�¼�","����ʱ��","������Ϣ" };
		// Object[][] Datas = {{"row1-col1", "row1-col2"},{"row2-col1", "row2-col2"}};
		// String[] headers= {"col1", "col2"};
		
		table = new JTable(Datas, headers);

		upPane = new JScrollPane(table);
		mainPane.setLeftComponent(upPane);

		downPane = new JScrollPane();
		mainPane.setRightComponent(downPane);
	}
	public void view4() {
		JTable table;
		Object[][] Datas = { {"���ʱ��", "Ա�����", "���ʷ�������", "��������", "�Ӱ๤��","�ܹ���","���ڿ۳�","���տ۳�","˰�տ۳�","�ܿ۳�","ʵ�ʹ���","�༭ʱ��","������Ϣ"} };
		String[] headers = { "���ʱ��", "Ա�����", "���ʷ�������", "��������", "�Ӱ๤��","�ܹ���","���ڿ۳�","���տ۳�","˰�տ۳�","�ܿ۳�","ʵ�ʹ���","�༭ʱ��","������Ϣ" };
		// Object[][] Datas = {{"row1-col1", "row1-col2"},{"row2-col1", "row2-col2"}};
		// String[] headers= {"col1", "col2"};
		
		table = new JTable(Datas, headers);

		upPane = new JScrollPane(table);
		mainPane.setLeftComponent(upPane);

		downPane = new JScrollPane();
		mainPane.setRightComponent(downPane);
	}
	public void view5() {
		JTable table;
		Object[][] Datas = { { "���˺�", "Ա�����", "�����Ƿ�ͨ��", "����ʱ��", "�༭ʱ��","������Ϣ"} };
		String[] headers = { "���˺�", "Ա�����", "�����Ƿ�ͨ��", "����ʱ��", "�༭ʱ��","������Ϣ" };
		// Object[][] Datas = {{"row1-col1", "row1-col2"},{"row2-col1", "row2-col2"}};
		// String[] headers= {"col1", "col2"};
		
		table = new JTable(Datas, headers);

		upPane = new JScrollPane(table);
		mainPane.setLeftComponent(upPane);

		downPane = new JScrollPane();
		mainPane.setRightComponent(downPane);
	}
}
