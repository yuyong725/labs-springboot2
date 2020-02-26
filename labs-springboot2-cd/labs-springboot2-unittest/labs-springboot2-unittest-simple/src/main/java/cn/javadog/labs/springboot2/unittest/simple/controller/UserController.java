package cn.javadog.labs.springboot2.unittest.simple.controller;

import cn.javadog.labs.springboot2.unittest.simple.dataobject.UserDO;
import cn.javadog.labs.springboot2.unittest.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余勇
 * @date 2020年02月26日 15:35:00
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 获得指定用户编号的用户
	 *
	 * @param id 用户编号
	 * @return 用户
	 */
	@GetMapping("/get")
	public UserDO get(@RequestParam("id") Integer id) {
		// 查询并返回用户
		return userService.get(id);
	}

}
