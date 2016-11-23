package com.common;

import com.common.security.AESUtil;
import com.common.security.Base64;
import com.common.security.DESBase64Util;
import com.common.security.Md5Security;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        System.out.print("=============");
    }
    @Test
    public void testBase64() throws Exception{
        String encode = Base64.encode("张三aaa".getBytes());
        System.out.print(encode);
        System.out.print("=============");
        String decode = new String(Base64.decode(encode));
        System.out.print(decode);
        String a = "";
        Base64.decode(a);
    }
    @Test
    public void testMd5() throws Exception{
        System.out.print(Md5Security.getMD5("张三"));
    }

    @Test
    public void testDES() throws Exception{
        DESBase64Util.setKey("00000aaa");
        String enc = DESBase64Util.encodeInfo("张三");
        System.out.print(enc);
        System.out.print("=============");
        String des = DESBase64Util.decodeInfo(enc);
        System.out.print(des);
    }
    @Test
    public void testAES() throws Exception{
        String aes = AESUtil.Encrypt("absabsabsabs1111");
        System.out.print(aes);
        System.out.print("=============");
        System.out.print("====="+aes.length()+"========");
        aes = AESUtil.Decrypt(aes);
        System.out.print(aes);
    }




}