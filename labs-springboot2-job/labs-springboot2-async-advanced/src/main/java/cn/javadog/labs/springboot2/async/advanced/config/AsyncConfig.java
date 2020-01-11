package cn.javadog.labs.springboot2.async.advanced.config;

import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author 余勇
 * @date 2020-01-11 19:57
 * 异步配置
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    public static final String EXECUTOR_ONE_BEAN_NAME = "executor-one";
    public static final String EXECUTOR_TWO_BEAN_NAME = "executor-two";

    @Configuration
    public static class ExecutorOneConfiguration {

        @Bean(name = EXECUTOR_ONE_BEAN_NAME + "-properties")
        @Primary
        @ConfigurationProperties(prefix = "spring.task.execution-one") // 读取 spring.task.execution-one 配置到 TaskExecutionProperties 对象
        public TaskExecutionProperties taskExecutionProperties() {
            return new TaskExecutionProperties();
        }

        @Bean(name = EXECUTOR_ONE_BEAN_NAME)
        @ConfigurationProperties(prefix = "spring.task.execution-one.shutdown")
        public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
            // 创建 TaskExecutorBuilder 对象
            TaskExecutorBuilder builder = createTskExecutorBuilder(this.taskExecutionProperties());
            // 创建 ThreadPoolTaskExecutor 对象
            return builder.build();
        }

    }

    @Configuration
    public static class ExecutorTwoConfiguration {

        @Bean(name = EXECUTOR_TWO_BEAN_NAME + "-properties")
        @ConfigurationProperties(prefix = "spring.task.execution-two") // 读取 spring.task.execution-two 配置到 TaskExecutionProperties 对象
        public TaskExecutionProperties taskExecutionProperties() {
            return new TaskExecutionProperties();
        }

        /**
         * 2.1.0的版本没有 shutdown
         */
        @Bean(name = EXECUTOR_TWO_BEAN_NAME)
        @ConfigurationProperties(prefix = "spring.task.execution-two.shutdown")
        public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
            // 创建 TaskExecutorBuilder 对象
            TaskExecutorBuilder builder = createTskExecutorBuilder(this.taskExecutionProperties());
            // 创建 ThreadPoolTaskExecutor 对象
            return builder.build();

        }
    }

    private static TaskExecutorBuilder createTskExecutorBuilder(TaskExecutionProperties properties) {
        // Pool 属性
        TaskExecutionProperties.Pool pool = properties.getPool();
        TaskExecutorBuilder builder = new TaskExecutorBuilder();
        builder = builder.queueCapacity(pool.getQueueCapacity());
        builder = builder.corePoolSize(pool.getCoreSize());
        builder = builder.maxPoolSize(pool.getMaxSize());
        builder = builder.allowCoreThreadTimeOut(pool.isAllowCoreThreadTimeout());
        builder = builder.keepAlive(pool.getKeepAlive());

        // 其它基本属性
        builder = builder.threadNamePrefix(properties.getThreadNamePrefix());
        return builder;
    }

}
