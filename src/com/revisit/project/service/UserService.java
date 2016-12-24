package com.revisit.project.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revisit.project.DTO.UserDTO;
import com.revisit.project.model.User;
import com.revisit.project.model.VerificationToken;
import com.revisit.project.repository.RoleRepository;
import com.revisit.project.repository.UserRepository;
import com.revisit.project.repository.VerificationTokenRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	VerificationTokenRepository verificationTokenRepository;

	final static Logger logger = Logger.getLogger(UserService.class);

	public User saveUser(UserDTO UserDTO) {

		User User = new User();
		User.setFirstName(UserDTO.getFirstName());
		User.setLastName(UserDTO.getLastName());
		User.setEmail(UserDTO.getEmail());
		User.setPassword(UserDTO.getPassword());
		User.setRole(roleRepository.findByRoleId(1));
		return userRepository.save(User);
	}

	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

	public void createVerificationToken(User User, String token) {
		VerificationToken newToken = new VerificationToken(token, User);
		logger.info("Verification token for user created.");
		verificationTokenRepository.save(newToken);

	}

	public User getUserById(Long id) {

		User user = userRepository.findByUserId(id);
		return user;
	}

	public int updateUser(UserDTO user, Long id) {
		int userValue = userRepository.updateUser(user.getFirstName(), user.getLastName(), user.getPassword(),
				user.getEmail(), id);
		return userValue;
	}

	public int deleteUserInfo(Long id) {
		int deleteVtoken = userRepository.deleteUserVToken(id);
		int deleteUser = userRepository.deleteUserDetail(id);
		if (deleteUser > 0 && deleteVtoken > 0) {
			return 1;
		}
		return 0;
	}

	public VerificationToken getVerificationToken(String token) {
		VerificationToken userToken = verificationTokenRepository.findByToken(token);
		return userToken;
	}

	public User enableUser(User user) {
		logger.info("User account is being enabled.");
		user.setEnabled(true);
		return userRepository.save(user);

	}

}
