package cn.javadog.labs.springboot2.jpa.repository;

import java.util.Date;

import cn.javadog.labs.springboot2.jpa.dataobject.UserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author 余勇
 * @date 2020-01-08 17:01
 * @Query 手写SQL
 * 《JPQL 的学习》: https://www.jianshu.com/p/4a4410075bab
 * ':' 命名参数
 * '?' 未知参数
 */
public interface UserRepository04 extends PagingAndSortingRepository<UserDO, Integer> {

    @Query("SELECT u FROM UserDO u WHERE u.username = ?1")
    UserDO findByUsername01(String username);

    @Query("SELECT u FROM UserDO u WHERE u.username = :username")
    UserDO findByUsername02(@Param("username") String username);

    @Query(value = "SELECT * FROM jpa_users u WHERE u.username = :username", nativeQuery = true)
    UserDO findByUsername03(@Param("username") String username);

    @Modifying
    @Query("UPDATE UserDO  u SET u.username = :username WHERE u.id = :id")
    int updateUsernameById(Integer id, String username);

    /**
     * 分页
     * value 属性，编写查询分页列表的 SQL
     * countQuery 属性，编写记录总数的 SQL
     */
    @Query(value = "SELECT * FROM jpa_users WHERE create_time > ?1",
        countQuery = "SELECT count(*) FROM jpa_users WHERE create_time > ?1",
        nativeQuery = true)
    Page<UserDO> findAfterCreateTime(Date createTime, Pageable pageable);

}
