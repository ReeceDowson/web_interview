package com.example.demo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.facade.model.UserDO;
import com.example.demo.facade.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类描述
 *
 * @author zhangrihui
 * @date 2019/9/13 22:50:00
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private IUserService userService;

    @GetMapping("/findById/{id}")
    public UserDO findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/listUser")
    public List<UserDO> listUser(){
        return userService.listUser();
    }
}
