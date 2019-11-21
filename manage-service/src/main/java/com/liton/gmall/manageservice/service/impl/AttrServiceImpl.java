package com.liton.gmall.manageservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liton.gmall.bean.PmsBaseAttrInfo;
import com.liton.gmall.bean.PmsBaseAttrValue;
import com.liton.gmall.manageservice.mapper.PmsBaseAttrInfoMapper;
import com.liton.gmall.manageservice.mapper.PmsBaseAttrValueMapper;
import com.liton.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class AttrServiceImpl implements AttrService {
    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {

        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);

        return pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
    }

    @Override
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);

        String attrId = pmsBaseAttrInfo.getId();

        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();

        for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {

            pmsBaseAttrValue.setAttrId(attrId);
            pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);


        }
}
}
