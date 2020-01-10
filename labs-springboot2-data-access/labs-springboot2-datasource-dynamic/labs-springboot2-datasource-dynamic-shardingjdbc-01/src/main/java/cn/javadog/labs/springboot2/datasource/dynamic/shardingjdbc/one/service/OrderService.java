package cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.one.service;

import cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.one.dataobject.OrderDO;
import cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.one.dataobject.UserDO;
import cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.one.mapper.OrderMapper;
import cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.one.mapper.UserMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 余勇
 * @date 2020-01-10 21:34
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;

    private OrderService self() {
        return (OrderService) AopContext.currentProxy();
    }

    public void method01() {
        // 查询订单
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void method02() {
        // 查询订单
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

    public void method03() {
        // 查询订单
        self().method031();
        // 查询用户
        self().method032();
    }

    @Transactional(rollbackFor = Exception.class)
    public void method031() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional(rollbackFor = Exception.class)
    public void method032() {
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void method05() {
        // 查询订单
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        self().method052();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void method052() {
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

}
