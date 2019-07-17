package com.geekymv.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcSample {

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.159.103:3306/eshop?useSSL=false", "zhangsan", "123456");
            conn.setAutoCommit(false);

            ps = conn.prepareStatement("insert into t_product(product_id, product_name) values(?, ?)");

            ps.setInt(1, 1);
            ps.setString(2, "MacBook Pro");

            int resutl = ps.executeUpdate();

            System.out.println("result = " + resutl);

            conn.commit();
        }catch (Exception e) {
            e.printStackTrace();
            conn.rollback();

        }finally {
            if(ps != null) {
                ps.close();
            }
            if(conn != null) {
                conn.close();
            }
        }

    }
}
