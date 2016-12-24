package com.revisit.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revisit.project.DTO.UserDTO;
import com.revisit.project.event.OnSuccessfulRegistrationEvent;
import com.revisit.project.model.User;
import com.revisit.project.model.VerificationToken;
import com.revisit.project.repository.RoleRepository;
import com.revisit.project.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ApplicationEventPublisher eventPublisher;

	final static Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex(ModelMap model) {
		logger.info("Revisit app - HomePage.");
		return "index";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getRegistrationPage(@ModelAttribute("userData") UserDTO userDTO) {
		logger.info("Registration page is called up.");
		return "registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegistration(@ModelAttribute("userData") UserDTO userDTO, BindingResult result, ModelMap model,
			HttpServletRequest request) {

		User newUser = userService.saveUser(userDTO);
		logger.info("User Saved !");
		if (result.hasErrors() || newUser == null) {
			model.addAttribute("error", "Oops ! Something went wrong. Please try again.");
			return "redirect:/registration";
		} else {
			logger.info("Registration Event is published");
			eventPublisher
					.publishEvent(new OnSuccessfulRegistrationEvent(newUser, request.getLocale(), getAppUrl(request)));
			model.addAttribute("success", "Registration successful. Please Check your inbox!");
			model.addAttribute("firstName", userDTO.getFirstName());
			return "success";

		}

	}

	@RequestMapping(value = "/userProfile/{id}", method = RequestMethod.GET)
	public String getUserProfile(@PathVariable("id") Long id, ModelMap model,
			@ModelAttribute("updateData") UserDTO userDTO) {
		User user = userService.getUserById(id);
		model.addAttribute("userId", id);
		model.addAttribute("user", user);
		return "userProfile";
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST)
	public String updateUser(@PathVariable("id") Long id, @ModelAttribute("updateData") UserDTO userDTO,
			ModelMap model) {
		logger.info("User data is being updated.");
		int updateValue = userService.updateUser(userDTO, id);

		if (updateValue != 0) {
			logger.debug("User profile is updated. Page redirected.");
			return "redirect:/showAll";
		} else {
			logger.info("user data updation failed.");
			return "redirect:/userProfile/" + id;
		}
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Long id, ModelMap model) {
		logger.info("User is being deleted.");
		int deleteValue = userService.deleteUserInfo(id);
		if (deleteValue > 0) {
			logger.info("User record deleted");
			return "redirect:/showAll";
		} else {
			logger.info("User record deletion failed. ");
			return "redirect:/showAll";
		}
	}

	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public String showUser(ModelMap model) {
		List<User> allUsers = userService.getAllUsers();
		logger.info("all users are loaded up.");
		model.addAttribute("allUsers", allUsers);
		return "allUsers";
	}

	@RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
	public String confirmRegistration(@RequestParam("token") String token, User user, ModelMap model) {
		VerificationToken userToken = userService.getVerificationToken(token);
		if (userToken == null) {
			logger.info("user token not found or invalid.");
			String message = "Bad User. Invalid token provided. Please check your mailbox.";
			model.addAttribute("message", message);
			return "confirmation";
		}
		user = userToken.getUserAccount();
		User enableUser = userService.enableUser(user);
		logger.info("User account is now enabled.");
		if (enableUser != null) {
			String message = "Hi " + user.getFirstName() + " ! Your account has been succefully activated. Thank You !";
			model.addAttribute("message", message);
			return "confirmation";
		}
		return "confirmation";

	}

	private String getAppUrl(HttpServletRequest request) {
		String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		logger.info("The url is : [ " + url + " ]");
		return url;
	}
}
