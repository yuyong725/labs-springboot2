package cn.javadog.labs.springboot2.unittest.simple.service;

import cn.javadog.labs.springboot2.unittest.simple.dao.UserDao;
import cn.javadog.labs.springboot2.unittest.simple.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 余勇
 * @date 2020年02月26日 15:36:00
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public UserDO get(Integer id) {
		return userDao.selectById(id);
	}

}

