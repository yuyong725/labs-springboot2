package cn.javadog.labs.springboot2.datasource.dynamic.baomidou.two.service;

import java.util.Objects;

import cn.javadog.labs.springboot2.datasource.dynamic.baomidou.two.constant.DBConstants;
import cn.javadog.labs.springboot2.datasource.dynamic.baomidou.two.dataobject.OrderDO;
import cn.javadog.labs.springboot2.datasource.dynamic.baomidou.two.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * @author 余勇
 * @date 2020-01-10 18:25
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional(rollbackFor = Exception.class)
    @DS(DBConstants.DATASOURCE_MASTER)
    public void add(OrderDO order) {
        // 这里先假模假样的读取一下，
        OrderDO exists = orderMapper.selectByUserId(order.getUserId());
        System.out.println(exists);
        if (Objects.isNull(exists)) {
            // 插入订单
            orderMapper.insert(order);
        }
    }

    public OrderDO findById(Integer id) {
        return orderMapper.selectByUserId(id);
    }

}
