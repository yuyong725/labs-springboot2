package cn.javadog.labs.springboot2.jpa;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import cn.javadog.labs.springboot2.jpa.dataobject.UserDO;
import cn.javadog.labs.springboot2.jpa.repository.UserRepository01;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepository01Test {

    @Autowired
    private UserRepository01 userRepository;

    /**
     * 插入一条记录
     */
    @Test
    public void testSave() {
        UserDO user = new UserDO().setUsername(UUID.randomUUID().toString())
                .setPassword("jpa-save").setCreateTime(new Date());
        userRepository.save(user);
    }

    /**
     * 更新一条记录
     */
    @Test
    public void testUpdate() {
        // 先查询一条记录
        Optional<UserDO> userDO = userRepository.findById(1);
        Assert.isTrue(userDO.isPresent(), "记录不能为空");
        // 更新一条记录
        UserDO updateUser = userDO.get();
        updateUser.setPassword("jpa-update").setUsername("calm");
        userRepository.save(updateUser);
    }

    /**
     * 根据 ID 编号，删除一条记录
     */
    @Test
    public void testDelete() {
        userRepository.deleteById(2);
    }

    /**
     * 根据 ID 编号，查询一条记录
     */
    @Test
    public void testSelectById() {
        Optional<UserDO> userDO = userRepository.findById(1);
        System.out.println(userDO.get());
    }

    /**
     * 根据 ID 编号数组，查询多条记录
     */
    @Test
    public void testSelectByIds() {
        Iterable<UserDO> users = userRepository.findAllById(Arrays.asList(1, 4));
        users.forEach(System.out::println);
    }

}
