package com.example.web.api;

import com.example.common.dto.ResponseBo;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author hao
 * @Date 2019/3/22 14:11
 **/
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public User getUserById(String id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.listUser();
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public ResponseBo insertUser(User user){

        try {
            userService.insertUser(user);
            return new ResponseBo().setCode(200).setMsg("SUCCESS");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBo().setCode(500).setMsg("ERROR");
        }
    }

}
