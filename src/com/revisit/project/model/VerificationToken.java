package com.revisit.project.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the verification_token database table.
 * 
 */
@Entity
@Table(name = "verification_token")
@NamedQuery(name = "VerificationToken.findAll", query = "SELECT v FROM VerificationToken v")
public class VerificationToken implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final int EXPIRATION = 60 * 24;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "v_id")
	private String vId;

	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	private String token;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User userAccount;

	public VerificationToken() {
	}

	public VerificationToken(final String token) {
		super();

		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	public VerificationToken(final String token, final User user) {
		super();

		this.token = token;
		this.userAccount = user;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	public String getVId() {
		return this.vId;
	}

	public void setVId(String vId) {
		this.vId = vId;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(User userAccount) {
		this.userAccount = userAccount;
	}

	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

	public void updateToken(final String token) {
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

}