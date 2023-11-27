package org.KullaniciIslemleri.controller;

import org.KullaniciIslemleri.entity.User;
import org.KullaniciIslemleri.service.UserService;

import javax.jws.soap.SOAPBinding;

public class UserController {
UserService userService = new UserService();
public void createUser(User user){

userService.createUser(user);

}
public void updateUser(User user){

    userService.updateUser(user);

}
}
