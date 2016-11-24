package com.common;

import com.common.commonutils.JsonUtils;
import com.common.commonutils.MoneyUtil;
import com.common.security.AESUtil;
import com.common.security.Base64;
import com.common.security.DESBase64Util;
import com.common.security.Md5Security;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.common.commonutils.JsonUtils.fromJson;
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
    @Test
    public void testMoney() throws Exception{
//        System.out.println(MoneyUtil.formatMoney("1,000.12645"));
        System.out.println(MoneyUtil.formatMoneyWithoutDecimal("1000.12645"));
    }
    @Test
    public void testJson() throws Exception{
        Demo demo = new Demo();
        demo.setAge(1);
        demo.setName("张三");
        String json = JsonUtils.toJson(demo);
        System.out.println(json);
        System.out.println("=========");
        String name = JsonUtils.getStringValue(json,"name");
        int age = JsonUtils.getIntValue(json,"age");
        String strAge = JsonUtils.getStringValue(json,"age");
        System.out.println(name);
        System.out.println(age);
        System.out.println(strAge);
        System.out.println("=========");
        System.out.println(JsonUtils.toJson(null));
        System.out.println("=========");
        Demo demo1 = (Demo) fromJson(json,Demo.class);
        System.out.println(demo1);
        System.out.println("=========");
        List<Demo> demoList = new ArrayList<>();
        for(int a =0;a<5;a++){
            Demo demo2 = new Demo();
            demo2.setName("name"+a);
            demo2.setAge(a);
            demoList.add(demo2);
        }
        String jsonStr = JsonUtils.toJson(demoList);
        System.out.println(jsonStr);
        System.out.println("=========");
        Type  type =  new TypeToken<List<Demo>> (){}.getType();
        List<Demo> demos = (List<Demo>) JsonUtils.fromJson(jsonStr,type);
        System.out.println(demos);
        System.out.println("=========");




    }







}