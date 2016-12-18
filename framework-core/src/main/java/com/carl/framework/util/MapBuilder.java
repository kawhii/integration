package com.carl.framework.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * 方便构造器
 *
 * @author Carl
 * @date 2016/11/30
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public class MapBuilder<K, V> extends HashMap<K, V> {
    private MapBuilder() {

    }

    public static <K, V> MapBuilder<K, V> build() {
        return new MapBuilder();
    }

    public MapBuilder<K, V> p(K key, V val) {
        super.put(key, val);
        return this;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
