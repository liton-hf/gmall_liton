package com.liton.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liton.gmall.service.UserService;
import com.liton.gmall.bean.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Reference
    UserService userService;

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMemberList = userService.getAllUser();
        return umsMemberList;
    }

    @RequestMapping("getAllUserMapper")
    @ResponseBody
    public List<UmsMember> getAllUserMapper(){
        List<UmsMember> umsMemberList = userService.getAllUserMapper();
        return umsMemberList;
    }



}
