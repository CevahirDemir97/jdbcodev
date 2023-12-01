package org.example.repository;

import org.example.entity.Category;
import org.example.entity.User;
import org.example.utility.DbCommunication;
import org.example.utility.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IBaseRepository<User> {
    DbCommunication dbCommunication = Singleton.getDbCommunication();
    @Override
    public void create(User user) {
        String createQuery =
                "insert into userr(email,name,surname,password) values (?,?,?,?)";
        Connection connection =dbCommunication.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareCall(createQuery);
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getSurname());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("sql hatası");
            sqlException.printStackTrace();
        }
        finally {
            dbCommunication.closeConnection(connection);
        }

    }

   /* @Override
    public List<User> getAll(User user) {
        Connection connection  = dbCommunication.getConnection();
        String ListQuery = "select * from userr";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(ListQuery);
            ResultSet set = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String surname = set.getString("surname");
                String email = set.getString("email");
                String password = set.getString("password");
                User user1 = new User();
                user1.setId(id);
                user1.setName(name);
                user1.setSurname(surname);
                user1.setEmail(email);
                user1.setPassword(password);
                users.add(user1);
            }
            return  users;

        } catch (SQLException sqlException) {
            System.out.println("sql hatası");
            sqlException.printStackTrace();
        }
        finally {
            dbCommunication.closeConnection(connection);
        }
        return null;
    }*/

    @Override
    public void delete(User user) {
        Connection connection = dbCommunication.getConnection();
        String deleteQuery = "delete from userr where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(deleteQuery);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("sql hatası");
            sqlException.printStackTrace();
        }
        finally {
            dbCommunication.closeConnection(connection);
        }
    }

    @Override
    public void update(User user) {

        Connection connection = dbCommunication.getConnection();
        String updateQuery = "update userr set name = ? where email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(updateQuery);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("sql hatası");
            sqlException.printStackTrace();
        }
        finally {
            dbCommunication.closeConnection(connection);
        }

    }

    @Override
    public User getByName(String email) {
        String categoryByNameQuery = "select * from userr where name  = '"+email+"'";
        Connection connection  = dbCommunication.getConnection();
        try {
            Driver.class.forName("org.postgresql.Driver");
            PreparedStatement preparedStatement = connection.prepareCall(categoryByNameQuery);
            ResultSet set = preparedStatement.executeQuery();
            User user = new User();
            while(set.next()){
                int id = set.getInt("id");
                String username = set.getString("name");
                String surname = set.getString("surname");
                String mail = set.getString("email");
                String password = set.getString("password");

                user.setId(id);
                user.setName(username);
                user.setSurname(surname);
                user.setEmail(mail);
                user.setPassword(password);

            }
            return user;
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("class hatası");
            classNotFoundException.printStackTrace();
        } catch (SQLException sqlException) {
            System.out.println("sql hatası");
            sqlException.printStackTrace();
        }
        finally {
            dbCommunication.closeConnection(connection);

        }
        return null;

    }
    }

