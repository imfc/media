package com.imfc.media.cas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MediaCasWebApplicationTests {

    @Test
    public void contextLoads() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/uum";
        String name = "root";
        String password = "root";

        //1.加载数据库驱动
        Class.forName(driver);
        //2.获取连接
        Connection connection = DriverManager.getConnection(url, name, password);
        //3.创建操作对象
        Statement statement = connection.createStatement();
        //4.定义sql
        String sql = "select * from pm_t_user where USER_ID=?";
        PreparedStatement pst = connection.prepareStatement(sql);
        //5.执行sql
        pst.setNString(1,"12540");
        final ResultSet rs = pst.executeQuery();
//        ResultSet rs = statement.executeQuery(sql);
        //6.处理结果
        while(rs.next()){
            System.out.println("id:"+rs.getString("USER_ID")+"....name:"+rs.getString("USER_NAME"));
        }
        rs.close();
        statement.close();
        connection.close();
    }

}
