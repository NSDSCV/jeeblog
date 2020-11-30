package blog.com.blog.gui;

import blog.com.blog.controller.LoginCon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FramLogin extends JFrame {
    /**
	 * 登录窗体
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p;
    private JLabel blName1, blPwd1;
    private JTextField txtName;
    private JPasswordField txtPwd;
    private JButton btnOk, btnreg;
    public FramLogin() {
        super("登录");
        p = new JPanel();
        p.setLayout(null);
        blName1 = new JLabel("帐号");
        blPwd1 = new JLabel("密    码");
        txtName = new JTextField(20);
        txtPwd = new JPasswordField(20);
        txtPwd.setEchoChar('*');
        btnOk = new JButton("确定");
        btnreg = new JButton("注册");
        blName1.setBounds(30, 30, 60, 25);
        txtName.setBounds(95, 30, 120, 25);
        blPwd1.setBounds(30, 60, 60, 25);
        txtPwd.setBounds(95, 60, 120, 25);
        btnOk.setBounds(60, 90, 60, 25);
        btnreg.setBounds(125, 90, 60, 25);
        p.add(blName1);
        p.add(txtName);
        p.add(blPwd1);
        p.add(txtPwd);
        p.add(btnOk);
        p.add(btnreg);
        this.add(p);
        this.setSize(250, 170);
        this.setLocation(300, 300);
        // 设置窗体不可改变大小
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 注册确定按钮的事件处理
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginCon loginCon = new LoginCon();
                // 获取用户输入的用户名
                String strName = txtName.getText();
                // 获取用户输入的密码
                String strPwd = new String(txtPwd.getPassword());
                boolean fag = loginCon.login(strName, strPwd);
                // 在消息对话框中显示用户输入的信息
                if (fag)
                    JOptionPane.showMessageDialog(null, "恭喜您，登录成功！", "提示窗口", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "登录失败！", "提示窗口", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        // 注册按钮的事件处理
        btnreg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegUser reg = new RegUser();
                
                
                
                
//                LoginCon loginCon = new LoginCon();
//                // 获取用户输入的用户名
//                String strName = txtName.getText();
//                // 获取用户输入的密码
//                String strPwd = new String(txtPwd.getPassword());
//                loginCon.regUser(strName,strPwd);
            }
        });
    }
    public static void main(String[] args) {

        FramLogin framLogin = new FramLogin();

        framLogin.setVisible(true);
    }
}
