package cn.javadog.labs.springboot2.druid.single.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.druid.stat.DruidStatManagerFacade;

/**
 * @author 余勇
 * @date 2020-01-07 19:27
 * 测试类
 */
@RestController
public class DruidStatController {

    @GetMapping("/monitor/druid/stat")
    @Deprecated
    public Object druidStat(){
        // `DruidStatManagerFacade#getDataSourceStatDataList()` 方法，可以获取所有数据源的监控数据。
        // 除此之外，DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }

}
