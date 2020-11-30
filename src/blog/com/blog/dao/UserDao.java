package blog.com.blog.dao;

import blog.com.blog.entity.User;
import blog.com.blog.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * �û����ݴ����
 */
public class UserDao {
    Connection connection = null;
    PreparedStatement pt = null;
    List<User> list = new ArrayList<>();
    Statement statement = null;

    Util util = new Util();
    /**
     * �û�ע��ģ��
     * @param user
     * @return �����޸Ĵ��� 0 δ���
     */
    public int userAdd(User user){
        String sql = "INSERT INTO blog_user VALUES(?,?,?,?,?,?)";
        return util.exEdit(sql,user.getId(),user.getName(),user.getUsername(),user.getPassword(),user.getText(),user.getRc());
    }

    /**
     * ��¼��ѯģ��
     * @param user
     * @return ���ض���
     */
    public User userLogin(User user){
        String sql = "SELECT * FROM blog_user where username = ? AND password = ? ";
        User user1;
        List<User> list = util.exQuery(sql,user.getClass(),user.getUsername(),user.getPassword());
        if (list.size()==0){
            user1 = null ;
        }else{
            user1 = list.get(0);
        }
        return user1;
    }
    /**
     *�û��޸���Ϣ
     * @param user
     * @return ����Ӱ������
     */
    public int userUpdata (User user){
        String sql = "UPDATE blog_user SET name = ?,username = ?,password = ?,rc = ?, text = ? WHERE id = ?";
        return util.exEdit(sql,user.getName(),user.getUsername(),user.getPassword(),user.getRc(),user.getText(),user.getId());
    }

}
