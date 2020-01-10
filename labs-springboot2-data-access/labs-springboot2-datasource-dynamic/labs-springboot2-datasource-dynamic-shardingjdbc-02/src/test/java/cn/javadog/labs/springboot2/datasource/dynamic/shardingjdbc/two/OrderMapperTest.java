package cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.two;

import cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.two.dataobject.OrderDO;
import cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.two.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 测试从库的负载均衡
     */
    @Test
    public void testSelectById() {
        for (int i = 0; i < 10; i++) {
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    /**
     * 测试强制访问主库
     */
    @Test
    public void testSelectById02() {
        try (HintManager hintManager = HintManager.getInstance()) {
            // 设置强制访问主库
            hintManager.setMasterRouteOnly();
            // 执行查询
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    /**
     * 插入
     */
    @Test
    public void testInsert() {
        OrderDO order = new OrderDO();
        order.setUserId(10);
        orderMapper.insert(order);
    }

}
