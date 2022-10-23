package org.scau.mall.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.scau.mall.vo.resp.CommonRespone;
import org.scau.mall.web.service.MenusServiceImpl;
import org.scau.mall.web.vo.MenusVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单控制类
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
public class MenuController {
    
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    
    @Autowired
    private MenusServiceImpl menusService;
    
    @GetMapping("/menus")
    public CommonRespone<List<MenusVo>> menus(HttpServletRequest request) {
        List<MenusVo> list = null;
        try {
            list = menusService.getMenus();
        } catch (Exception e) {
            logger.error("获取菜单异常,msg={}", e.getMessage());
            return CommonRespone.failed("获取菜单异常");
        }
        return CommonRespone.success(list);
    }
}
