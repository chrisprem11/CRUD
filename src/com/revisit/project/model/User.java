package com.revisit.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the user_account database table.
 * 
 */
@Entity
@Table(name = "user_account")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;

	private String email;

	private boolean enabled;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String password;

	// bi-directional many-to-one association to Role
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;

	// bi-directional many-to-one association to VerificationToken
	@OneToMany(mappedBy = "userAccount")
	private List<VerificationToken> verificationTokens;

	public User() {
		super();
		this.enabled = false;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<VerificationToken> getVerificationTokens() {
		return this.verificationTokens;
	}

	public void setVerificationTokens(List<VerificationToken> verificationTokens) {
		this.verificationTokens = verificationTokens;
	}

	public VerificationToken addVerificationToken(VerificationToken verificationToken) {
		getVerificationTokens().add(verificationToken);
		verificationToken.setUserAccount(this);

		return verificationToken;
	}

	public VerificationToken removeVerificationToken(VerificationToken verificationToken) {
		getVerificationTokens().remove(verificationToken);
		verificationToken.setUserAccount(null);

		return verificationToken;
	}

}