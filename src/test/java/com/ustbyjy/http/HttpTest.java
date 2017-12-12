package com.ustbyjy.http;

import com.mzlion.easyokhttp.HttpClient;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/4/19
 * Time: 16:35
 */
public class HttpTest {

    @Test
    public void testGet() {
        String responseData = HttpClient
                .get("https://www.baidu.com")
                .asString();
        System.out.println(responseData);
    }

    @Test
    public void testPost() {
        String responseData = HttpClient
                .post("https://www.baidu.com")
                .param("name", "张三")
                .param("mobile", "13023614020")
                .param("lang", "Java")
                .asString();
        System.out.println(responseData);
    }

    @Test
    public void testSSO() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("LoginCode", "zhaotielei");
        String responseData = HttpClient
                .get("http://web.oa.zulong.com/C6/JHSoft.Web.ZLAttendance/JHOA_BusinessTrip.asmx/GetUserInfo")
                .queryString(parameters)
                .execute()
                .asString();
        System.out.println(responseData);
    }
}
