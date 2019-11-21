package com.liton.gmall.manageweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liton.gmall.bean.PmsBaseCatalog2;
import com.liton.gmall.bean.PmsBaseCatalog3;
import com.liton.gmall.service.CataLogService;
import com.liton.gmall.bean.PmsBaseCatalog1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class CatalogController {
    @Reference
    CataLogService cataLogService;

    @RequestMapping("/getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
        System.out.print(cataLogService);
        List<PmsBaseCatalog1> catalog1List= cataLogService.selectAllCatalog1();
        return catalog1List;
    }

    @RequestMapping("/getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){
        List<PmsBaseCatalog2> catalog1List= cataLogService.selectCatalog2ById(catalog1Id);
        return catalog1List;
    }

    @RequestMapping("/getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){
        List<PmsBaseCatalog3> catalog1List= cataLogService.selectCatalog3ById(catalog2Id);
        return catalog1List;
    }
}
