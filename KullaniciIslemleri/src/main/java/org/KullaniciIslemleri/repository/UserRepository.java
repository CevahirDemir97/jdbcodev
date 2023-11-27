package org.KullaniciIslemleri.repository;

import org.KullaniciIslemleri.entity.User;
import org.KullaniciIslemleri.utility.DbCommunication;
import org.KullaniciIslemleri.utility.Singleton;

import java.sql.*;

public class UserRepository {
    DbCommunication dbCommunication = Singleton.getDbCommunication();
    public void createUser(User user){
        Connection connection = dbCommunication.getConnection();
        String createUserQuery = "insert into kullanıcı (name,surname,mail,password) values(?,?,?,?)";
        try {
            PreparedStatement pr = connection.prepareCall(createUserQuery);
            pr.setString(1,user.getName());
            pr.setString(2,user.getSurname());
            pr.setString(3,user.getMail());
            pr.setString(4,user.getPassword());
            pr.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql kullanıcı oluşturma hatası");
            e.printStackTrace();
        }
        finally {
            dbCommunication.closeConnection(connection);
        }
    }

    public void updateUser(User user){
        Connection connection = dbCommunication.getConnection();
        String updateUserQuery = "update kullanıcı set name = ?,surname = ?,password = ? where mail = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(updateUserQuery);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getMail());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Güncelleme hatası");
            sqlException.printStackTrace();
        }
        finally {
            dbCommunication.closeConnection(connection);
        }
    }

    public User getUserByMail(User user){
    Connection connection = dbCommunication.getConnection();
    String usernameQuery = "select * from kullanıcı where mail = '"+ user.getMail() + "'";
        try {
            Driver.class.forName("org.postgresql.Driver");
            PreparedStatement pr = connection.prepareCall(usernameQuery);
            ResultSet set = pr.executeQuery();
            User user1 = new User();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String surname = set.getString("surname");
                String mail1 = set.getString("mail");
                String password = set.getString("password");
                user1.setId(id);
                user1.setName(name);
                user1.setSurname(surname);
                user1.setMail(mail1);
                user1.setPassword(password);
            }
        return user1;
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Class bulunamadı hatası");
            classNotFoundException.printStackTrace();
        } catch (SQLException sqlException) {
            System.out.println("Sql hatası");
            sqlException.printStackTrace();
        }
        finally {
            dbCommunication.closeConnection(connection);
        }
        return null;
    }
}
