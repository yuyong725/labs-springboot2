package cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.two;

import cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.two.dataobject.OrderDO;
import cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.two.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testAdd() {
        OrderDO order = new OrderDO();
        order.setUserId(20);
        orderService.add(order);
    }

    @Test
    public void testFindById() {
        OrderDO order = orderService.findById(1);
        System.out.println(order);
        order = orderService.findById(1);
        System.out.println(order);
        order = orderService.findById(1);
        System.out.println(order);
    }

}
