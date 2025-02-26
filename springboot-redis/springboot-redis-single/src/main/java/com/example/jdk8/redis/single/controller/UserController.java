package com.example.jdk8.redis.single.controller;

import com.example.jdk8.enums.CommonEnum;
import com.example.jdk8.redis.single.entity.User;
import com.example.jdk8.redis.single.model.vo.UserAddVo;
import com.example.jdk8.redis.single.service.UserService;
import com.example.jdk8.result.ResultBody;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Description : TODO
 * @Author : zhaojh
 * @Date : 2025/2/11 17:29
 */

@RequestMapping("/user")
@RestController
public class UserController {


    @Resource(name = "userServiceImpl")
    private UserService userService;

    @PostMapping(value = "/addUser")
    public ResultBody<String> addUser(@RequestBody @Valid UserAddVo userAddVo){
        User user =new User();
        BeanUtils.copyProperties(userAddVo,user);
        userService.addUser(user);
        return ResultBody.success(CommonEnum.SUCCESS);
    }


}
