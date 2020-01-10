package cn.javadog.labs.springboot2.datasource.dynamic.mybatis;

import cn.javadog.labs.springboot2.datasource.dynamic.mybatis.dataobject.OrderDO;
import cn.javadog.labs.springboot2.datasource.dynamic.mybatis.mapper.orders.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

}
