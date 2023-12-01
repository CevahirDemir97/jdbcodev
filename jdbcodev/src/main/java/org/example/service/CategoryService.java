package org.example.service;

import org.example.entity.Category;
import org.example.entity.User;
import org.example.repository.CategoryRepository;
import org.example.repository.IBaseRepository;
import org.example.repository.UserRepository;
import org.example.utility.Singleton;

public class CategoryService {
    IBaseRepository<Category> categoryIBaseRepository;
    IBaseRepository<User> userIBaseRepository;
    CategoryRepository categoryRepository = Singleton.getCategoryRepository();

    UserRepository userRepository = Singleton.getUserRepository();

    public CategoryService() {
        this.categoryIBaseRepository = Singleton.getCategoryRepository();


    }

    public void create(Category category,User user) {

        if (categoryIBaseRepository.getByName(category.getName()).getId() != 0) {
            System.out.println("Var olan kategori yaratılamaz." + category.getName());
        } else {
            if (userIBaseRepository.getByName(user.getEmail()).getId() == 0) {
                System.out.println("Bu mail adresiyle herhangi bir kullanıcı aktif olmadığı için kategori yaratılamaz." + user.getEmail());

            } else {
                categoryIBaseRepository.create(category);
            }
        }
    }

    public void delete(Category category,User user){


            if (categoryIBaseRepository.getByName(category.getName()).getId() != 0) {
                if (userIBaseRepository.getByName(user.getEmail()).getId() != 0){
                        categoryIBaseRepository.delete(category);
                }
                else {
                    System.out.println("Var olmayan kullanıcı silemez");
                }
            }
            else {
                System.out.println("Var olmayan kategori silinemez");
            }
        }


    public void update(Category category,User user){

        if (categoryIBaseRepository.getByName(category.getName()).getId() != 0) {
            if (userIBaseRepository.getByName(user.getEmail()).getId() != 0){
                categoryIBaseRepository.update(category);
            }
            else {
                System.out.println("Var olmayan kullanıcı günceleyemez");
            }
        }
        else {
            System.out.println("Var olmayan kategori güncellenemez");
        }
    }
    }

