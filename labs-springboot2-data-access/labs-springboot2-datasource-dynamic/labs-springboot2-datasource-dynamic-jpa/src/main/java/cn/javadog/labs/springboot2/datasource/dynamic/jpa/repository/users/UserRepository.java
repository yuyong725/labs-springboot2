package cn.javadog.labs.springboot2.datasource.dynamic.jpa.repository.users;


import cn.javadog.labs.springboot2.datasource.dynamic.jpa.dataobject.UserDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author 余勇
 * @date 2020-01-10 20:07
 */
public interface UserRepository extends CrudRepository<UserDO, Integer> {

}
