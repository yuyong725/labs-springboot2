package cn.javadog.labs.springboot2.redis.jedis.service;

import cn.javadog.labs.springboot2.redis.jedis.cacheobject.UserCacheObject;
import cn.javadog.labs.springboot2.redis.jedis.dao.redis.UserCacheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 余勇
 * @date 2020年01月09日 17:29:00
 */
@Service
public class UserService {

	@Autowired
	private UserCacheDao userCacheDao;

	public UserCacheObject get(Integer id) {
		return userCacheDao.get(id);
	}

	public void set(Integer id, UserCacheObject object) {
		userCacheDao.set(id, object);
	}

}
