package com.shop.util;


import com.alibaba.fastjson.JSON;
import org.json.XML;

public class XmlToJson {

    public static String xml2jsonString(String xml) {
        try{
            org.json.JSONObject object = XML.toJSONObject(xml);
            String jsonData = object.get("xml").toString();
            com.alibaba.fastjson.JSONObject resultJSON = JSON.parseObject(jsonData);
            return resultJSON.toJSONString();
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }

    }

    public static void main(String[] args){

        String string = xml2jsonString("<?xml version=\"1.0\" encoding=\"UTF-8\"?><xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml> ");
        System.out.println(string);

    }
}
