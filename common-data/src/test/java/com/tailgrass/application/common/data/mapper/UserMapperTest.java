package com.tailgrass.application.common.data.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tailgrass.application.common.data.Application;
import com.tailgrass.application.common.data.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class UserMapperTest {

	private static Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

	@Autowired
	private UserMapper userMapper;

//	@Test
	public void testInsert() {
		try {
			User user = new User();
			user.setUserName("任我行");
			user.setUserPhone("18465760737");
			logger.info("insert result={}", userMapper.insert(user));
			user = userMapper.findById(user.getId());

			logger.info("user={}", user);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

//	@Test
	public void testFindById() {

		try {
			User user = userMapper.findById(1);
			logger.info("user=" + user);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	@Test
	public void testDeleteById() {
		try {
			for (long i = 4; i < 5; i++) {
				logger.info("delete result={}", userMapper.deleteById(i));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

//	@Test
	public void testUpdateUser() {
		try {
			User user = userMapper.findById(5);
			logger.info("user=" + user);
			user.setUserName("独孤求败");
			logger.info("update result=" + userMapper.update(user));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
