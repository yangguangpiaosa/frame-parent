package com.ibm.dst.frame.ssm.common.util;

import java.security.MessageDigest;

public class MD5Encoder {
	
    public static final String encodeByMD5(String inString) {
	/*String outString = "";
	
	try {
	    MessageDigest md5 = MessageDigest.getInstance("MD5");
	    BASE64Encoder base64Encoder = new BASE64Encoder();
	    outString = base64Encoder.encode(md5.digest(inString.getBytes("utf-8")));
	} catch (NoSuchAlgorithmException e) {
	    
	} catch (UnsupportedEncodingException e) {
	    
	}
	
	return outString;*/
	
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = inString.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

    }
    
    public static void main(String [] args) {
		String testString = "administrator";
		System.out.println(MD5Encoder.encodeByMD5(testString));
		System.out.println(MD5Encoder.encodeByMD5(testString).length());
		System.out.println(MD5Encoder.encodeByMD5("1"));
		System.out.println(MD5Encoder.encodeByMD5("2"));
		System.out.println(MD5Encoder.encodeByMD5("3"));
		System.out.println(MD5Encoder.encodeByMD5("xyz"));
		System.out.println(MD5Encoder.encodeByMD5("admin"));
		System.out.println(MD5Encoder.encodeByMD5("super"));
    }
    
}
