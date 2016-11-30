package com.carl.breakfast.web.ctrl.admin;

/**
 * 商品图片
 * @author Carl
 * @date 2016/12/1
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public class GoodsImage {
    private int id;
    private String path;

    public int getId() {
        return id;
    }

    public GoodsImage setId(int id) {
        this.id = id;
        return this;
    }

    public String getPath() {
        return path;
    }

    public GoodsImage setPath(String path) {
        this.path = path;
        return this;
    }
}
