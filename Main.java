package com.company;

import org.jetbrains.annotations.Contract;
//import org.jsoup.*;
import java.io.*;
import java.sql.*;
import java.util.Random;
import java.util.Date;


public class Main {

    private Connection connect = null;
    private Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public static void main(String[] args) throws Exception{

//        Random dice = new Random();
//
//
//        String the_output = String.valueOf(dice.nextInt());
//        System.out.println(the_output.charAt(0) + " : " + the_output);
//        StringBuilder sb = new StringBuilder(the_output);
//
//        if(the_output.charAt(0) ==  '-'){
//
//            sb.delete(0,1);
//            System.out.println("Deleted");
//        }
//
//        System.out.println(sb.toString());

//         getConnection();
         getUsers();
//            System.out.println(forFunc(3));
    }

    public static Connection getConnection() throws Exception{
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;
        } catch(Exception e){
            System.out.println(e);

        }
        return null;
    }

    public static void getUsers() throws Exception{
        try {
            Connection con = getConnection();
            preparedStatement = con.prepareStatement("SELECT id, name, family_name from test.users");
            ResultSet resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);
        } catch(Exception e){
            System.out.println(e);
        }
    }

    private static void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String familyName = resultSet.getString("family_name");
            System.out.println("UserID: " + id);
            System.out.println("User: " + name);
            System.out.println("Website: " + familyName);

        }
    }


    public static String  switFunc(int x) {

        switch (x) {
            case 19:
                return "the value is 19";
            case 18:
                return "the value is 18";
            case 10:
                return "the value is 10";
            case 1:
                return "the value is 1";
            default:
                return "the value is unknown";
        }
    }

    public static String forFunc(int arr){


        return  "" + arr;

    }



    public static boolean isInteger(Object object) {
        if(object instanceof Integer) {
            return true;
        } else {
            String string = object.toString();

            try {
                Integer.parseInt(string);
            } catch(Exception e) {
                return false;
            }
        }

        return true;
    }
}
