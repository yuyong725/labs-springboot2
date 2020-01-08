package cn.javadog.labs.springboot2.mybatis.xml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余勇
 * @date 2020年01月08日 11:34:00
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.javadog.labs.springboot2.mybatis.xml.mapper")
public class MyBatisXmlApplication {

}
