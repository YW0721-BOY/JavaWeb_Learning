package com.HM.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo2_DriverManager {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql:///hm_javaweb?useSSL=false";
        String username="root";
        String password="SLJB0721.com";
        Connection conn = DriverManager.getConnection(url,username,password);

        String sql ="update emp set age=21 where id=1";

        Statement stmt=conn.createStatement();
        int count=stmt.executeUpdate(sql);
        System.out.println(count);

        stmt.close();
        conn.close();

    }
}
