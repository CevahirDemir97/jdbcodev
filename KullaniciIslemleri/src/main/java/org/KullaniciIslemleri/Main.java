package org.KullaniciIslemleri;

import org.KullaniciIslemleri.controller.CategoryController;
import org.KullaniciIslemleri.controller.UserController;
import org.KullaniciIslemleri.entity.Category;
import org.KullaniciIslemleri.entity.User;
import org.KullaniciIslemleri.repository.CategoryRepository;
import org.KullaniciIslemleri.repository.UserRepository;
import org.KullaniciIslemleri.service.CategoryService;
import org.KullaniciIslemleri.service.UserService;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

 /*   User user = new User();

        user.setName("Cevahir");
        user.setSurname("Demir");
        user.setMail("cevahir-97@hotmail.com");
        user.setPassword("1234");
        UserRepository userRepository = new UserRepository();
        userRepository.createUser(user);*/
   /*     Category category = new Category();
        category.setCategoryName("Beyaz Eşya");
        CategoryRepository categoryRepository=new CategoryRepository();
        categoryRepository.createCategory(category);
        CategoryRepository categoryRepository = new CategoryRepository();
        categoryRepository.deleteCategory(category);*/

/*        User user = new User();
        user.setName("Cevahir");
        user.setSurname("Demir");
        user.setMail("ce@hotmail.com");
        UserRepository userRepository = new UserRepository();
        userRepository.updateUser(user);*/
     /*   UserService userService = new UserService();
        User user = new User();
        user.setMail("cihan123@hotmail.com");
        user.setName("cihan");
        user.setSurname("demirci");
        user.setPassword("12345");
        userService.createUser(user);
        Category category = new Category();
        category.setCategoryName("elektronik");
        CategoryService categoryService = new CategoryService();*/
        //categoryService.createCategory(category,user);
        //userService.updateUser(user);
        //categoryService.deleteCategory(category,user);
        Category category = new Category();


        User user = User.userBuilder.startBuilder().
                name("ata").
                surname("patlar").
                mail("atapatlar@gmail.com").
                password("1234665").
                build();
        category.setCategoryName("Beyaz Eşya");
        CategoryController categoryController = new CategoryController();
        UserController userController = new UserController();
        //categoryController.createCategory(category,user);
      // categoryController.deleteCategory(category,user);
        //userController.createUser(user);
        userController.updateUser(user);


        }
    }
