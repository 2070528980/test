package com.example.shiro.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

public class JsonUtil {

    /**
     * List<T> 转 json 保存到数据库
     */
    public static <T> String listToJson(List<T> ts) {
        String jsons = JSON.toJSONString(ts);
        return jsons;
    }

    /**
     * json 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }



//      JSONObject里的值转JSONArray，strJson为JSONObject，data为strJson里的字段
//      JSONArray data = strJson.getJSONArray("data");

//        String 转JSONObject
//    JSONObject dataJson = JSONObject.parseObject(str);

//    String 转 JSONArray
//    JSONArray feedRecordJSONArray = (JSONArray)JSONArray.parse(FeedRecordStr);

//    JSONObject转对象 obj：JSONObject
//    DeviceData deviceData = JSON.toJavaObject(obj, DeviceData.class);

//    对象转JSON
//    JSONObject.toJSONString(Javabean对象)


//    String类型的json转对象List   dataStr:String类型的json    DeviceHistoryData:对象
//    List<DeviceHistoryData> list = JsonUtil.jsonToList(dataStr, DeviceHistoryData.class);


//    HashMap转JSONObject
//    JSONObject allJson = new JSONObject();
//        allJson.put("data",hashMap);

    //    HashMap转JSON String
//    JSON.toJSONString(hashMap)


//    获取 JSONObject 里的某个值
//     String FeedDate = dataJson.getString("FeedDate");

}
