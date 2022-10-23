package org.scau.mall.web.controller.user;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.scau.mall.service.pojo.PmsUser;
import org.scau.mall.vo.resp.CommonRespone;
import org.scau.mall.web.service.UserServiceImpl;
import org.scau.mall.web.vo.PageShowVo;
import org.scau.mall.web.vo.QueryVo;
import org.scau.mall.web.vo.UsersVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制类
 * MenuController: MenuController.java.
 *
 * <br>==========================
 * <br> 公司：广州向日葵信息科技有限公司
 * <br> 开发：John@xiangrikui.com
 * <br> 创建时间：2022年2月2日
 * <br> 修改时间：2022年2月2日
 * <br> 版本：1.0
 * <br> JDK版本：1.8
 * <br>==========================
 */
@RestController
public class UserController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserServiceImpl userService;
    
    @GetMapping("/users")
    public CommonRespone<PageShowVo<UsersVo>> users(QueryVo vo, HttpServletRequest request) {
        PageShowVo<UsersVo> pageVo = null;
        try {
            pageVo = userService.getUsersByPage(vo);
        } catch (Exception e) {
            logger.error("获取用户列表异常，异常信息={}", e.getMessage());
            return CommonRespone.failed("获取用户列表异常");
        }
        return CommonRespone.success(pageVo);
    }
    
    @PostMapping("/users")
    public CommonRespone<UsersVo> addUsers(PmsUser user) {
        UsersVo vo = null;
        try {
            vo = userService.addUser(user);
        } catch (Exception e) {
            logger.error("添加异常，异常信息={}", e.getMessage());
            return CommonRespone.failed("添加用户失败," +e.getMessage());
        }
        return CommonRespone.success(vo);
    }
    
    @PutMapping("/users/{id}/state/{mg_state}")
    public CommonRespone<UsersVo> changeUserStatus(@PathVariable Integer id, @PathVariable boolean mg_state) {
        UsersVo vo = null;
        try {
            vo = userService.changeUserStatus(id, mg_state);
        } catch (Exception e) {
            logger.error("修改用户状态异常，异常信息={}", e.getMessage());
            return CommonRespone.failed("修改用户状态失败," +e.getMessage());
        }
        return CommonRespone.success("修改用户状态成功", vo);
    }
    
    @GetMapping("/users/{id}")
    public CommonRespone<UsersVo> getUserById(@PathVariable Integer id) {
        UsersVo vo = null;
        try {
            vo = userService.getUserById(id);
        } catch (Exception e) {
            logger.error("查询用户异常，异常信息={}", e.getMessage());
            return CommonRespone.failed("查询用户失败," +e.getMessage());
        }
        return CommonRespone.success(vo);
    }
    
    @PutMapping("/users/{id}")
    public CommonRespone<UsersVo> editUser(@PathVariable Integer id, @RequestBody Map<String, String> paramMap) {
        UsersVo vo = null;
        try {
            vo = userService.editUser(id, paramMap.get("mobile"), paramMap.get("email"));
        } catch (Exception e) {
            logger.error("修改用户异常，异常信息={}", e.getMessage());
            return CommonRespone.failed("修改用户失败," +e.getMessage());
        }
        return CommonRespone.success("修改用户", vo);
    }
    
    @DeleteMapping("/users/{id}")
    public CommonRespone<UsersVo> deleteUser(@PathVariable Integer id) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            logger.error("修改用户异常，异常信息={}", e.getMessage());
            return CommonRespone.failed("修改用户失败," +e.getMessage());
        }
        return CommonRespone.success("删除用户成功");
    }
}
