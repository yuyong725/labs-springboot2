package cn.javadog.labs.springboot2.apollo.multi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 余勇
 * @date 2020年02月22日 20:04:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiConfigTest {

	@Value("${test01}")
	private String test01;

	@Value("${test02}")
	private String test02;

	@Test
	public void print() {
		System.out.println(test01);
		System.out.println(test02);
	}

}
