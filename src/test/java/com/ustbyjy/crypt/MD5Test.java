package com.ustbyjy.crypt;

import org.apache.commons.codec.digest.DigestUtils;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanjingyang
 * Date: 2017/3/17
 * Time: 9:56
 */
public class MD5Test {

    public static void main(String[] args) {
        byte[] data = "123456789".getBytes();
        byte[] hashValue = getMD5(data);
        // 使用JDK原生库
        String md5 = new HexBinaryAdapter().marshal(hashValue);
        // 使用commons codec库
        String _md5 = DigestUtils.md5Hex(data);

        System.out.println(md5);
        System.out.println(_md5);

    }

    private static byte[] getMD5(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return md.digest(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
