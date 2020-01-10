package cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.dao;

import javax.annotation.Resource;

import cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.constant.DBConstants;
import cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.dataobject.OrderDO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author 余勇
 * @date 2020-01-10 20:53
 */
@Repository
public class OrderDao {

    @Resource(name = DBConstants.JDBC_TEMPLATE_ORDERS)
    private JdbcTemplate template;

    public OrderDO selectById(Integer id) {
        return template.queryForObject("SELECT id, user_id FROM dynamic_datasource_orders WHERE id = ?",
                // 结果转换成对应的对象
                new BeanPropertyRowMapper<>(OrderDO.class),
                id);
    }

}
