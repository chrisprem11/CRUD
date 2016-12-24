package com.revisit.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;

	private String role;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="role")
	private List<User> userAccounts;

	public Role() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUserAccounts() {
		return this.userAccounts;
	}

	public void setUserAccounts(List<User> userAccounts) {
		this.userAccounts = userAccounts;
	}

	public User addUserAccount(User userAccount) {
		getUserAccounts().add(userAccount);
		userAccount.setRole(this);

		return userAccount;
	}

	public User removeUserAccount(User userAccount) {
		getUserAccounts().remove(userAccount);
		userAccount.setRole(null);

		return userAccount;
	}

}