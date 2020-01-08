package cn.javadog.labs.springboot2.jpa.repository;

import java.util.Date;

import cn.javadog.labs.springboot2.jpa.dataobject.UserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author 余勇
 * @date 2020-01-08 16:59
 * find 自动组装
 */
public interface UserRepository03 extends PagingAndSortingRepository<UserDO, Integer> {

    UserDO findByUsername(String username);

    Page<UserDO> findByCreateTimeAfter(Date createTime, Pageable pageable);

}
