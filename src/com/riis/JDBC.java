package com.riis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

public class JDBC {

    public static Connection connect(String url){
        try (Connection connection = DriverManager.getConnection(url);) {
            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   public static int newUser(String u,String f, String l, String email, int id, int roleID, String p ){
        try{
            Connection connection = DriverManager.getConnection(u);
            Statement stmt = connection.createStatement();
            String q="USE PaidTimeOff INSERT INTO EMPLOYEES VALUES ('"+f+"', '"+l+"', '"+email+"', '"+roleID+"', '"+p+"');";
            System.out.println(q);
            stmt.execute(q);

        }
       catch(Exception e) {
           e.printStackTrace();
           return -1;
       }return 0;

   }
    public static int CreateRequest(String u,String ds, String de, int eid){
    Date dayS=Date.valueOf(ds);
    Date dayE=Date.valueOf(de);
    //status 2 is pending
        try{
            Connection connection = DriverManager.getConnection(u);
            Statement stmt = connection.createStatement();
            String q="USE PaidTimeOff INSERT INTO Requests VALUES ('"+eid+"', '"+ds+"', '"+de+"',2);";
            System.out.println(q);
            stmt.execute(q);

            return 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        return -1;}
    }
    public static int getEmployeeId(String u, String s){
        try{
            Connection connection = DriverManager.getConnection(u);
            Statement stmt = connection.createStatement();
            String q="USE PaidTimeOff SELECT id from Employees Where email='"+s+"';";
            ResultSet rs=stmt.executeQuery(q);
            rs.next();
            return rs.getInt("id");
        }
        catch(Exception e) {
            e.printStackTrace();
            return -1;}
    }
}
