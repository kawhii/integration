package com.carl.breakfast.web.ctrl.admin;

import java.util.List;

/**
 * 商品扩展信息
 * @author Carl
 * @date 2016/12/1
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public class GoodsDetail {
    private List<GoodsImage> images;

    public List<GoodsImage> getImages() {
        return images;
    }

    public GoodsDetail setImages(List<GoodsImage> images) {
        this.images = images;
        return this;
    }
}
