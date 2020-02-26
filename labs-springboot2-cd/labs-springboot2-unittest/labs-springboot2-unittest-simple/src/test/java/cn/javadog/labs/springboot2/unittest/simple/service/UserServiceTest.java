package cn.javadog.labs.springboot2.unittest.simple.service;

import cn.javadog.labs.springboot2.unittest.simple.dao.UserDao;
import cn.javadog.labs.springboot2.unittest.simple.dataobject.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 余勇
 * @date 2020年02月26日 16:00:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@MockBean
	private UserDao userDao;

	@Autowired
	private UserService userService;

	@Test
	public void testGet() {
		// Mock UserDao 的 selectById 方法
		Mockito.when(userDao.selectById(1)).thenReturn(
			new UserDO().setId(1).setUsername("username:1").setPassword("password:1"));

		// 查询用户
		UserDO user = userService.get(1);

		// 校验结果
		Assert.assertEquals("编号不匹配", 1, (int) user.getId());
		Assert.assertEquals("用户名不匹配", "username:1", user.getUsername());
		Assert.assertEquals("密码不匹配", "password:1", user.getPassword());
	}

}
