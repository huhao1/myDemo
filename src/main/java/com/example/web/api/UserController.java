package com.example.web.api;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.response.ResponseVo;
import com.example.domain.User;
import com.example.domain.vo.UserVo;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hao
 * @since 2019-03-27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "getUserList")
    public ResponseVo getUserList(UserVo userVo){

        List<User> userList = userService.getUserList(userVo);

        return new ResponseVo().setCode(200).setData(userList).setMsg("SUCCESS");
    }

    @GetMapping(value = "getUserPage")
    public ResponseVo getUserPage(UserVo userVo){

        IPage<User> userList = userService.getUserPage(userVo);

        return new ResponseVo().setCode(200).setData(userList).setMsg("SUCCESS");
    }

}

