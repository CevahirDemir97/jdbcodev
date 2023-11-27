package org.KullaniciIslemleri.repository;

import org.KullaniciIslemleri.entity.Category;
import org.KullaniciIslemleri.entity.User;
import org.KullaniciIslemleri.utility.DbCommunication;
import org.KullaniciIslemleri.utility.Singleton;

import javax.jws.soap.SOAPBinding;
import java.sql.*;

public class CategoryRepository {
    DbCommunication dbCommunication = Singleton.getDbCommunication();
public void createCategory(Category category){
   Connection connection = dbCommunication.getConnection();
   String createCategoryQuery = "insert into category (categoryname) values('" + category.getCategoryName() +"')";
    try {
        PreparedStatement pr = connection.prepareCall(createCategoryQuery);
        pr.executeUpdate();

    } catch (SQLException e) {
        System.out.println("sql hatası");
        e.printStackTrace();
    }
    finally {
        dbCommunication.closeConnection(connection);
    }
}

public void deleteCategory(Category category) {
    Connection connection = dbCommunication.getConnection();
    String deleteCategoryQuery = "delete from category where categoryname = ?";
    try {
        PreparedStatement pr = connection.prepareCall(deleteCategoryQuery);
        pr.setString(1,category.getCategoryName());
        pr.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Sql Kategori Silme Hatası");
        e.printStackTrace();
    }
    finally {
        dbCommunication.closeConnection(connection);
    }
}

public Category categoryByName(Category category){
    Connection connection = dbCommunication.getConnection();
    String categoryByNameQuery = "select * from category where categoryname = ?";
    try {
       // Driver.class.forName("org.postgresql.Driver");
        PreparedStatement preparedStatement = connection.prepareCall(categoryByNameQuery);
        preparedStatement.setString(1,category.getCategoryName());
        ResultSet set = preparedStatement.executeQuery();
        Category category1 = new Category();
        while (set.next()){
            int id = set.getInt("id");
            String categorynamee = set.getString("categoryname");
            category1.setId(id);
            category1.setCategoryName(categorynamee);

        }
        return category1;

    } catch (SQLException sqlException) {
        System.out.println("Sql hatası");
        sqlException.printStackTrace();
    /*} catch (ClassNotFoundException classNotFoundException) {
        System.out.println("Class hatası");
        classNotFoundException.printStackTrace();*/
    } finally {
        dbCommunication.closeConnection(connection);
    }
    return null;
}
}


