package com.jk.controller;


import com.alibaba.fastjson.JSON;
import com.jk.model.InteractiveModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 远端被调用方法的基类
 */
public abstract class InteractiveBaseController {
    /**
     * 解析参数
     * @param jsonParam
     * @return
     */
    @RequestMapping("/call")
    @ResponseBody
    public Object call(String jsonParam){
        if (jsonParam!=null&&jsonParam.contains("*")){
            //将*变回#
            jsonParam=jsonParam.replace("*","#");
        }
        InteractiveModel interactiveModel= JSON.parseObject(jsonParam,InteractiveModel.class);
        Object ret=doCall(interactiveModel.getOpeType(),interactiveModel.getMap());
        return ret;
    }
    protected  abstract Object doCall(String opetype, Map<String,Object>map);
}
