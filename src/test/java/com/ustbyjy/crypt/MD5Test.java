package com.ustbyjy.crypt;

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
        String md5 = new HexBinaryAdapter().marshal(hashValue);
        System.out.println(md5);
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
