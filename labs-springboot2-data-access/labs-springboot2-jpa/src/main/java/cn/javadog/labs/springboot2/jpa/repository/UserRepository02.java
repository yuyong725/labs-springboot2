package cn.javadog.labs.springboot2.jpa.repository;

import cn.javadog.labs.springboot2.jpa.dataobject.UserDO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author 余勇
 * @date 2020-01-08 17:01
 * 分页
 */
public interface UserRepository02 extends PagingAndSortingRepository<UserDO, Integer> {

}
