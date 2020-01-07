package cn.javadog.labs.springboot.dubbo.xml.consumer;

import javax.annotation.Resource;

import cn.javadog.labs.springboot.dubbo.xml.api.UserRpcService;
import cn.javadog.labs.springboot.dubbo.xml.dto.UserAddDTO;
import cn.javadog.labs.springboot.dubbo.xml.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020-01-06 20:14
 * 启动类
 */
@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
public class ConsumerApplication {

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(ConsumerApplication.class, args);
    }

    /**
     * 启动后立即会执行
     */
    @Component
    public class UserRpcServiceTest implements CommandLineRunner {

        private final Logger logger = LoggerFactory.getLogger(getClass());

        @Resource
        private UserRpcService userRpcService;

        @Override
        public void run(String... args) throws Exception {
            UserDTO user = userRpcService.get(1);
            logger.info("[run][发起一次 Dubbo RPC 请求，获得用户为({})]", user);
        }

    }

     @Component
    public class UserRpcServiceTest02 implements CommandLineRunner {

        private final Logger logger = LoggerFactory.getLogger(getClass());

        @Resource
        private UserRpcService userRpcService;

        @Override
        public void run(String... args) throws Exception {
            // 获得用户
            try {
                // 发起调用
                UserDTO user = userRpcService.get(null); // 故意传入空的编号，为了校验编号不通过
                logger.info("[run][发起一次 Dubbo RPC 请求，获得用户为({})]", user);
            } catch (Exception e) {
                logger.error("[run][获得用户发生异常，信息为:[{}]", e.getMessage());
            }

            // 添加用户
            try {
                // 创建 UserAddDTO
                UserAddDTO addDTO = new UserAddDTO();
                // 故意把名字打的特别长，为了校验名字不通过
                addDTO.setName("i am so handsome!handsome!handsome!");
                addDTO.setGender(null); // 不传递性别，为了校验性别不通过
                // 发起调用
                userRpcService.add(addDTO);
                logger.info("[run][发起一次 Dubbo RPC 请求，添加用户为({})]", addDTO);
            } catch (Exception e) {
                logger.error("[run][添加用户发生异常，信息为:[{}]", e.getMessage());
            }
        }

    }

    @Component
    public class UserRpcServiceTest03 implements CommandLineRunner {

        private final Logger logger = LoggerFactory.getLogger(getClass());

        @Resource
        private UserRpcService userRpcService;

        @Override
        public void run(String... args) {
            // 添加用户
            try {
                // 创建 UserAddDTO
                UserAddDTO addDTO = new UserAddDTO();
                // 设置为 ERROR_NAME ，触发 ServiceException 异常
                addDTO.setName(UserRpcService.ERROR_NAME);
                addDTO.setGender(1);
                // 发起调用
                userRpcService.add(addDTO);
                logger.info("[run][发起一次 Dubbo RPC 请求，添加用户为({})]", addDTO);
            } catch (Exception e) {
                logger.error("[run][添加用户发生异常({})，信息为:[{}]", e.getClass().getSimpleName(), e.getMessage());
            }
        }

    }

}
