package com.HM.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql:///hm_javaweb?useSSL=false";
        String username="root";
        String password="SLJB0721.com";
        Connection conn = DriverManager.getConnection(url,username,password);

        String sql1 ="update emp set age=10 where id=1";
        String sql2 ="update emp set age=18 where id=2";

        Statement stmt=conn.createStatement();

        try {
            conn.setAutoCommit(false);
            int count1=stmt.executeUpdate(sql1);
            System.out.println(count1);

            int i=3/0;
            int count2=stmt.executeUpdate(sql2);
            System.out.println(count2);

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }

        stmt.close();
        conn.close();


    }
}
