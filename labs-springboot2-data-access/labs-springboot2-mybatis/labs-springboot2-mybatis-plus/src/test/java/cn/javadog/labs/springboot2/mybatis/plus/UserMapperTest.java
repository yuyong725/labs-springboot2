package cn.javadog.labs.springboot2.mybatis.plus;

import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.javadog.labs.springboot2.mybatis.plus.dataobject.UserDO;
import cn.javadog.labs.springboot2.mybatis.plus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisPlusApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDO user = new UserDO().setUsername(UUID.randomUUID().toString())
                .setPassword("mybatis-plus")
                .setCreateTime(new Date())
                // 一般情况下，是否删除，可以全局枚举下。
                .setDeleted(0);
        userMapper.insert(user);
    }

    @Test
    public void testUpdateById() {
        UserDO updateUser = new UserDO().setId(7)
                .setPassword("mybatis-plus-update");
        userMapper.updateById(updateUser);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(7);
    }

    @Test
    public void testSelectById() {
        userMapper.selectById(8);
    }

    @Test
    public void testSelectByUsername() {
        userMapper.selectByUsername("calm");
    }

    /**
     * 不走逻辑删除
     */
    @Test
    public void testSelectByIds() {
        List<UserDO> users = userMapper.selectByIds(Arrays.asList(7, 8));
        System.out.println("users：" + users.size());
    }

    /**
     * 走逻辑删除
     */
    @Test
    public void testSelectByIds2() {
        List<UserDO> users = userMapper.selectByIdsWithWrapper(Arrays.asList(7, 8));
        System.out.println("users：" + users.size());
    }

    @Test
    public void testSelectPageByCreateTime() {
        IPage<UserDO> page = new Page<>(1, 10);
        // 临时 Demo ，实际不建议这么写
        Date createTime = new Date(2020 - 1900, Calendar.JANUARY, 8);
        page = userMapper.selectPageByCreateTime(page, createTime);
        System.out.println("users：" + page.getRecords().size());
    }

}
