package cn.javadog.labs.springboot2.datasource.dynamic.jpa;

import cn.javadog.labs.springboot2.datasource.dynamic.jpa.dataobject.OrderDO;
import cn.javadog.labs.springboot2.datasource.dynamic.jpa.repository.orders.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testSelectById() {
        OrderDO order = orderRepository.findById(1)
                .orElse(null); // 为空，则返回 null
        System.out.println(order);
    }

}
