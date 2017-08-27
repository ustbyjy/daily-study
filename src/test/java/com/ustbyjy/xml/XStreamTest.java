package com.ustbyjy.xml;

import com.ustbyjy.bean.*;
import com.ustbyjy.util.XmlUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: XStream测试类
 * User: yanjingyang
 * Date: 2017/7/13
 * Time: 10:01
 */
public class XStreamTest {

    @Test
    public void testToXml() {
        PersonBean per = new PersonBean();
        per.setFirstName("mao");
        per.setLastName("zedong");

        PhoneNumber tel = new PhoneNumber();
        tel.setCode(137280);
        tel.setNumber("137280968");

        PhoneNumber fax = new PhoneNumber();
        fax.setCode(20);
        fax.setNumber("020221327");
        per.setTel(tel);
        per.setFax(fax);


        // 测试一个标签下有多个同名标签
        List<String> friendList = new ArrayList<String>();
        friendList.add("A1");
        friendList.add("A2");
        friendList.add("A3");
        Friends friend1 = new Friends();
        friend1.setName(friendList);
        per.setFriend(friend1);

        // 测试一个标签下循环对象
        Animal dog = new Animal("Dolly", 2);
        Animal cat = new Animal("Ketty", 2);
        List<Animal> petList = new ArrayList<Animal>();
        petList.add(dog);
        petList.add(cat);
        per.setAnimals(petList);

        // java对象转换成xml
        String xml = XmlUtil.toXml(per);
        System.out.println(xml);

    }

    @Test
    public void testToBean() {
        String xmlStr = "<person>\n" +
                "  <firstName>mao</firstName>\n" +
                "  <lastName>zedong</lastName>\n" +
                "  <telPhone>\n" +
                "    <code>137280</code>\n" +
                "    <number>137280968</number>\n" +
                "  </telPhone>\n" +
                "  <faxPhone>\n" +
                "    <code>20</code>\n" +
                "    <number>020221327</number>\n" +
                "  </faxPhone>\n" +
                "  <friends>\n" +
                "    <name>A1</name>\n" +
                "    <name>A2</name>\n" +
                "    <name>A3</name>\n" +
                "  </friends>\n" +
                "  <pets>\n" +
                "    <pet>\n" +
                "      <name>Dolly</name>\n" +
                "      <age>2</age>\n" +
                "    </pet>\n" +
                "    <pet>\n" +
                "      <name>Ketty</name>\n" +
                "      <age>2</age>\n" +
                "    </pet>\n" +
                "  </pets>\n" +
                "</person>";

        String errorXmlStr = "<Datas> \n" +
                "  <server gameid=\"209\" name=\"游戏服102\" zoneid=\"102\" group=\"group1\" groupid=\"1\" type=\"正式\"> \n" +
                "    <host hostname=\"tc-qa-cdn\" innerip=\"10.104.53.167\" wanip=\"\" tag=\"\" cloud=\"tencent\"/> \n" +
                "  </server>  \n" +
                "  <server gameid=\"209\" name=\"游戏服103\" zoneid=\"103\" group=\"group1\" groupid=\"1\" type=\"正式\"> \n" +
                "    <host hostname=\"tc-qa-cdn\" innerip=\"10.104.53.167\" wanip=\"\" tag=\"\" cloud=\"tencent\"/> \n" +
                "  </server>\n" +
                "</Datas>\n";

        PersonBean person = XmlUtil.toBean(xmlStr, PersonBean.class);

        System.out.println("person=firstName==" + person.getFirstName());
        System.out.println("person==Friends==name1==" + person.getFriend().getName().get(0));
    }

}
