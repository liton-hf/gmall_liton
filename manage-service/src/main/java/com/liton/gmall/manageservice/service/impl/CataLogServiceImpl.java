package com.liton.gmall.manageservice.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.liton.gmall.bean.PmsBaseCatalog1;
import com.liton.gmall.bean.PmsBaseCatalog2;
import com.liton.gmall.bean.PmsBaseCatalog3;
import com.liton.gmall.manageservice.mapper.CataLog1Mapper;
import com.liton.gmall.manageservice.mapper.CataLog2Mapper;
import com.liton.gmall.manageservice.mapper.CataLog3Mapper;
import com.liton.gmall.service.CataLogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CataLogServiceImpl implements CataLogService {


    @Autowired
    CataLog1Mapper cataLog1Mapper;

    @Autowired
    CataLog2Mapper cataLog2Mapper;

    @Autowired
    CataLog3Mapper cataLog3Mapper;

    @Override
    public List<PmsBaseCatalog1> selectAllCatalog1() {
        return cataLog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> selectCatalog2ById(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);

        return cataLog2Mapper.select(pmsBaseCatalog2);
    }

    @Override
    public List<PmsBaseCatalog3> selectCatalog3ById(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);

        return cataLog3Mapper.select(pmsBaseCatalog3);
    }


}
