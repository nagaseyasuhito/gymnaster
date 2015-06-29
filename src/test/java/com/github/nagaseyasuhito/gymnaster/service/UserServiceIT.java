package com.github.nagaseyasuhito.gymnaster.service;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class UserServiceIT {

	@Deployment
	public static Archive<?> createDeployment() {
		WebArchive war = ShrinkWrap.create(WebArchive.class);
		war.addPackages(true, "com.github.nagaseyasuhito.gymnaster");
		war.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		war.addAsResource("META-INF/persistence.xml");
		return war;
	}

	@Inject
	private UserService userService;

	@Test
	public void registerSuccess() {
		this.userService.register("gymnaster@example.com");
	}
}
