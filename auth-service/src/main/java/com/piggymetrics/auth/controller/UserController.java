package com.piggymetrics.auth.controller;

import com.piggymetrics.auth.domain.User;
import com.piggymetrics.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public Principal getUser(Principal principal) {
		// System.out.println("Check principal"+principal. );
		return principal;
	}

	@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void createUser(@Valid @RequestBody User user) {
		System.out.println("Jay is created");
		userService.create(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void createUser() {
		System.out.println("Jay");
		// userService.create(user);
	}
}
