package cn.javadog.labs.springboot2.datasource.dynamic.baomidou.one.mapper;

import cn.javadog.labs.springboot2.datasource.dynamic.baomidou.one.constant.DBConstants;
import cn.javadog.labs.springboot2.datasource.dynamic.baomidou.one.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * @author 余勇
 * @date 2020-01-10 15:04
 */
@Repository
@DS(DBConstants.DATASOURCE_USERS)
public interface UserMapper {

    UserDO selectById(@Param("id") Integer id);

}
