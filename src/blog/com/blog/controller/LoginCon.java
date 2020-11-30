package blog.com.blog.controller;

import blog.com.blog.dao.UserDao;
import blog.com.blog.entity.User;

import java.util.UUID;

public class LoginCon {
    UserDao dao = new UserDao();

    /**
     * ��¼�ж�
     * @param username
     * @param password
     * @return ����
     */
    public boolean login(String username,String password){
        boolean fag = false;
        User user = new User();
            user.setUsername(username);
            user.setPassword(password);
        if (dao.userLogin(user) != null) {
            fag = true;
        }
        return fag;
    }

    /**
     * ע���ʺ�
     * @param name
     * @param password
     * @param username
     * @return �������� true ����ɹ�
     */
    public boolean regUser(String name ,String  username ,String password){
        boolean fag = false;
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setRc(1);
        user.setText("�������");
        int a = dao.userAdd(user);
        if (a>0){
            fag = true;
        }
        return fag;
    }
}
