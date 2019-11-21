package com.liton.gmall.manageservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liton.gmall.bean.*;
import com.liton.gmall.manageservice.mapper.*;
import com.liton.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> selectbyCatalog3Id(String catalog3Id) {

        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);

        return pmsProductInfoMapper.select(pmsProductInfo);
    }

    @Override
    public List<PmsBaseSaleAttr> selectBaseSaleList() {

        List<PmsBaseSaleAttr> baseSaleAttrList = pmsBaseSaleAttrMapper.selectAll();
        return baseSaleAttrList;
    }

    @Override
    public String saveSpuInfo(PmsProductInfo pmsProductInfo) {
        String productId = pmsProductInfo.getId();
        if (StringUtils.isEmpty(productId)) {
            pmsProductInfoMapper.insertSelective(pmsProductInfo);
            productId = pmsProductInfo.getId();
            if (!StringUtils.isEmpty(productId)) {
                for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductInfo.getSpuSaleAttrList()) {
                    pmsProductSaleAttr.setProductId(productId);
                    pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);
                    for (PmsProductSaleAttrValue pmsProductSaleAttrValue : pmsProductSaleAttr.getSpuSaleAttrValueList()) {
                        pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
                    }
                }
                for (PmsProductImage pmsProductImage : pmsProductInfo.getSpuImageList()) {
                    pmsProductImage.setProductId(productId);
                    pmsProductImageMapper.insertSelective(pmsProductImage);
                }
            }

        } else {
            pmsProductInfoMapper.updateByPrimaryKeySelective(pmsProductInfo);

            PmsProductSaleAttr delPmsProductSaleAttr = new PmsProductSaleAttr();
            delPmsProductSaleAttr.setProductId(productId);
            pmsProductSaleAttrMapper.deleteByExample(delPmsProductSaleAttr);
            for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductInfo.getSpuSaleAttrList()) {
                pmsProductSaleAttr.setProductId(productId);
                pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);
            }
            PmsProductImage DelPmsProductImage = new PmsProductImage();
            DelPmsProductImage.setProductId(productId);
            pmsProductImageMapper.deleteByExample(DelPmsProductImage);
            for (PmsProductImage pmsProductImage : pmsProductInfo.getSpuImageList()) {
                pmsProductImage.setProductId(productId);
                pmsProductImageMapper.insertSelective(pmsProductImage);
            }
        }

        return "success";
    }


}
