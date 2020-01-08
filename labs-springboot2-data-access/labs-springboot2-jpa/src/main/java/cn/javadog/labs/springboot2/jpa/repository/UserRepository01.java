package cn.javadog.labs.springboot2.jpa.repository;

import cn.javadog.labs.springboot2.jpa.dataobject.UserDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author 余勇
 * @date 2020-01-08 17:00
 * 增删改查
 */
public interface UserRepository01 extends CrudRepository<UserDO, Integer> {

}
