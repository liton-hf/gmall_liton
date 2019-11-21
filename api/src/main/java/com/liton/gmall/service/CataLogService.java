package com.liton.gmall.service;

import com.liton.gmall.bean.PmsBaseCatalog1;
import com.liton.gmall.bean.PmsBaseCatalog2;
import com.liton.gmall.bean.PmsBaseCatalog3;

import java.util.List;

public interface CataLogService {

    List<PmsBaseCatalog1> selectAllCatalog1();

    List<PmsBaseCatalog2> selectCatalog2ById(String catalog1Id);

    List<PmsBaseCatalog3> selectCatalog3ById(String catalog2Id);
}
