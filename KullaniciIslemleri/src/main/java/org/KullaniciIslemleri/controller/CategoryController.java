package org.KullaniciIslemleri.controller;

import org.KullaniciIslemleri.entity.Category;
import org.KullaniciIslemleri.entity.User;
import org.KullaniciIslemleri.service.CategoryService;
import org.KullaniciIslemleri.utility.Singleton;

public class CategoryController
{
    CategoryService categoryService = Singleton.getCategoryService();
    public void createCategory(Category category,User user){

        categoryService.createCategory(category,user);

    }
    public void deleteCategory(Category category,User user){
        categoryService.deleteCategory(category,user);
    }

}
