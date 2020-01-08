package cn.javadog.labs.springboot2.jpa;

import javax.transaction.Transactional;

import cn.javadog.labs.springboot2.jpa.dataobject.UserDO;
import cn.javadog.labs.springboot2.jpa.repository.UserRepository04;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepository04Test {

    @Autowired
    private UserRepository04 userRepository;

    @Test
    public void testFindIdByUsername01() {
        UserDO user = userRepository.findByUsername01("calm");
        System.out.println(user);
    }

    @Test
    public void testFindIdByUsername02() {
        UserDO user = userRepository.findByUsername02("calm");
        System.out.println(user);
    }

    @Test
    public void testFindIdByUsername03() {
        UserDO user = userRepository.findByUsername03("calm");
        System.out.println(user);
    }

    /**
     * 更新操作，需要在事务中，不加@Transactional会直接GG
     * 在单元测试中，事务默认回滚，所以胖友可能怎么测试，事务都不更新。
     * 可以添加 @Rollback(value = false) 指定不回滚，这会导致 @Transactional 不生效，即使报错也不回滚
     * 也就是说，回滚/不回滚完全取决于 @Rollback 的值，但你又必须加上 @Transactional，有趣吧，哈哈
     */
    @Test
    @Transactional
    public void testUpdateUsernameById() {
        userRepository.updateUsernameById(5, "calm-update3");
        // throw new RuntimeException("指定@Rollback(value = false)，测试报错回滚");
    }

}
