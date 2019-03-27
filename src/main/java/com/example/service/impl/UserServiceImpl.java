package com.example.service.impl;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author hao
 * @Date 2019/3/22 14:10
 **/
@CacheConfig(cacheNames = "UserCache")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static int num = 1;

    @Cacheable
    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Cacheable
    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @CacheEvict(value = {"UserCache"}, allEntries = true)
    @Override
    public int insertUser(User user) throws Exception{
        return userMapper.insertUser(user);
    }

}
