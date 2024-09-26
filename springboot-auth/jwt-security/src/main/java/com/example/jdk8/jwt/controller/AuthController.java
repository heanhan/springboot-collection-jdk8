package com.example.jdk8.jwt.controller;

import com.example.jdk8.jwt.common.utils.JwtUtil;
import com.example.jdk8.jwt.entity.UserAuth;
import com.example.jdk8.jwt.model.vo.RegisterUserVo;
import com.example.jdk8.jwt.model.vo.UserLoginVo;
import com.example.jdk8.jwt.service.UserAuthService;
import com.example.jdk8.result.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author zhaojh
 * @description: 认证控制器
 * @date 2024-09-24
 */

@Slf4j
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private UserAuthService userAuthService;

    /**
     * 用户登录
     *
     * @param loginVo 表单的参数
     * @return 用户的令牌
     */
    @PostMapping(value = "/login")
    public ResultBody<Object> login(@RequestBody UserLoginVo loginVo) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 判空
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码有误");
        }
        // 从认证成功的Authentication对象中获取principal，将其强制转换为LoginUser类型，进而得到用户账号userAccount。
        UserAuth loginUser = (UserAuth)authenticate.getPrincipal();
        // 通过 Jwt 工具类 使用 userAccount 生成 token
        String jwt = jwtUtil.createJWT(loginUser.getUsername());
        // 将 authenticate 存入 redis
//        redisTemplate.opsForValue().set(loginUser.getId()+loginUser.getUsername(),jwt);
        return ResultBody.success(jwt);
    }

    @PostMapping(value = "/registerUser")
    public ResultBody registerUser(@RequestBody RegisterUserVo registerUserVo){
        Boolean flag = userAuthService.registerUser(registerUserVo);
        if (!flag){
            return ResultBody.error("用户注册失败");
        }
        return ResultBody.success("用户注册成功");
    }

    /**
     * 用户注销
     *
     * @return
     */
    @PostMapping(value = "/logout")
    public ResultBody<Object> logout() {
        // 从 存储权限的集合SecurityContextHolder内将获取到Authentication对象。里面包含已认证的用户信息，权限集合等。
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 从 获取到的对象内 取出 已认证的主体
        UserAuth loginUser = (UserAuth) authentication.getPrincipal();
        // 从被认证的主体内取出用户名
        String userAccount = loginUser.getId()+loginUser.getUsername();
        // 根据键为用户名userAccount删除对应的用户信息
//        redisTemplate.opsForValue()
        return ResultBody.success("退出成功");
    }
}
