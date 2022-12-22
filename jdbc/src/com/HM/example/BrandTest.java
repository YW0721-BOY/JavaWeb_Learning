package com.HM.example;

import com.HM.pojo.Brand;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class BrandTest {

    @Test
    public void testSelectAll() throws Exception {
        Properties prop =new Properties();
        prop.load(new FileInputStream("F:\\HM_JAVA\\javaweb\\jdbc\\jdbcdemo\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = "select * from tb_brand";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Brand> brandList = new ArrayList<>();
        while (resultSet.next()) {
            int id= resultSet.getInt(1);
            String brandName=resultSet.getString(2);
            String companyName=resultSet.getString(3);
            String ordered=resultSet.getString(4);
            String description=resultSet.getString(5);
            Integer status = resultSet.getInt(6);

            Brand brand = new Brand(id, brandName, companyName, ordered, description, status);

            brandList.add(brand);
        }

        resultSet.close();
        pstm.close();
        conn.close();

        Iterator iterator =brandList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testAdd() throws Exception {
        Properties prop =new Properties();
        prop.load(new FileInputStream("F:\\HM_JAVA\\jdbc\\jdbcdemo\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = "INSERT INTO tb_brand(brand_name,company_name,ordered,description,status) VALUES(?,?,?,?,?)";

        String brand_name  ="苹果13";
        String company_name ="iPhone" ;
        int ordered1=300;
        String description2="改变世界";
        Integer status2=1;

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,brand_name);
        pstm.setString(2,company_name);
        pstm.setInt(3,ordered1);
        pstm.setString(4,description2);
        pstm.setInt(5,status2);


        pstm.executeUpdate();

        //testSelectAll();
        pstm.close();
        conn.close();
    }

    @Test
    public void testUpdate() throws Exception {
        Properties prop =new Properties();
        prop.load(new FileInputStream("F:\\HM_JAVA\\jdbc\\jdbcdemo\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = "UPDATE tb_brand SET ordered=150 WHERE id= ? AND brand_name =? ";

        int id =4;
        String brand_name  ="苹果13";


        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        pstm.setString(2,brand_name);
        pstm.executeUpdate();

        //testSelectAll();
        pstm.close();
        conn.close();
    }

    @Test
    public void testDelete() throws Exception {
        Properties prop =new Properties();
        prop.load(new FileInputStream("F:\\HM_JAVA\\jdbc\\jdbcdemo\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        String sql = "DELETE FROM tb_brand WHERE id= ? AND brand_name =? ";

        int id =4;
        String brand_name  ="苹果13";


        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        pstm.setString(2,brand_name);
        pstm.executeUpdate();

        //testSelectAll();
        pstm.close();
        conn.close();
    }
}
