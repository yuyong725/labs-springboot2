package cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.service;

import cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.constant.DBConstants;
import cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.dao.OrderDao;
import cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.dao.UserDao;
import cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.dataobject.OrderDO;
import cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.dataobject.UserDO;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 余勇
 * @date 2020-01-10 20:56
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    private OrderService self() {
        return (OrderService) AopContext.currentProxy();
    }

    public void method01() {
        // 查询订单
        OrderDO order = orderDao.selectById(1);
        System.out.println(order);
        // 查询用户
        UserDO user = userDao.selectById(1);
        System.out.println(user);
    }

    /**
     * 报错，找不到事务管理器
     */
    @Transactional(rollbackFor = Exception.class)
    public void method02() {
        // 查询订单
        OrderDO order = orderDao.selectById(1);
        System.out.println(order);
        // 查询用户
        UserDO user = userDao.selectById(1);
        System.out.println(user);
    }

    public void method03() {
        // 查询订单
        self().method031();
        // 查询用户
        self().method032();
    }

    @Transactional(transactionManager = DBConstants.TX_MANAGER_ORDERS, rollbackFor = Exception.class)
    public void method031() {
        OrderDO order = orderDao.selectById(1);
        System.out.println(order);
    }

    @Transactional(transactionManager = DBConstants.TX_MANAGER_USERS, rollbackFor = Exception.class)
    public void method032() {
        UserDO user = userDao.selectById(1);
        System.out.println(user);
    }

    @Transactional(transactionManager = DBConstants.TX_MANAGER_ORDERS, rollbackFor = Exception.class)
    public void method05() {
        // 查询订单
        OrderDO order = orderDao.selectById(1);
        System.out.println(order);
        // 查询用户
        self().method052();
    }

    @Transactional(transactionManager = DBConstants.TX_MANAGER_USERS,
            propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void method052() {
        UserDO user = userDao.selectById(1);
        System.out.println(user);
    }

}
