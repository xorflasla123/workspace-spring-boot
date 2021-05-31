package com.care.root;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.configration.UserTest;
import com.care.root.dao.UserDAO;
import com.care.root.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class Ex01ApplicationTests {
	@Autowired
	UserService userService;
	@Test
	void contextLoads() {
		Assert.assertNotNull(userService);
	}
	@Autowired UserDAO dao;
	@Test
	void daoTest() {
		Assert.assertNotNull(dao);
	}
	@Autowired UserTest userTest;
	@Test
	void userTest() {
		Assert.assertNotNull(userTest);
	}

}



