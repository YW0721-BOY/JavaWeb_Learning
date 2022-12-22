package com.HM.jdbc;

import com.HM.pojo.Emp;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class JDBCDemo5_ResultSet {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql:///hm_javaweb?useSSL=false";
        String username="root";
        String password="SLJB0721.com";
        Connection conn = DriverManager.getConnection(url,username,password);

        String sql ="SELECT * FROM emp";

        Statement stmt=conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("id--name--age");
//        while(rs.next()){
//            int rsInt = rs.getInt(1);
//            String rsString = rs.getString(2);
//            double rsDouble = rs.getDouble(3);
//
//            System.out.println(rsInt+"  "+rsString+"  "+rsDouble);
//        }

        while(rs.next()){
            int rsInt = rs.getInt("id");
            String rsString = rs.getString("name");
            double rsDouble = rs.getDouble("age");

            System.out.println(rsInt+"  "+rsString+"  "+rsDouble);
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void testResult() throws Exception{
        //Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql:///hm_javaweb?useSSL=false";
        String username="root";
        String password="SLJB0721.com";
        Connection conn = DriverManager.getConnection(url,username,password);

        String sql ="SELECT * FROM emp";

        Statement stmt=conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("id--name--age");
//        while(rs.next()){
//            int rsInt = rs.getInt(1);
//            String rsString = rs.getString(2);
//            double rsDouble = rs.getDouble(3);
//
//            System.out.println(rsInt+"  "+rsString+"  "+rsDouble);
//        }

        ArrayList<Emp> empArrayList =new ArrayList<>();
        while(rs.next()){
            int rsInt = rs.getInt("id");
            String rsString = rs.getString("name");
            double rsDouble = rs.getDouble("age");

            Emp emp=new Emp(rsInt,rsString,rsDouble);
            empArrayList.add(emp);
        }

        Iterator iterator =empArrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
