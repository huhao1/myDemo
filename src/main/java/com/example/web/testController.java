package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName testController
 * @Description TODO
 * @Author hao
 * @Date 2019/3/22 10:50
 **/
@RestController
@RequestMapping("/test")
public class testController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Map<String, Object> hello(){

        Map<String, Object> map = new HashMap<>();
        map.put("hello","hello");

        return map;
    }

}
