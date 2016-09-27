package com.hyb.encode;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Random;

public class Encode {
										// {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public static final char[] CODER_KEY = {'I','F','L','J','E','B','G','H','A','D','Y','C','Z','O','N','S','W','R','P','T','U','V','Q','X','K','M'};
	// 加密，先用Base64加密，然后根据字典再加密
	public static String encode(String str) {
		String target = Base64.getEncoder().encodeToString(str.getBytes());
		return replaceCharacterWithKeyMap(target);
	}

	// 解密，现根据字典解密, 然后Base64解密
	public static String decode(String str) throws Exception {
		assert str != null;
		str = replaceCharacterWithKeyMap(str);
		try {
			byte[] strBytes = Base64.getDecoder().decode(str);
			return new String(strBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	private static String replaceCharacterWithKeyMap(String str) {
		assert str != null;
		StringBuffer rlt = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (temp <= 'z' && temp >= 'a') {
				temp = (temp + "").toUpperCase().charAt(0);
				int index = temp - 'A';
				rlt.append((CODER_KEY[index] + "").toLowerCase());
			} else if (temp <= 'Z' && temp >= 'A') {
				int index = temp - 'A';
				rlt.append(CODER_KEY[index]);
			} else {
				rlt.append(temp);
				continue;
			}
		}
		return rlt.toString();
	}

	public static String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+=-{}|\\][';/.,";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(str.length());
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 500; i++) {
			String str = getRandomString(20);
			System.out.println("生成:" + str);
			String encode = encode(str);
			System.out.println("编码:" + encode);
			String decode = "";
			try {
				decode = decode(encode);
				System.out.println("解码:" + decode);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (!decode.equals(str)) {
				System.out.println("炸了炸了炸了炸了炸了炸了炸了炸了炸了炸了炸了炸了炸了炸了");
			}
		}
	}
}
