package cn.javadog.labs.springboot2.datasource.dynamic.jpa.repository.orders;

import cn.javadog.labs.springboot2.datasource.dynamic.jpa.dataobject.OrderDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author 余勇
 * @date 2020-01-10 20:07
 */
public interface OrderRepository extends CrudRepository<OrderDO, Integer> {

}
