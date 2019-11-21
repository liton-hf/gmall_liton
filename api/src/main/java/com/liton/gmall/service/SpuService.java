package com.liton.gmall.service;

import com.liton.gmall.bean.PmsBaseSaleAttr;
import com.liton.gmall.bean.PmsProductInfo;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> selectbyCatalog3Id(String catalog3Id);

    List<PmsBaseSaleAttr> selectBaseSaleList();

    String saveSpuInfo(PmsProductInfo pmsProductInfo);
}
