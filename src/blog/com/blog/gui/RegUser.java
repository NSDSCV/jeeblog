package blog.com.blog.gui;

import blog.com.blog.controller.LoginCon;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegUser {

	JFrame frame;
	private JTextField nameText;
	private JTextField usernameText;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegUser window = new RegUser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 345, 229);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nameText = new JTextField();
		nameText.setBounds(133, 32, 127, 21);
		frame.getContentPane().add(nameText);
		nameText.setColumns(10);
		
		usernameText = new JTextField();
		usernameText.setBounds(133, 63, 127, 21);
		frame.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 94, 127, 21);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("\u6635\u79F0");
		lblNewLabel.setBounds(63, 35, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5E10\u53F7");
		lblNewLabel_1.setBounds(63, 66, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setBounds(63, 97, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		//ע�ᰴť �ɹ��󷵻ص�¼����
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginCon loginCon = new LoginCon();
				// ��ȡ�û�������ǳ�
				String name = nameText.getText();
				// ��ȡ�û�������ʺ�
				String strName = usernameText.getText();
				// ��ȡ�û����������
				String strPwd = new String(passwordField.getPassword());
				boolean fag = loginCon.regUser(name,strName, strPwd);
				// ����Ϣ�Ի�������ʾ�û��������Ϣ
				if (fag) {
					JOptionPane.showMessageDialog(null, "��ϲ����ע��ɹ���", "��ʾ����", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�", "��ʾ����", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});

		btnNewButton.setBounds(133, 125, 93, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
