package org.example.controller;

import org.example.entity.Category;
import org.example.entity.User;
import org.example.service.CategoryService;
import org.example.utility.Singleton;

public class CategoryController {


    CategoryService categoryService= Singleton.getCategoryService();

    public void createCategory(String categoryName,String email){
        Category category= new Category();
        User user = new User();
        category.setName(categoryName);
        user.setEmail(email);
        categoryService.create(category,user);

    }

    public void delete(int id,String categoryname,String email){
        Category category1= new Category();
        User user1 = new User();
        category1.setId(id);
        category1.setName(categoryname);
        user1.setEmail(email);

        categoryService.delete(category1,user1);

    }


    public void update(int id,String categoryname,String email){
        Category category2= new Category();
        User user2 = new User();
        category2.setId(id);
        category2.setName(categoryname);
        user2.setEmail(email);
        categoryService.update(category2,user2);
    }

}
