package cn.javadog.labs.springboot2.jdbctemplate.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.javadog.labs.springboot2.jdbctemplate.JdbcTemplateApplication;
import cn.javadog.labs.springboot2.jdbctemplate.dataobject.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JdbcTemplateApplication.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testInsert() {
        UserDO user = new UserDO().setUsername(UUID.randomUUID().toString())
                .setPassword("123456").setCreateTime(new Date());
        userDao.insert(user);
        System.out.println(user);
    }

    @Test
    public void testInsert0() {
        UserDO user = new UserDO().setUsername(UUID.randomUUID().toString())
                .setPassword("123456").setCreateTime(new Date());
        userDao.insert0(user);
        System.out.println(user);
    }

    @Test
    public void testUpdateById() {
        UserDO updateUser = new UserDO().setId(5)
                .setPassword("123456789");
        userDao.updateById(updateUser);
    }

    @Test
    public void testDeleteById() {
        userDao.deleteById(4);
    }

    @Test
    public void testSelectById() {
        UserDO user = userDao.selectById(5);
        System.out.println(user);
    }

    @Test
    public void testSelectByUsername() {
        UserDO user = userDao.selectByUsername("123456");
        // 找不到就会GG
        System.out.println(user);
    }

    @Test
    public void testSelectByIds() {
        List<UserDO> users = userDao.selectByIds(Arrays.asList(1, 5));
        System.out.println("users：" + users.size());
    }

}
