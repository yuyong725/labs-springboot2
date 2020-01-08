package cn.javadog.labs.springboot2.mybatis.annotation;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.javadog.labs.springboot2.mybatis.annotation.dataobject.UserDO;
import cn.javadog.labs.springboot2.mybatis.annotation.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisAnnotationApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDO user = new UserDO().setUsername(UUID.randomUUID().toString())
                .setPassword("mybatis-annotation-testInsert").setCreateTime(new Date());
        userMapper.insert(user);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateById() {
        UserDO updateUser = new UserDO().setId(1)
                .setPassword("mybatis-annotation-testUpdate");
        userMapper.updateById(updateUser);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(2);
    }

    @Test
    public void testSelectById() {
        userMapper.selectById(1);
    }

    @Test
    public void testSelectByUsername() {
        userMapper.selectByUsername("calm");
    }

    @Test
    public void testSelectByIds() {
        List<UserDO> users = userMapper.selectByIds(Arrays.asList(1, 3));
        System.out.println("users：" + users.size());
    }

}
