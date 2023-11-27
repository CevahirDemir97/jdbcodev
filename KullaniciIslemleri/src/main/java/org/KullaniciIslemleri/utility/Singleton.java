package org.KullaniciIslemleri.utility;

import org.KullaniciIslemleri.controller.CategoryController;
import org.KullaniciIslemleri.controller.UserController;
import org.KullaniciIslemleri.repository.CategoryRepository;
import org.KullaniciIslemleri.repository.UserRepository;
import org.KullaniciIslemleri.service.CategoryService;
import org.KullaniciIslemleri.service.UserService;

public class Singleton {

    public static DbCommunication dbCommunication = null;
    public static CategoryRepository categoryRepository= null;
    public static UserRepository userRepository = null;
    public static CategoryService categoryService = null;
    public static UserService userService = null;
    public static UserController userController = null;
    public static CategoryController categoryController = null;

    public static DbCommunication getDbCommunication(){
        if (dbCommunication == null){
            dbCommunication = new DbCommunication();
            return dbCommunication;
        }
        return dbCommunication;
    }
    public static CategoryRepository getCategoryRepository(){
        if (categoryRepository == null){
            categoryRepository = new CategoryRepository();
            return categoryRepository;
        }
        return categoryRepository;
    }
    public static UserRepository  getUserRepository(){
        if (userRepository == null){
            userRepository = new UserRepository();
            return userRepository;
        }
        return userRepository;
    }
    public static CategoryService getCategoryService(){
        if (categoryService== null){
            categoryService = new CategoryService();
            return categoryService;
        }
        return categoryService;
    }
    public static UserService getUserService(){
        if (userService == null){
            userService = new UserService();
            return userService;
        }
        return userService;
    }
    public static UserController getUserController(){
        if (userController == null){
            userController = new UserController();
            return userController;
        }
        return userController;
    }
    public static CategoryController getCategoryController(){
        if (categoryController == null){
            categoryController = new CategoryController();
            return categoryController;
        }
        return categoryController;
    }








}
