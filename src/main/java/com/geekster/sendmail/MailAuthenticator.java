package com.geekster.sendmail;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator {
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		 
		  return new PasswordAuthentication(MailConstants.SENDER, "upkscrwnwfrdlzoh");
		
	}

}
