package id.co.bankmandiri.customer.utils;
import java.io.IOException;
import java.io.InputStream;
import  java.util.Properties;
import javax.swing.*;
import java.sql.*;

public class DatabaseConnection {
    private static Connection connection;
    private static Properties properties;


    public static Connection getConnection(){
        if(connection==null){
            try {
                connection = DriverManager.getConnection(
                        getProperties("url"),
                        getProperties("uname"),
                        getProperties("passwd")

                        );
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"gagal koneksi");
            }
        }
        return connection;
    }
    public static String getProperties(String key){
        if(properties != null){
            return properties.getProperty(key);
        }else {
            properties = new Properties();
            InputStream inputStream = DatabaseConnection.class.getClassLoader()
                    .getResourceAsStream("databaseProperties");
            try{
                properties.load(inputStream);
                return properties.getProperty(key);
            }catch (IOException e){
                System.out.println(e);
                return null;
            }
        }
    }

}
