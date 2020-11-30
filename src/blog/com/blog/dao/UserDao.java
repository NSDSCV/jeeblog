package blog.com.blog.dao;

import blog.com.blog.entity.User;
import blog.com.blog.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户数据处理层
 */
public class UserDao {
    Connection connection = null;
    PreparedStatement pt = null;
    List<User> list = new ArrayList<>();
    Statement statement = null;

    Util util = new Util();
    /**
     * 用户注册模块
     * @param user
     * @return 返回修改次数 0 未添加
     */
    public int userAdd(User user){
        String sql = "INSERT INTO blog_user VALUES(?,?,?,?,?,?)";
        return util.exEdit(sql,user.getId(),user.getName(),user.getUsername(),user.getPassword(),user.getText(),user.getRc());
    }

    /**
     * 登录查询模块
     * @param user
     * @return 返回对象
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
     *用户修改信息
     * @param user
     * @return 返回影响行数
     */
    public int userUpdata (User user){
        String sql = "UPDATE blog_user SET name = ?,username = ?,password = ?,rc = ?, text = ? WHERE id = ?";
        return util.exEdit(sql,user.getName(),user.getUsername(),user.getPassword(),user.getRc(),user.getText(),user.getId());
    }

}
