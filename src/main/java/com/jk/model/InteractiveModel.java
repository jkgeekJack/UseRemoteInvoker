package com.jk.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 调用远端方法的协议类
 */
public class InteractiveModel {
    /**
     * 操作类型
     */
    private String opeType;
    /**
     * 操作参数
     */
    private Map<String,Object>map=new HashMap<String ,Object>();

    public InteractiveModel(String opeType, Map<String, Object> map) {
        this.opeType = opeType;
        this.map = map;
    }

    public InteractiveModel() {
    }

    public String getOpeType() {
        return opeType;
    }

    public void setOpeType(String opeType) {
        this.opeType = opeType;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
