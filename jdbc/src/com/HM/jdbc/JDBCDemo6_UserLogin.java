package com.HM.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo6_UserLogin {

    @Test
    public void testLogin() throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///test?useSSL=false";
        String username = "root";
        String password = "SLJB0721.com";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name="zhangsan";
        String pwd ="123123";

        String sql ="SELECT * FROM tb_user WHERE username='"+name+"'and password='"+pwd+"'";

        Statement stmt =conn.createStatement();

        ResultSet resultSet = stmt.executeQuery(sql);

        if (resultSet.next()){
            System.out.println("登录成功~~");
        }else {
            System.out.println("登陆失败！！！");
        }
        resultSet.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void testLogin_Inject() throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///test?useSSL=false";
        String username = "root";
        String password = "SLJB0721.com";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name="123132";
        String pwd ="'or'1'='1";

        String sql ="SELECT * FROM tb_user WHERE username='"+name+"'and password='"+pwd+"'";

        System.out.println(sql);

        Statement stmt =conn.createStatement();

        ResultSet resultSet = stmt.executeQuery(sql);

        if (resultSet.next()){
            System.out.println("登录成功~~");
        }else {
            System.out.println("登陆失败！！！");
        }
        resultSet.close();
        stmt.close();
        conn.close();
    }

}
