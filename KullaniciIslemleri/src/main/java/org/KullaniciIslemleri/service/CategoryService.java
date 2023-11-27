package org.KullaniciIslemleri.service;

import org.KullaniciIslemleri.entity.Category;
import org.KullaniciIslemleri.entity.User;
import org.KullaniciIslemleri.repository.CategoryRepository;
import org.KullaniciIslemleri.repository.UserRepository;
import org.KullaniciIslemleri.utility.Singleton;

public class CategoryService {
    CategoryRepository categoryRepository = Singleton.getCategoryRepository();
    UserRepository userRepository =Singleton.getUserRepository();
    public void createCategory(Category category, User user){
        if(userRepository.getUserByMail(user).getId() == 0){
            System.out.println("Bu mail adresine ait kullanıcı olmadığı için kategori yaratılamaz.");
        }
        else {
            if(categoryRepository.categoryByName(category).getId() == 0) {
                categoryRepository.createCategory(category);
            }
            else {
                System.out.println("Bu kategori zaten mevcut" + " " + category.getCategoryName());
            }
        }
    }

    public void deleteCategory(Category category,User user){
        if(userRepository.getUserByMail(user).getId() == 0){
            System.out.println("Böyle bir Kullanıcı olmadığı için kategoriyi silemezsiniz");
        }
        else {
            if (categoryRepository.categoryByName(category).getId() == 0) {
                System.out.println("Varolmayan kategoriyi silemezsiniz.");
            }
            else {
                categoryRepository.deleteCategory(category);
            }
        }
    }


}
