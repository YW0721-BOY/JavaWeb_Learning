package com.HM.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo4_Statement {
    @Test
    public void testDML() throws Exception{
        //Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql:///hm_javaweb?useSSL=false";
        String username="root";
        String password="SLJB0721.com";
        Connection conn = DriverManager.getConnection(url,username,password);

        String sql1 ="update emp set age=30 where id=1";

        Statement stmt=conn.createStatement();


        int count1=stmt.executeUpdate(sql1);

        if (count1>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }


        stmt.close();
        conn.close();
    }

    @Test
    public void testDDL() throws Exception{
        //Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql:///hm_javaweb?useSSL=false";
        String username="root";
        String password="SLJB0721.com";
        Connection conn = DriverManager.getConnection(url,username,password);

        String sql1 ="CREATE DATABASE db2";

        Statement stmt=conn.createStatement();


        int count1=stmt.executeUpdate(sql1);

        if (count1>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }


        stmt.close();
        conn.close();
    }
}
