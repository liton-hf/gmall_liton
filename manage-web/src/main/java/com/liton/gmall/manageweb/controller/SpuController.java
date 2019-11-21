package com.liton.gmall.manageweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liton.gmall.bean.PmsBaseSaleAttr;
import com.liton.gmall.bean.PmsProductInfo;
import com.liton.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import webutil.FileUpload;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;

    @RequestMapping("/spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> productInfoList= spuService.selectbyCatalog3Id(catalog3Id);
        return productInfoList;
    }

    @RequestMapping("/spuSaleAttrList")
    @ResponseBody
    public List<PmsProductInfo> spuSaleAttrList(String spuId){
        List<PmsProductInfo> productInfoList= spuService.selectbyCatalog3Id(spuId);
        return productInfoList;
    }

    @RequestMapping("/baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList(String spuId){
        List<PmsBaseSaleAttr> baseSaleList= spuService.selectBaseSaleList();
        return baseSaleList;
    }

    @RequestMapping("/saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        String result= spuService.saveSpuInfo(pmsProductInfo);
        return result;
    }


    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file")MultipartFile multipartFile){

        String imgUrl = FileUpload.fileUpload(multipartFile);

        return imgUrl;
    }

}
