package com.github.nagaseyasuhito.gymnaster.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import lombok.Data;

import com.github.nagaseyasuhito.gymnaster.service.UserService;

@Named("registerBean")
@RequestScoped
@Data
public class RegisterController {

	@Inject
	private UserService userService;

	@NotNull
	private String mailAddress;

	public String register() {
		this.userService.register(this.mailAddress);

		return "registrationFinished";
	}
}
