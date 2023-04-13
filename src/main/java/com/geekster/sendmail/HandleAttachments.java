package com.geekster.sendmail;

import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class HandleAttachments {

	
	void sendAttachment() {
		
		//host : gmail is smtp
		
		String host="smtp.gmail.com";
		Properties props=System.getProperties();
		System.out.println(props);
		
		//set properties :
		
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.auth", "true");
		
		//session
		
		Session mailSession=Session.getInstance(props,new MailAuthenticator());
		//create the message object
		MimeMessage mineMessage=new MimeMessage(mailSession);
		
		try {
			mineMessage.setFrom(MailConstants.SENDER);
			mineMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(MailConstants.RECEIVER));
			
			mineMessage.setSubject(MailConstants.SUBJECT);
			mineMessage.setText(MailConstants.MESSAGE);
			Transport .send(mineMessage);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
