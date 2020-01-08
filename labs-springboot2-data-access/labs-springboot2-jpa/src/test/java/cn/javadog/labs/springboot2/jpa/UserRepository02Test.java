package cn.javadog.labs.springboot2.jpa;

import cn.javadog.labs.springboot2.jpa.dataobject.UserDO;
import cn.javadog.labs.springboot2.jpa.repository.UserRepository02;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepository02Test {

    @Autowired
    private UserRepository02 userRepository;

    /**
     * 排序
     */
    @Test
    public void testFindAll() {
        // 创建排序条件
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        // 执行排序操作
        Iterable<UserDO> iterable = userRepository.findAll(sort);
        // 打印
        iterable.forEach(System.out::println);
    }

    /**
     * 分页
     */
    @Test
    public void testFindPage() {
        // 创建排序条件
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        // 创建分页条件，page从0开始
        Pageable pageable = PageRequest.of(1, 5, sort);
        // 执行分页操作
        Page<UserDO> page = userRepository.findAll(pageable);
        // 打印
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        System.out.println(page.getContent().size());
    }

}
