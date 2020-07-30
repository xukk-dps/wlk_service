package com.shop.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	/*
	 * MD5 算法
	 */
	// 全局数组
	private final static char hexDigits[] = { '0', '1', '2', '3', '4', '5', 
		'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * MD5 32位加密算法值为大写
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encrypt32(String input) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			byte di[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = di[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}

	}


	public static String encrypt16(String input) throws Exception {
		return encrypt32(input).substring(8, 24);
	}
}