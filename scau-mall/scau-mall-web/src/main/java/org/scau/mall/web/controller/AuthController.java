package org.scau.mall.web.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.scau.mall.service.pojo.PmsUser;
import org.scau.mall.vo.resp.CommonRespone;
import org.scau.mall.web.controller.user.UserController;
import org.scau.mall.web.security.pojo.LoginDto;
import org.scau.mall.web.security.service.IUserService;
import org.scau.mall.web.vo.UsersVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public CommonRespone<PmsUser> registerUser(@RequestBody Map<String, String> registerUser) {
        PmsUser user = new PmsUser();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setUsername(registerUser.get("username"));
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setMobile(registerUser.get("mobile"));
        user.setEmail(registerUser.get("email"));
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        user.setStatus(1);
        //user.setRole(registerUser.get("role"));
        int i = userService.insertSelective(user);
        if (i < 1) {
            return CommonRespone.failed("注册失败");
        }
        return CommonRespone.success("注册成功", user);
    }

    @PostMapping("/login")
    public CommonRespone<UsersVo> login(@RequestBody LoginDto adminLoginParam, HttpServletRequest request) {
        UsersVo vo = null;
        try {
            vo = userService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword(), request);
        } catch (Exception e) {
            logger.error("登录异常，异常信息={}", e.getMessage());
            return CommonRespone.failed("登录失败，" + e.getMessage());
        }
        return CommonRespone.success(vo);
    }
    
    //测试只有登录拿到token才能拿到数据
    @GetMapping("/get")
    public String aaa() {
        return  "token验证通过了";
 } }
