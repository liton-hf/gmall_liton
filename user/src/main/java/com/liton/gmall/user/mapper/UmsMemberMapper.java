package com.liton.gmall.user.mapper;

import com.liton.gmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UmsMemberMapper extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
