package blog.com.blog.gui;

import blog.com.blog.controller.LoginCon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FramLogin extends JFrame {
    /**
	 * ��¼����
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p;
    private JLabel blName1, blPwd1;
    private JTextField txtName;
    private JPasswordField txtPwd;
    private JButton btnOk, btnreg;
    public FramLogin() {
        super("��¼");
        p = new JPanel();
        p.setLayout(null);
        blName1 = new JLabel("�ʺ�");
        blPwd1 = new JLabel("��    ��");
        txtName = new JTextField(20);
        txtPwd = new JPasswordField(20);
        txtPwd.setEchoChar('*');
        btnOk = new JButton("ȷ��");
        btnreg = new JButton("ע��");
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
        // ���ô��岻�ɸı��С
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ע��ȷ����ť���¼�����
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginCon loginCon = new LoginCon();
                // ��ȡ�û�������û���
                String strName = txtName.getText();
                // ��ȡ�û����������
                String strPwd = new String(txtPwd.getPassword());
                boolean fag = loginCon.login(strName, strPwd);
                // ����Ϣ�Ի�������ʾ�û��������Ϣ
                if (fag)
                    JOptionPane.showMessageDialog(null, "��ϲ������¼�ɹ���", "��ʾ����", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�", "��ʾ����", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        // ע�ᰴť���¼�����
        btnreg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegUser reg = new RegUser();
                
                
                
                
//                LoginCon loginCon = new LoginCon();
//                // ��ȡ�û�������û���
//                String strName = txtName.getText();
//                // ��ȡ�û����������
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
