package com.akshay.util;

public class TestMailUtil {

	public static void main(String[] args) {
		try {
			MailUtil.sendSimpleMail("Hi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
