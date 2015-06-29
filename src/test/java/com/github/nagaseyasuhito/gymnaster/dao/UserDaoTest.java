package com.github.nagaseyasuhito.gymnaster.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.github.nagaseyasuhito.gymnaster.entity.User;
import com.google.common.collect.Maps;

public class UserDaoTest {

	@Test
	public void persistSuccess() {
		// overriding original persistence.xml
		Map<String, String> properties = Maps.newHashMap();
		properties.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
		properties.put("javax.persistence.jdbc.driver", "org.h2.Driver");
		properties.put("javax.persistence.jdbc.url", "jdbc:h2:mem:;DB_CLOSE_DELAY=-1");
		properties.put("javax.persistence.jdbc.user", "");
		properties.put("javax.persistence.jdbc.password", "");
		properties.put("javax.persistence.jtaDataSource", "");

		properties.put("eclipselink.logging.level", "WARNING");
		properties.put("eclipselink.logging.level" + ".sql", "FINE");
		properties.put("eclipselink.ddl-generation", "create-tables");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gymnaster", properties);
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		User user = new User();
		user.setMailAddress("gymnaster@example.com");

		entityManager.persist(user);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
