package com.jk.model;

/**
 * 要操作的实体类
 */
public class GoodsModel {
    private String uuid;
    private String name;

    public GoodsModel(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public GoodsModel() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GoodsModel{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
