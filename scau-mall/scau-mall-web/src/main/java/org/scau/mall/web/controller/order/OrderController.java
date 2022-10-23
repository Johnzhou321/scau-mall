package org.scau.mall.web.controller.order;




import javax.servlet.http.HttpServletRequest;

import org.scau.mall.vo.resp.CommonRespone;
import org.scau.mall.web.service.OrderServiceImpl;
import org.scau.mall.web.vo.ApproveFormBody;
import org.scau.mall.web.vo.AuditFormBody;
import org.scau.mall.web.vo.OrdersVo;
import org.scau.mall.web.vo.PageShowVo;
import org.scau.mall.web.vo.QueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单控制类
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
public class OrderController {
    
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    
    @Autowired
    private OrderServiceImpl orderService;
    
    @GetMapping("/orders")
    public CommonRespone<PageShowVo<OrdersVo>> orders(QueryVo vo, HttpServletRequest request) {
        PageShowVo<OrdersVo> pageVo = null;
        try {
            pageVo = orderService.getOrdersByPage(vo);
        } catch (Exception e) {
            logger.error("获取订单列表异常，异常信息={}", e.getMessage());
            return CommonRespone.failed("获取订单列表异常" + e.getMessage());
        }
        return CommonRespone.success(pageVo);
    }
    
    @PostMapping("/verifyPass")
    public CommonRespone<Object> verifyPass(@RequestBody AuditFormBody body, HttpServletRequest request) {
        try {
            orderService.verifyPass(body);
        } catch (Exception e) {
            logger.error("审核异常，异常信息={}", e.getMessage());
            return CommonRespone.failed("审核异常，异常信息为" + e.getMessage());
        }
        return CommonRespone.success();
    }
    
    @PostMapping("/approveSubmit")
    public CommonRespone<Object> approveSubmit(@RequestBody ApproveFormBody body, HttpServletRequest request) {
        try {
            orderService.approveSubmit(body);
        } catch (Exception e) {
            logger.error("审核异常，异常信息={}", e.getMessage());
            return CommonRespone.failed("审核异常，异常信息为" + e.getMessage());
        }
        return CommonRespone.success();
    }
    
}
