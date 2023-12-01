package org.example.utility;

import org.example.repository.CategoryRepository;
import org.example.repository.UserRepository;
import org.example.service.CategoryService;
import org.example.service.UserService;

public class Singleton {
    private static CategoryService categoryService;
    private static CategoryRepository categoryRepository;
    private static UserService userService;
    private static UserRepository userRepository;

    private static  DbCommunication dbCommunication;

    public static DbCommunication getDbCommunication(){
        if(dbCommunication==null){
            return  new DbCommunication();
        }
        else {
            return dbCommunication;
        }
    }
    public static CategoryRepository getCategoryRepository(){
        if(categoryRepository==null){
            return new CategoryRepository();
        }
        else {
            return categoryRepository;
        }
    }
    public static CategoryService getCategoryService(){
        if(categoryService==null){
            return new CategoryService();
        }
        else {
            return categoryService;
        }
    }
    public static UserRepository getUserRepository(){
        if(userRepository == null){
            return new UserRepository();
        }
        else {
            return userRepository;
        }
    }

    public static UserService getUserService(){
        if(userService == null){
            return new UserService();
        }
        else {
            return userService;
        }
    }

}
