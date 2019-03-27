package com.example.mapper;

import com.example.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> listUser();

    User getUserById(String id);

    int insertUser(User user);

}
