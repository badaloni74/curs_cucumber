package com.cedaniel200.app.stepdefinitions;

import java.sql.*;

public class java_jdbc {
    //private static final String url="jdbc:mysql://localhost:3306/db_infomanager?useSSL=false&characterEncoding=utf-8&serverTimezone=Hongkong";
    private static final String url="jdbc:mysql://localhost:3306/mysql";
    private static final String UserNmae="root";
    private static final String pwd="admin";

    public static void select(){

        //String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "admin";
        Statement stmt=null;
        System.out.println("Connecting database...MySql");
        ResultSet rst=null;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            stmt=connection.createStatement();
            // String sql="insert into tb_student values('2015310012',"+"'Shen Tianhua'"+","+"' '"+",25,"+"'Heilongjiang'"+",'Han' ,'AC1302')";
            //String sql="delete from tb_student where studentNo="+"'2015310012'"+";
            String sql="update sakila.actor set last_update = now()";
            //d.execute sql;
            // int count=stmt.executeUpdate(sql);//can only be use for: insert,delete,update;
            //f.resultset ;if the way you do it is select,you should use this method:  stmt.executeQuery(sql);
            stmt.execute(sql);
            stmt.execute("commit");
            stmt.executeQuery("commit");

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

//////

        Connection connection=null;





        try {
            //a.import the driver package and load the specific driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");   //load the specific driver class;
            //b.Establish a connection to the database;
            connection = DriverManager.getConnection(url,UserNmae,pwd);
            //c.send sql,execute;
            stmt=connection.createStatement();
            // String sql="insert into tb_student values('2015310012',"+"'Shen Tianhua'"+","+"' '"+",25,"+"'Heilongjiang'"+",'Han' ,'AC1302')";
            //String sql="delete from tb_student where studentNo="+"'2015310012'"+";
            String sql="select * from actor";
            //d.execute sql;
            // int count=stmt.executeUpdate(sql);//can only be use for: insert,delete,update;
            //f.resultset ;if the way you do it is select,you should use this method:  stmt.executeQuery(sql);
            rst=stmt.executeQuery(sql);
            //e.result of handing;
            while(rst.next()){
                String name= rst.getString("first_name");
                System.out.println(name);
            }
           /* if(count>0){
                System.out.println("successful!");
            }else {
                System.out.println("defeat!");
            }*/
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();;
        }
        finally {
            try {
                if(rst!=null)
                    rst.close();
                if (stmt!=null)
                    stmt.close();
                if(connection!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static  void main(String[] args){
        select();
    }
}
