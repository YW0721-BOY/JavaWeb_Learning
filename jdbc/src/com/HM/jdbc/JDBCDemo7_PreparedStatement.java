package com.HM.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCDemo7_PreparedStatement {

    @Test
    public void testPrepareStatement() throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///test?useSSL=false";
        String username = "root";
        String password = "SLJB0721.com";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name="zhangsan";
        String pwd ="123123";

        String sql ="SELECT * FROM tb_USER WHERE username = ? AND password =?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        ResultSet resultSet = pstmt.executeQuery();



//        String sql ="SELECT * FROM tb_user WHERE username='"+name+"'and password='"+pwd+"'";
//
//        Statement stmt =conn.createStatement();
//
//        ResultSet resultSet = stmt.executeQuery(sql);
//
        if (resultSet.next()){
            System.out.println("登录成功~~");
        }else {
            System.out.println("登陆失败！！！");
        }
        resultSet.close();
        pstmt.close();
        conn.close();
    }

    @Test
    public void testLogin_Inject() throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///test?useSSL=false";
        String username = "root";
        String password = "SLJB0721.com";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name="zhangsan";
        String pwd ="'or'1'='1";

        String sql ="SELECT * FROM tb_USER WHERE username = ? AND password =?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        System.out.println(pstmt.toString());
        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()){
            System.out.println("登录成功~~");
        }else {
            System.out.println("登陆失败！！！");
        }
        resultSet.close();
        pstmt.close();
        conn.close();
    }

    @Test
    public void testPrepareStatement2() throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///test?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "SLJB0721.com";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name="zhangsan";
        String pwd ="123123";

        String sql ="SELECT * FROM tb_USER WHERE username = ? AND password =?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        ResultSet resultSet = pstmt.executeQuery();

        if (resultSet.next()){
            System.out.println("登录成功~~");
        }else {
            System.out.println("登陆失败！！！");
        }
        resultSet.close();
        pstmt.close();
        conn.close();
    }
}
