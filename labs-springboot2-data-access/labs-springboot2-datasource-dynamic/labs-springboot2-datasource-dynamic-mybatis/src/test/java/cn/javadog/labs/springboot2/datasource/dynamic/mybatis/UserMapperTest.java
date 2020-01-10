package cn.javadog.labs.springboot2.datasource.dynamic.mybatis;

import cn.javadog.labs.springboot2.datasource.dynamic.mybatis.dataobject.UserDO;
import cn.javadog.labs.springboot2.datasource.dynamic.mybatis.mapper.users.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById() {
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

}
