package com.ustbyjy.crypt;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Test {

    @Test
    public void testSunMisc() throws Exception {
        final BASE64Encoder encoder = new BASE64Encoder();
        final BASE64Decoder decoder = new BASE64Decoder();
        final String text = "Java技术栈";
        final byte[] textByte = text.getBytes("UTF-8");

        // 编码
        final String encodedText = encoder.encode(textByte);
        System.out.println(encodedText);

        // 解码
        System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));
    }

    @Test
    public void testApacheCommonsCodec() throws Exception {
        final Base64 base64 = new Base64();
        final String text = "Java技术栈";
        final byte[] textByte = text.getBytes("UTF-8");

        // 编码
        final String encodedText = base64.encodeToString(textByte);
        System.out.println(encodedText);

        // 解码
        System.out.println(new String(base64.decode(encodedText), "UTF-8"));
    }

    @Test
    public void testJavaUtilIn8() throws Exception {
        final java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        final java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        final String text = "Java技术栈";
        final byte[] textByte = text.getBytes("UTF-8");

        // 编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);

        // 解码
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
    }

    @Test
    public void base64ToString() {
        String base64Str = "rO0ABXNyABtjb20uYmp4LmFwaS5iZWFuLlNtc01lc3NhZ2V/l4ADlMCVsQIAAkwAB2NvbnRlbnR0ABJMamF2YS9sYW5nL1N0cmluZztMAAZtb2JpbGVxAH4AAXhwdABi5oKo55qE5omL5py66aqM6K+B56CB5Li677yaMzE2MDAw6K+35ZyoMTXliIbpkp/lhoXlrozmiJDpqozor4HvvIzlpoLpnZ7mnKzkurrmk43kvZzvvIzor7flv73nlaXjgIJ0AAsxODUxODY2NjIyOQ==";
        String str = new String(Base64.decodeBase64(base64Str));
        System.out.println(str);
    }

}
