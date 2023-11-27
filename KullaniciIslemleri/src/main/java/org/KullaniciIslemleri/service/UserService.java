package org.KullaniciIslemleri.service;

import org.KullaniciIslemleri.entity.Category;
import org.KullaniciIslemleri.entity.User;
import org.KullaniciIslemleri.repository.CategoryRepository;
import org.KullaniciIslemleri.repository.UserRepository;
import org.KullaniciIslemleri.utility.Singleton;

public class UserService {
    UserRepository userRepository = Singleton.getUserRepository();
    CategoryRepository categoryRepository = Singleton.getCategoryRepository();
    public void createUser(User user){
        if (userRepository.getUserByMail(user).getId() ==0){
            userRepository.createUser(user);
        }
        else {
            System.out.println("Böyle bir kullanıcı zaten var" + " " + user.getMail());
        }
    }

    public void updateUser(User user){
        if (userRepository.getUserByMail(user).getId()==0){
            System.out.println("Var olmayan kullanıcıyı güncelleyemezsiniz.");
        }
        else {
            userRepository.updateUser(user);
        }
    }

}
