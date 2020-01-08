package cn.javadog.labs.springboot2.mybatis.tk.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author 余勇
 * @date 2020-01-08 13:34
 * 自定义mapper，根据需要继承相关通用mapper
 * 注意不要和其他的mapper放在一个包下，因为有范性，没法实例化
 */
public interface IMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
