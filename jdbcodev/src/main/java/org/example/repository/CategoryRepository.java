package org.example.repository;

import org.example.entity.Category;
import org.example.utility.DbCommunication;
import org.example.utility.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements IBaseRepository<Category> {

    DbCommunication dbCommunication = Singleton.getDbCommunication();

    @Override
    public void create(Category category) {
        String createQuery =
                "insert into category(name) values (?)";
        Connection connection = dbCommunication.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareCall(createQuery);
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("sql hatası");
            sqlException.printStackTrace();
        } finally {
            dbCommunication.closeConnection(connection);
        }


    }

   /* @Override
    public List<Category> getAll(Category category) {
        Connection connection = dbCommunication.getConnection();
        String ListQuery = "select * from category";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(ListQuery);
            ResultSet set = preparedStatement.executeQuery();
            List<Category> categories = new ArrayList<>();
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                Category category1 = new Category();
                category1.setId(id);
                category1.setName(name);
                categories.add(category1);
            }
            return categories;

        } catch (SQLException sqlException) {
            System.out.println("sql hatası");
            sqlException.printStackTrace();
        } finally {
            dbCommunication.closeConnection(connection);
        }
        return null;
    }
*/
    @Override
    public void delete(Category category) {
        Connection connection = dbCommunication.getConnection();
        String deleteQuery = "delete from category where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(deleteQuery);
            preparedStatement.setInt(1,category.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("sql hatası");
            sqlException.printStackTrace();
        } finally {
            dbCommunication.closeConnection(connection);
        }
    }

    @Override
    public void update(Category category) {
        Connection connection = dbCommunication.getConnection();
        String updateQuery = "update category set name = ? where id = ";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(updateQuery);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2,category.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("sql hatası");
            sqlException.printStackTrace();
        } finally {
            dbCommunication.closeConnection(connection);
        }

    }

    @Override
    public Category getByName(String name) {
        String categoryByNameQuery = "select * from category where name  = '"+name+"'";
        Connection connection  = dbCommunication.getConnection();
        try {
            Driver.class.forName("org.postgresql.Driver");
            PreparedStatement preparedStatement = connection.prepareCall(categoryByNameQuery);
            ResultSet set = preparedStatement.executeQuery();
            Category category = new Category();
            while(set.next()){
                int id = set.getInt("id");
                String categoryname = set.getString("name");
                category.setId(id);
                category.setName(categoryname);
            }
            return category;
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







