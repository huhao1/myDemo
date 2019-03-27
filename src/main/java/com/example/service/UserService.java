package com.example.service;

import com.example.domain.User;

import java.util.List;

public interface UserService {

    List<User> listUser();

    User getUserById(String id);

    int insertUser(User user) throws Exception;

}
