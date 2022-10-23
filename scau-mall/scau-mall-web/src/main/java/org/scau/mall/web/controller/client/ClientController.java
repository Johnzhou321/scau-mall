package org.scau.mall.web.controller.client;



import javax.servlet.http.HttpServletRequest;

import org.scau.mall.vo.resp.CommonRespone;
import org.scau.mall.web.service.ClientServiceImpl;
import org.scau.mall.web.vo.ClientsVo;
import org.scau.mall.web.vo.PageShowVo;
import org.scau.mall.web.vo.QueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户控制类
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
public class ClientController {
    
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    
    @Autowired
    private ClientServiceImpl clientService;
    
    @GetMapping("/clients")
    public CommonRespone<PageShowVo<ClientsVo>> clients(QueryVo vo, HttpServletRequest request) {
        PageShowVo<ClientsVo> pageVo = null;
        try {
            pageVo = clientService.getClientsByPage(vo);
        } catch (Exception e) {
            logger.error("获取客户列表异常，异常信息={}", e.getMessage());
            return CommonRespone.failed("获取客户列表异常" + e.getMessage());
        }
        return CommonRespone.success(pageVo);
    }
    
}
