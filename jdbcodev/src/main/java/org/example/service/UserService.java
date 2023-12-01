package org.example.service;

import org.example.entity.Category;
import org.example.entity.User;
import org.example.repository.CategoryRepository;
import org.example.repository.IBaseRepository;
import org.example.repository.UserRepository;
import org.example.utility.Singleton;

public class UserService {
    IBaseRepository<User> userIBaseRepository;
    CategoryRepository categoryRepository = Singleton.getCategoryRepository();

    UserRepository userRepository = Singleton.getUserRepository();


    public void create(User user){
        if (userRepository.getByName(user.getEmail()).getId() !=0 ){
            userRepository.create(user);
        }
        else {
            System.out.println("Var olmayan kullanıcı ekleme işlemi yapamaz");
        }
    }
    public void delete(User user) {

        if (userRepository.getByName(user.getEmail()).getId() !=0 ){
            userRepository.delete(user);
        }
        else {
            System.out.println("Var olmayan kullanıcı silme işlemi yapamaz");
        }

    }
    public void update(User user){
        if (userRepository.getByName(user.getEmail()).getId() !=0 ){
            userRepository.update(user);
        }
        else {
            System.out.println("Var olmayan kullanıcı güncelleme işlemi yapamaz");
        }
    }
}
