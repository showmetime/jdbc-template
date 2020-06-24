package com.ali.gmmp.controller;

import com.ali.gmmp.entity.User;
import com.ali.gmmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: ASUS
 * @description: TODO
 * @Date: 22:48 2020/6/24
 */
@RequestMapping("test")
@Controller
public class TestController {

    @Autowired
    private UserService userService;
    @RequestMapping("/haha")
    public void updateAll(){
        List<User> all = userService.findAll();
        userService.updateALL(all);
    }

}
