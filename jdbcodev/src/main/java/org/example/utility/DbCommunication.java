package org.example.utility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCommunication {
    public Connection getConnection(){
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/deneme";
        String username = "postgres";
        String password = "1234";
        try {
            Driver.class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,username,password);
            return connection;
            } catch (SQLException sqlException) {
                System.out.println("sql hatası");
                sqlException.printStackTrace();
            }
         catch (ClassNotFoundException classNotFoundException) {
            System.out.println("class hatası");
            classNotFoundException.printStackTrace();

        }
        return connection;

    }
    public boolean closeConnection(Connection connection){
        try {
            connection.close();
            return true;
        } catch (SQLException sqlException) {
            System.out.println("sql hatası");
            sqlException.printStackTrace();
        }
        return false;

    }
}
