package com.common.security;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加解密算法(使用org.apache.commons.codec.binary.Base64做转码以及辅助加密)
 * 
 */
public class AESUtil {


	private static String iv = "0102030405060708";
	private static String key = "czabcd1234czabcd";


	public static void initKey(){
		key = "czabcd1234czabcd";
	}

	public static  void setKey(String key){
		if(key == null || key.length() != 16)
			throw new RuntimeException("Key长度不是16位");
		AESUtil.key = key;
	}

	// 加密
	public static String Encrypt(String sSrc) throws Exception {
		byte[] raw = key.getBytes("UTF-8");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/Iso10126Padding");//"算法/模式/补码方式"
		//使用CBC模式，需要一个向量iv，可增加加密算法的强度
		IvParameterSpec ivps = new IvParameterSpec(iv.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivps);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes("UTF-8"));
		String parStr = parseByte2HexStr(encrypted);
		return Base64.encode(parStr.getBytes("UTF-8"));//此处使用BAES64做转码功能，同时能起到2次加密的作用。
	}

	// 解密
	public static String Decrypt(String sSrc) throws Exception {
		byte[] raw = key.getBytes("UTF-8");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/Iso10126Padding");
		IvParameterSpec ivps = new IvParameterSpec(iv.getBytes("UTF-8"));
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivps);
		byte[] encrypted1 = parseHexStr2Byte(Base64.decode(sSrc.getBytes("UTF-8")));//先用bAES64解密
		byte[] original = cipher.doFinal(encrypted1);
		return new String(original,"UTF-8");
	}

	/**
	 * 将二进制转换成16进制
	 * @param buf
	 * @return
     */
	private static String parseByte2HexStr(byte buf[]){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < buf.length; i++){
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * @param hexStr
	 * @return
     */
	private static byte[] parseHexStr2Byte(String hexStr){
		if(hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length()/2];
		for (int i = 0;i< hexStr.length()/2; i++) {
			int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
			int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
}