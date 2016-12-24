package com.revisit.project.listener;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.revisit.project.event.OnSuccessfulRegistrationEvent;
import com.revisit.project.model.User;
import com.revisit.project.service.UserService;

@Component
public class RegistrationListener implements ApplicationListener<OnSuccessfulRegistrationEvent> {

	@Autowired
	UserService userService;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Environment env;

	private final static String USERNAME = "mail.server.username";
	
	final static Logger logger = Logger.getLogger(RegistrationListener.class);


	@Override
	public void onApplicationEvent(final OnSuccessfulRegistrationEvent event) {
		try {
			this.confirmRegistration(event);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void confirmRegistration(final OnSuccessfulRegistrationEvent event) {
		logger.info("confirmRegistration event is listening.");
		final User User = event.getUser();
		final String token = UUID.randomUUID().toString();
		userService.createVerificationToken(User, token);
		SimpleMailMessage email = constructEmailMessage(event, User, token);
		mailSender.send(email);
		logger.info("Email is sent.");
	}

	private final SimpleMailMessage constructEmailMessage(OnSuccessfulRegistrationEvent event,
			 User user,  String token) {
		final String subject = "Registration Confirmation";
		final String recipientAddress = user.getEmail();
		final String confirmationUrl = event.getAppUrl() + "/registrationConfirm?token=" + token;
		final String message = "Hello "+user.getFirstName()+"! Your registration was successfull. Please click on the"
				+ " link below to activate your account.";
		
		logger.info("The confirmation url is : "+confirmationUrl);
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message + " \r\n" + confirmationUrl);
		email.setFrom(env.getRequiredProperty(USERNAME));
		logger.info("Email is constructed.");
		logger.info("User email :- " + recipientAddress);
		return email;

	}

}
