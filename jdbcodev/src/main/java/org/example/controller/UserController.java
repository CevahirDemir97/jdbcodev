package org.example.controller;

import org.example.entity.User;
import org.example.repository.CategoryRepository;
import org.example.repository.UserRepository;
import org.example.service.CategoryService;
import org.example.service.UserService;
import org.example.utility.Singleton;

public class UserController {
    CategoryService categoryService= Singleton.getCategoryService();
    UserService userService = new UserService();
    public void create(String email,String name,String surname,String password){
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        userService.create(user);
    }
    public void delete(int id,String email) {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        userService.delete(user);
    }
    public void update(String email,String name){
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            userService.update(user);
        }


}
