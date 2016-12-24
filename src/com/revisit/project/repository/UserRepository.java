package com.revisit.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revisit.project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findAll();

	public User findByEmail(String email);

	public User findByUserId(Long id);
	
	@Modifying
	@Transactional
	@Query("delete from User u "+" where id=:id")
	public int deleteUserDetail(@Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query("delete from VerificationToken v "+" where user_id=:id")
	public int deleteUserVToken(@Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query("update User u set firstName =:firstName,lastName=:lastName,email=:email,password=:password "
			+ "where id=:id")
	public int updateUser(@Param("firstName") String firstName, @Param("lastName") String lastName,
			@Param("password") String password, @Param("email") String email, @Param("id") Long id);

}
