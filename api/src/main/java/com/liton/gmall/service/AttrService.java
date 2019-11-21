package com.liton.gmall.service;

import com.liton.gmall.bean.PmsBaseAttrInfo;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);
    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

}
