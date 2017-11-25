package com.nchu.friends.utility;

import java.security.MessageDigest;

public class Encrypt {

	public static String encryptLoginPassword(String originPassword) {

		String encryptPassword = null;

		if (originPassword == null || originPassword == "")
			return null;

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			byte[] shaPassword = sha.digest(originPassword.getBytes());
			encryptPassword = new String(shaPassword);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
		return encryptPassword;

	}

}
