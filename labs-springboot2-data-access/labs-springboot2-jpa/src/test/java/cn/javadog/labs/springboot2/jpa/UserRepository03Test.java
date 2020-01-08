package cn.javadog.labs.springboot2.jpa;

import java.util.Calendar;
import java.util.Date;

import cn.javadog.labs.springboot2.jpa.dataobject.UserDO;
import cn.javadog.labs.springboot2.jpa.repository.UserRepository03;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepository03Test {

    @Autowired
    private UserRepository03 userRepository;

    @Test
    public void testFindByUsername() {
        UserDO user = userRepository.findByUsername("calm");
        System.out.println(user);
    }

    @Test
    public void testFindByCreateTimeAfter() {
        // 创建分页条件
        Pageable pageable = PageRequest.of(1, 5);
        // 临时 Demo ，实际不建议这么写
        Date createTime = new Date(2020 - 1900, Calendar.JANUARY, 8);
        // 执行分页操作
        Page<UserDO> page = userRepository.findByCreateTimeAfter(createTime, pageable);
        // 打印
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
    }

}
