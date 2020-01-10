package cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.two.service;

import cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.two.dataobject.OrderDO;
import cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.two.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 余勇
 * @date 2020-01-10 22:32
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional(rollbackFor = Exception.class)
    public void add(OrderDO order) {
        // 这里先假模假样的读取一下。读取从库
        OrderDO exists = orderMapper.selectById(1);
        System.out.println(exists);

        // 插入订单
        orderMapper.insert(order);

        // 这里先假模假样的读取一下。读取主库
        exists = orderMapper.selectById(1);
        System.out.println(exists);
    }

    public OrderDO findById(Integer id) {
        return orderMapper.selectById(id);
    }

}
