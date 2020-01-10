package cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.dao;

import javax.annotation.Resource;

import cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.constant.DBConstants;
import cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.dataobject.UserDO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author 余勇
 * @date 2020-01-10 20:54
 */
@Repository
public class UserDao {

    @Resource(name = DBConstants.JDBC_TEMPLATE_USERS)
    private JdbcTemplate template;

    public UserDO selectById(Integer id) {
        return template.queryForObject("SELECT id, username FROM dynamic_datasource_users WHERE id = ?",
                // 结果转换成对应的对象
                new BeanPropertyRowMapper<>(UserDO.class),
                id);
    }

}
