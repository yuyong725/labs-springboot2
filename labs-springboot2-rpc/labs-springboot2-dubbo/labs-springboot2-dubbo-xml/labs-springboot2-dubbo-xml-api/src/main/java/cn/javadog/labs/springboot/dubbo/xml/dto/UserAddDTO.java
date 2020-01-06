package cn.javadog.labs.springboot.dubbo.xml.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * @author 余勇
 * @date 2020-01-06 19:53
 * 用户添加 DTO
 */
@Data
@Accessors(chain = true)
public class UserAddDTO implements Serializable {

    /**
     * 昵称
     */
    @NotEmpty(message = "昵称不能为空")
    @Length(min = 5, max = 16, message = "账号长度为 5-16 位")
    private String name;
    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    private Integer gender;

}
