package com.jk.controller;

import com.jk.model.GoodsModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "goods")
public class GoodsController extends InteractiveBaseController{

    @Override
    protected Object doCall(String opetype, Map<String, Object> map) {
        //执行不同的操作
        if ("1".equals(opetype)){

        }else if ("2".equals(opetype)){

        }
        GoodsModel goodsModel=new GoodsModel();
        goodsModel.setName("abc");
        goodsModel.setUuid("132132");
        System.out.println("call");
        return goodsModel;
    }
}
