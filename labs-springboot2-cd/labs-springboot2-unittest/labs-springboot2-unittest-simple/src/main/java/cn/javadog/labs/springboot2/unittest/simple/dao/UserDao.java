package cn.javadog.labs.springboot2.unittest.simple.dao;

import cn.javadog.labs.springboot2.unittest.simple.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author 余勇
 * @date 2020年02月26日 15:36:00
 */
@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate template;

	/**
	 * 根据id查询
	 */
	public UserDO selectById(Integer id) {
		return template.queryForObject("SELECT id, username, password FROM t_user WHERE id = ?",
			// 结果转换成对应的对象
			new BeanPropertyRowMapper<>(UserDO.class),
			id);
	}

}
