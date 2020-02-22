package cn.javadog.labs.springboot2.apollo.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 余勇
 * @date 2020年02月22日 19:45:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptTest {

	@Autowired
	private StringEncryptor encryptor;

	@Test
	public void encode() {
		String applicationName = "demo-application";
		System.out.println(encryptor.encrypt(applicationName));
	}

	@Value("${spring.application.name}")
	private String applicationName;

	@Test
	public void print() {
		System.out.println(applicationName);
	}

}
