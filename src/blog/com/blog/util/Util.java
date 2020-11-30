package blog.com.blog.util;

import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Util {
    //���ݿ����ӵ�url
    private static final String url = "jdbc:mysql://localhost:3306/java?characterEncoding=UTF-8";
    //���ݿ����ӵ�user
    private static final String user = "root";
    //���ݿ����ӵ�����
    private static final String password = "root";


    /**
     * �Լ���װ��һ������������һ�����Ӷ���
     *
     * @return Connection����
     */
    public static Connection getConn() {

        Connection conn = null;
        try {
            // 1 ��������
            // com.mysql.jdbc.Driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2��ȡ����
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }

    /**
     * ��װ������ ɾ�� ���޸�ͨ�ô���(����κα�)
     *
     * @param sql    sql���
     * @param params ����
     * @return true �����ɹ� false ����ʧ��
     */
    public  int exEdit(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int n = 0;
        try {
            // 2��ȡ����
            conn = getConn();
            // 3�õ�һ��PrepardStatement
            pstmt = conn.prepareStatement(sql);
            // �����Զ��巽�������ò���
            setParameters(pstmt, params);
            // 4ִ�о������ ����ɾ���Լ��޸�
            n = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 6�ͷ���Դ
            closeAll(null, pstmt, conn);
        }
        return n;

    }

    /**
     * ���ò����ķ���
     *
     * @param pstmt  PreparedStatement ����
     * @param params Object... params �ɱ����
     * @throws SQLException SQLException �쳣
     */
    public static void setParameters(PreparedStatement pstmt, Object... params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        }
    }

    /**
     * ͨ�ò�ѯ����(���ؽ����һ������)
     *
     * @param sql    ��ѯ���
     * @param cla    Class����
     * @param params ����
     * @return List ����
     */
    public List exQuery(String sql, Class cla, Object... params) {
        List list = new ArrayList();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 2��ȡ����
            conn = getConn();
            // 3�õ�һ��PrepardStatement
            pstmt = conn.prepareStatement(sql);
            // ����ռλ���Ĳ���
            setParameters(pstmt, params);

            // 4ִ�о������ (ResultSet �����)
            rs = pstmt.executeQuery();
            // 5����rs
            while (rs.next()) {
                Object obj = convert(rs, cla);
                // �õ�һ��obj ,�������list
                list.add(obj);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeAll(rs, pstmt, conn);
        }
        return list;// ��
    }

    /**
     * ת������ ��rs��ȡ���ת������
     *
     * @param rs  �����
     * @param cla  Class����
     * @return  Object
     */
    private static Object convert(ResultSet rs, Class cla) {

        Object obj = null;
        try {
            obj = cla.newInstance();
            ResultSetMetaData rsmd = rs.getMetaData();
            // System.out.println(rsmd);

            // System.out.println(rsmd.getColumnCount()); //������
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                // getColumnLabel ����б��������Ǳ��� as ��; getColumnName �ͱ��е��� һ��->����
                // System.out.println(rsmd.getColumnLabel(i)+","+rsmd.getColumnName(i));
                String name = rsmd.getColumnLabel(i);
                Object objvalue = rs.getObject(name);
                // XX.set����(����,����,���Ե�ֵ); ���� ������һ��
                BeanUtils.setProperty(obj, name, objvalue);
            }
        } catch (InstantiationException | IllegalAccessException | SQLException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return obj;
    }

    /**
     * �ͷ���Դ
     *
     * @param rs    ResultSet����
     * @param pstmt PreparedStatement ����
     * @param conn  Connection����
     */
    public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        // 6�ͷ���Դ
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            if (pstmt != null)
                pstmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
