package blog.com.blog.gui;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import blog.com.blog.controller.LoginCon;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;

public class BlogLogin {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogLogin window = new BlogLogin();
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
	public BlogLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 270, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		username = new JTextField();
		username.setBounds(61, 39, 132, 21);
		username.setColumns(10);
		
		JButton login = new JButton("\u767B\u5F55");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				LoginCon loginCon = new LoginCon();
                // 获取用户输入的用户名
                String strName = username.getText();
                // 获取用户输入的密码
                String strPwd = new String(password.getPassword());
                boolean fag = loginCon.login(strName, strPwd);
                // 在消息对话框中显示用户输入的信息
                if (fag)
                    JOptionPane.showMessageDialog(null, "恭喜您，登录成功！", "提示窗口", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "登录失败！", "提示窗口", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		login.setBounds(30, 144, 75, 23);
		
		JButton reg = new JButton("\u6CE8\u518C");
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegUser reg = new RegUser();
				reg.frame.setVisible(true);
			}
		});
		reg.setBounds(140, 144, 75, 23);
		
		JLabel lblNewLabel = new JLabel("\u5E10\u53F7");
		lblNewLabel.setBounds(20, 45, 30, 15);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(20, 84, 30, 15);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(username);
		frame.getContentPane().add(login);
		frame.getContentPane().add(reg);
		
		password = new JPasswordField();
		password.setBounds(61, 81, 132, 21);
		frame.getContentPane().add(password);
	}

}
