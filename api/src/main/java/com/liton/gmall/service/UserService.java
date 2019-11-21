package com.liton.gmall.service;

import com.liton.gmall.bean.UmsMember;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMember> getAllUserMapper();
}
