package com.akshay.util;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
public class MailUtil {
	
	private  MailUtil() {
	}


	
	public static void sendSimpleMail() throws EmailException{
	Email email = new SimpleEmail();

	email.setSmtpPort(465);
	
	email.setAuthenticator(new DefaultAuthenticator("ashpeekay23@gmail.com", "ashreyapk"));
	email.setDebug(false);
	email.setHostName("smtp.gmail.com");
	email.setSSLOnConnect(true);
	email.setFrom("ashpeekay23@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("playboykd23@gmail.com");
	email.setStartTLSEnabled(true);
	email.send();
	
		
	}
}

