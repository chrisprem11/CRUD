package com.revisit.project.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.revisit.project.model.User;

@SuppressWarnings("serial")
public class OnSuccessfulRegistrationEvent extends ApplicationEvent {

	private final String appUrl;
	private final Locale locale;
	private final User user;

	public OnSuccessfulRegistrationEvent(final User user, final Locale locale, final String appUrl) {
		super(user);

		this.user = user;
		this.locale = locale;
		this.appUrl = appUrl;

	}

	public String getAppUrl() {
		return appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public User getUser() {
		return user;
	}

}
