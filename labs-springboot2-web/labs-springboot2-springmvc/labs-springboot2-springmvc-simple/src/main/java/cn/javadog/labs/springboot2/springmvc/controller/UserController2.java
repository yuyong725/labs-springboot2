package cn.javadog.labs.springboot2.springmvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.javadog.labs.springboot2.springmvc.dto.UserAddDTO;
import cn.javadog.labs.springboot2.springmvc.dto.UserUpdateDTO;
import cn.javadog.labs.springboot2.springmvc.vo.UserVO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余勇
 * @date 2020-01-05 22:39
 * 用户2 Controller
 */
@RestController
@RequestMapping("/users2")
public class UserController2 {

    /**
     * 查询用户列表
     */
    @GetMapping("/list")
    public List<UserVO> list() {
        // 查询列表
        List<UserVO> result = new ArrayList();
        result.add(new UserVO().setId(1).setUsername("calm"));
        result.add(new UserVO().setId(2).setUsername("handsome"));
        result.add(new UserVO().setId(3).setUsername("awesome"));
        // 返回列表
        return result;
    }

    /**
     * 获得指定用户编号的用户
     *
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/get")
    public UserVO get(@RequestParam("id") Integer id) {
        // 查询并返回用户
        return new UserVO().setId(id).setUsername(UUID.randomUUID().toString());
    }

    /**
     * 添加用户
     *
     * @param addDTO 添加用户信息 DTO
     * @return 添加成功的用户编号
     */
    @PostMapping("add")
    public Integer add(UserAddDTO addDTO) {
        // 插入用户记录，返回编号
        Integer returnId = UUID.randomUUID().hashCode();
        // 返回用户编号
        return returnId;
    }

    /**
     * 更新指定用户编号的用户
     *
     * @param updateDTO 更新用户信息 DTO
     * @return 是否修改成功
     */
    @PostMapping("/update")
    public Boolean update(UserUpdateDTO updateDTO) {
        // 更新用户记录
        Boolean success = true;
        // 返回更新是否成功
        return success;
    }

    /**
     * 删除指定用户编号的用户
     *
     * @param id 用户编号
     * @return 是否删除成功
     */
    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam("id") Integer id) {
        // 删除用户记录
        Boolean success = false;
        // 返回是否更新成功
        return success;
    }

}
