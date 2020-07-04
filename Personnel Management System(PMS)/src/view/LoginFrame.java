package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import PMS.factory.UserServiceFactory;
import PMS.vo.User;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);//���ô��ڲ��ܸĶ���С
		setLocationRelativeTo(null);//�������
		setTitle("���¹���ϵͳ");	
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelUserName = new JLabel("\u7528\u6237\u540D\uFF1A");
		LabelUserName.setBounds(43, 60, 72, 18);
		contentPane.add(LabelUserName);
		
		textUserName = new JTextField();
		textUserName.setBounds(116, 57, 224, 24);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel labelUserPass = new JLabel("\u5BC6\u7801\uFF1A");
		labelUserPass.setBounds(43, 118, 61, 18);
		contentPane.add(labelUserPass);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(116, 115, 224, 24);
		contentPane.add(textPassword);
		
		JButton ButtonEnter = new JButton("\u767B\u5F55");
		ButtonEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ȡ�û���������
				String username=textUserName.getText().trim();
				String password=textPassword.getText().trim();
				
				//�û�������
				String usernameRegex="[a-zA-Z]{1}[a-zA-Z0-9]{3,7}";
				//�������
				String passwordRegex="\\w{6,12}";
				
				//У��
				if(!username.matches(usernameRegex)||!password.matches(passwordRegex)) {
					JOptionPane.showMessageDialog(null, "�û������������");
					textPassword.setText("");
					return;
				}
				
				//�����û������ܣ�����һ��booleanֵ
				User u=new User();
				u.setUsername(username);
				u.setPassword(password);
				boolean flag=false;
				try {
					flag = UserServiceFactory.getUserServiceInstance().login(u);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(flag) {
					JOptionPane.showMessageDialog(null, "��¼�ɹ�");
					//��������
					mainFrame mainframe = null;
					try {
						mainframe = new mainFrame();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mainframe.setVisible(true);
					dispose();
							
				}else {
					JOptionPane.showMessageDialog(null, "�û�������������");
					textPassword.setText("");		
				}
					
			}
		});
		ButtonEnter.setBounds(54, 202, 113, 27);
		contentPane.add(ButtonEnter);
		
		JButton ButtonReset = new JButton("\u91CD\u7F6E");
		ButtonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUserName.setText("");
				textPassword.setText("");
			}
		});
		ButtonReset.setBounds(262, 202, 113, 27);
		contentPane.add(ButtonReset);
	}
}
