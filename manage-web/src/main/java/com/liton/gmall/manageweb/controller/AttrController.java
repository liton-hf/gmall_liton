package com.liton.gmall.manageweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liton.gmall.bean.PmsBaseAttrInfo;
import com.liton.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class AttrController {

    @Reference
    AttrService attrService;


    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){

        // 调用业务实现
        List<PmsBaseAttrInfo>  pmsBaseAttrInfos = attrService.attrInfoList(catalog3Id);

        return pmsBaseAttrInfos;
    }

    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

        attrService.saveAttrInfo(pmsBaseAttrInfo);

        return "success";
    }
}
