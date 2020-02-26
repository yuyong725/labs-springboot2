package cn.javadog.labs.springboot2.unittest.simple.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-02-26 15:39
 */
@Data
@Accessors(chain = true)
public class UserDO {

	/**
	 * 用户编号
	 */
	private Integer id;
	/**
	 * 账号
	 */
	private String username;
	/**
	 * 密码（明文）
	 *
	 * ps：生产环境下，千万不要明文噢
	 */
	private String password;

}
