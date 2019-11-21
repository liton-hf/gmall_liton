package com.liton.gmall.user.service.impl;

import com.liton.gmall.bean.UmsMember;
import com.liton.gmall.service.UserService;
import com.liton.gmall.user.mapper.UmsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
