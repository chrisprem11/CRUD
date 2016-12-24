package com.revisit.project.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages = { "com.revisit.project" })
@PropertySource(value = { "classpath:application.properties" })
public class MailConfig {

	private final static String HOST = "mail.server.host";
	private final static String PORT = "mail.server.port";
	private final static String PROTOCOL = "mail.server.protocol";
	private final static String USERNAME = "mail.server.username";
	private final static String PASSWORD = "mail.server.password";

	private final static String SMTP_AUTH = "mail.smtp.auth";
	private final static String SMTP_STARTTLS = "mail.smtp.starttls.enable";

	@Autowired
	private Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public JavaMailSenderImpl javaMailSenderImpl() {
		Properties javaMailProperties = new Properties();
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		try {
			mailSenderImpl.setHost(env.getRequiredProperty(HOST));
			mailSenderImpl.setPort(env.getRequiredProperty(PORT, Integer.class));
			mailSenderImpl.setProtocol(env.getRequiredProperty(PROTOCOL));
			mailSenderImpl.setUsername(env.getRequiredProperty(USERNAME));
			mailSenderImpl.setPassword(env.getRequiredProperty(PASSWORD));
		} catch (Exception e) {
			e.getMessage();
		}

		javaMailProperties.put(SMTP_AUTH, env.getRequiredProperty(SMTP_AUTH));
		javaMailProperties.put(SMTP_STARTTLS, env.getRequiredProperty(SMTP_STARTTLS));

		mailSenderImpl.setJavaMailProperties(javaMailProperties);
		return mailSenderImpl;
	}
}
