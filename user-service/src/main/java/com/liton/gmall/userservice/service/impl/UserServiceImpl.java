package com.liton.gmall.userservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liton.gmall.bean.UmsMember;
import com.liton.gmall.service.UserService;
import com.liton.gmall.userservice.mapper.UmsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Override
    public List<UmsMember> getAllUser() {

        List<UmsMember> umsMembers = umsMemberMapper.selectAllUser();

        return umsMembers;
    }

    @Override
    public List<UmsMember> getAllUserMapper() {

        List<UmsMember> umsMembers = umsMemberMapper.selectAll();
        return umsMembers;

    }
}
