package org.example.실습.실습1;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class TaskDao {

    private String u_sql = "jdbc:mysql://localhost:3306/springweb2";
    private String u_name = "root";
    private String u_pass = "1234";
    public Connection conn;

    public TaskDao() { connect(); }

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(u_sql, u_name, u_pass);
            System.out.println("TaskDao.connect");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    // 30초
    public int task11() {
        try{
            String sql = "update products set stock_quantity = stock_quantity - 3 ";
            PreparedStatement ps = conn.prepareStatement(sql);
            int asd = ps.executeUpdate();
            return asd;
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

    // 1분
    public String task22() {
        try{
            String sql = "select * from products ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String product_name = rs.getString("product_name");
                int stock_quantity = rs.getInt("stock_quantity");
                System.out.println(product_name + "\n" + stock_quantity);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // 5분
    public int task33() {
        try{
            String sql = "update products set stock_quantity = stock_quantity + 20 where stock_quantity <= 10 ";
            PreparedStatement ps = conn.prepareStatement(sql);
            int rs = ps.executeUpdate();
            return rs;
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }


}
