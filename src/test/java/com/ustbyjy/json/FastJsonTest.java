package com.ustbyjy.json;

import com.alibaba.fastjson.JSONObject;
import com.ustbyjy.entity.ConfigList;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanjingyang
 * Date: 2017/3/31
 * Time: 15:10
 */
public class FastJsonTest {

    @Test
    public void testMap2Json() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("deposited_account", "abc123");
        map.put("deposit_account", "def456");
        map.put("optype", 1);
        map.put("duration", 3600);
        String jsonString = JSONObject.toJSONString(map);
        System.out.println(jsonString);
    }

    @Test
    public void testMap2Json2() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("deposit_account", RandomStringUtils.randomAlphabetic(6));
        resultMap.put("deposited_account", RandomStringUtils.randomAlphabetic(6));
        String jsonString = JSONObject.toJSONString(resultMap);
        System.out.println(jsonString);
    }

    @Test
    public void testMap2Json3() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> posMap = new HashMap<String, Object>();
        posMap.put("id", 1);
        posMap.put("name", "会员");
        resultMap.put("pos", posMap);
        String jsonString = JSONObject.toJSONString(resultMap);
        System.out.println(jsonString);
    }

    @Test
    public void testJson2Map() {
        String jsonStr = "{}";
        Map<String, Object> map = (Map<String, Object>) JSONObject.parse(jsonStr);
        System.out.println(map);
        map.put("age", 12);
        map.put("name", "Jack");
        jsonStr =  JSONObject.toJSONString(map);
        System.out.println(jsonStr);
    }

    @Test
    public void testDate2Json() {
        ConfigList configList = new ConfigList();
        configList.setId(1L);
        configList.setCreateTime(new Date());
        System.out.println(JSONObject.toJSONString(configList));
    }

}
