package cn.javadog.labs.springboot2.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import cn.javadog.labs.springboot2.springmvc.dto.UserAddDTO;
import cn.javadog.labs.springboot2.springmvc.dto.UserUpdateDTO;
import cn.javadog.labs.springboot2.springmvc.service.UserService;
import cn.javadog.labs.springboot2.springmvc.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余勇
 * @date 2020-01-05 22:41
 * 用户 Controller
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("")
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
    @GetMapping("/{id}")
    public UserVO get(@PathVariable("id") Integer id) {
        // 查询并返回用户
        return new UserVO().setId(id).setUsername("username:" + id);
    }

    /**
     * 获得指定用户编号的用户
     *
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/v2/{id}")
    public UserVO get2(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    /**
     * 添加用户
     *
     * @param addDTO 添加用户信息 DTO
     * @return 添加成功的用户编号
     */
    @PostMapping("")
    public Integer add(UserAddDTO addDTO) {
        // 插入用户记录，返回编号
        Integer returnId = 1;
        // 返回用户编号
        return returnId;
    }

    /**
     * 更新指定用户编号的用户
     *
     * @param id 用户编号
     * @param updateDTO 更新用户信息 DTO
     * @return 是否修改成功
     */
    @PutMapping("/{id}")
    public Boolean update(@PathVariable("id") Integer id, UserUpdateDTO updateDTO) {
        // 将 id 设置到 updateDTO 中
        updateDTO.setId(id);
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
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        // 删除用户记录
        Boolean success = false;
        // 返回是否更新成功
        return success;
    }

}
