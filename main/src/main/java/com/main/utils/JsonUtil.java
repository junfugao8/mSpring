package com.main.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

    public static String add(String json,String key, Object value){
        JSONObject jsonObject = JSON.parseObject(json);
        jsonObject.put(key,value);
        return jsonObject.toJSONString();
    }

    public static String get(String json, String key){
        JSONObject jsonObject = JSON.parseObject(json);
        return jsonObject.getString(key);
    }

}
