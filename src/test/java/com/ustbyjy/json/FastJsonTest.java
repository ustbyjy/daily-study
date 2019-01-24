package com.ustbyjy.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ustbyjy.bean.ConfigList;
import com.ustbyjy.bean.ResultBean;
import com.ustbyjy.bean.User;
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
        jsonStr = JSONObject.toJSONString(map);
        System.out.println(jsonStr);
    }

    @Test
    public void testDate2Json() {
        ConfigList configList = new ConfigList();
        configList.setId(1L);
        configList.setCreateTime(new Date());
        System.out.println(JSONObject.toJSONString(configList));
    }

    @Test
    public void testMap2Json4() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("project", "QLYRY");
        map.put("filename", "QLYRY-serverlist.xml");
        map.put("contents", "<Datas> \n" +
                "  <server gameid=\"209\" name=\"游戏服102\" zoneid=\"102\" group=\"group1\" groupid=\"1\" type=\"正式\"> \n" +
                "    <host hostname=\"tc-qa-cdn\" innerip=\"10.104.53.167\" wanip=\"\" tag=\"ops\" cloud=\"阿里云\"/> \n" +
                "  </server> \n" +
                "</Datas>");

        System.out.println(JSONObject.toJSONString(map));

    }

    @Test
    public void testString2Object() {

        ResultBean resultBean = new ResultBean();
        resultBean.setCode("123");
        resultBean.setMsg("success");

        User u1 = new User();
        u1.setId(1);
        u1.setName("u1");

        User u2 = new User();
        u2.setId(1);
        u2.setName("u2");

        resultBean.getUsers().add(u1);
        resultBean.getUsers().add(u2);

        String s = JSONObject.toJSONString(resultBean);
        System.out.println(s);

        ResultBean bean = JSON.parseObject(s, ResultBean.class);
        System.out.println(bean);
    }

    @Test
    public void jsonToString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", 4002);
        jsonObject.put("forced", true);
        jsonObject.put("desc", "1.bug修复\n2.新增特性");
        jsonObject.put("url", "https://bjx-packages.oss-cn-beijing.aliyuncs.com/master/test/app-debug.apk");
        System.out.println(jsonObject.toJSONString());

        System.out.println(jsonObject.getString("desc"));
    }

}
