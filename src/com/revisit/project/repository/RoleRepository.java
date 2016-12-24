package com.revisit.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revisit.project.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByRole(String role);

	public Role findByRoleId(int id);

	public List<Role> findAll();
}
