package com.bjpowernode.util;

import java.sql.*;

/**
 * @author Yang
 * @create 2020/4/26 21:18
 */
public class DBUtil {

    private static String className = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/bjpowernode";
    private static String username = "root";
    private static String password = "root";
    private static Connection conn = null;
    private static PreparedStatement ps = null;

    static {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库链接
     * @return
     */
    public static Connection getConn() {

        try {
            conn = DriverManager.getConnection(url, username, password);
            // conn.setAutoCommit(false);//设置事务为手动提交
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获取数据库操作对象
     * @param sql
     * @return
     */
    public static PreparedStatement createStatement(String sql) {
        getConn();
        try {
            ps = conn.prepareStatement(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ps;
    }

    /**
     * 关闭链接
     * @param rs
     */
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * 关闭链接
     * @param ps
     */
    public static void close(PreparedStatement ps, Connection conn) {
        close(null, ps, conn);
    }
    /**
     * 关闭链接
     * @param rs
     */
    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
