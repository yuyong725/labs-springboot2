package cn.javadog.labs.springboot2.quartz.jdbc;

import cn.javadog.labs.springboot2.quartz.jdbc.job.DemoJob01;
import cn.javadog.labs.springboot2.quartz.jdbc.job.DemoJob02;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 余勇
 * @date 2020年02月18日 11:39:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuartzJdbcApplication.class)
public class QuartzSchedulerTest {

	@Autowired
	private Scheduler scheduler;

	@Test
	public void addDemoJob01Config() throws SchedulerException {
		// 创建 JobDetail
		JobDetail jobDetail = JobBuilder.newJob(DemoJob01.class)
			.withIdentity("demoJob0001") // 名字为 demoJob001
			.storeDurably() // 没有 Trigger 关联的时候任务是否被保留。因为创建 JobDetail 时，还没 Trigger 指向它，所以需要设置为 true ，表示保留。
			.build();
		// 创建 Trigger
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
			.withIntervalInSeconds(5) // 频率。
			.repeatForever(); // 次数。
		Trigger trigger = TriggerBuilder.newTrigger()
			.forJob(jobDetail) // 对应 Job 为 demoJob01
			.withIdentity("demoJob0001Trigger") // 名字为 demoJob01Trigger
			.withSchedule(scheduleBuilder) // 对应 Schedule 为 scheduleBuilder
			.build();
		// 添加调度任务
		scheduler.scheduleJob(jobDetail, trigger);
//        scheduler.scheduleJob(jobDetail, Sets.newSet(trigger), true);
	}

	@Test
	public void addDemoJob02Config() throws SchedulerException {
		// 创建 JobDetail
		JobDetail jobDetail = JobBuilder.newJob(DemoJob02.class)
			.withIdentity("demoJob0002") // 名字为 demoJob002
			.storeDurably() // 没有 Trigger 关联的时候任务是否被保留。因为创建 JobDetail 时，还没 Trigger 指向它，所以需要设置为 true ，表示保留。
			.build();
		// 创建 Trigger
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ? *");
		Trigger trigger = TriggerBuilder.newTrigger()
			.forJob(jobDetail) // 对应 Job 为 demoJob01
			.withIdentity("demoJob0002Trigger") // 名字为 demoJob01Trigger
			.withSchedule(scheduleBuilder) // 对应 Schedule 为 scheduleBuilder
			.build();
		// 添加调度任务
		scheduler.scheduleJob(jobDetail, trigger);
//        scheduler.scheduleJob(jobDetail, Sets.newSet(trigger), true);
	}

}
