package com.HM.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo3_Connection {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql:///hm_javaweb?useSSL=false";
        String username="root";
        String password="SLJB0721.com";
        Connection conn = DriverManager.getConnection(url,username,password);

        String sql1 ="update emp set age=19 where id=1";
        String sql2 ="update emp set age=18 where id=2";

        Statement stmt=conn.createStatement();


        int count1=stmt.executeUpdate(sql1);
        System.out.println(count1);

        int count2=stmt.executeUpdate(sql2);
        System.out.println(count2);

        stmt.close();
        conn.close();

    }
}
