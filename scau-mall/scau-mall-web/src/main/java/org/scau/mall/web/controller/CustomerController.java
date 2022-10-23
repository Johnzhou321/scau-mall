package org.scau.mall.web.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scau.mall.utils.ImgUtils;
import org.scau.mall.vo.ClientLoadRecordVo;
import org.scau.mall.vo.Pagination;
import org.scau.mall.vo.PmsClientQueryVo;
import org.scau.mall.vo.PmsClientShowVo;
import org.scau.mall.vo.resp.ResponeData;
import org.scau.mall.web.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {
    
    @Autowired
    private OrderServiceImpl orderServiceImpl;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest req, ClientLoadRecordVo body){
        return "/customer/index";
    }
	
	@RequestMapping(value = "/add")
	@ResponseBody
    public ResponeData<Object> add(HttpServletRequest req, @RequestBody ClientLoadRecordVo body){
	    ResponeData<Object> result = orderServiceImpl.submitClientLoadRecord(body);
        return result;
    }
	
	@RequestMapping(value = "/list")
    @ResponseBody
    public ResponeData<PmsClientShowVo> list(HttpServletRequest req, PmsClientQueryVo vo){
	    ResponeData<PmsClientShowVo> result = new ResponeData<>();
	    Pagination<PmsClientShowVo> data = orderServiceImpl.getPaginationPmsClientLoanRecordList(vo);
	    result.setCount(data.getMeta().getTotal());
        result.setData(data.getList());
	    return result;
    }
	
	@RequestMapping(value = "/encodeImg")
    public void encodeImg(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		OutputStream print = resp.getOutputStream();
		//EncodeImgZxing.writeToStream("http://127.0.0.1:8081/test/middle", "jpeg", print);
		ImgUtils.drawImage("http://127.0.0.1:8081/test/middle", print, "jpeg");
    }
	
	@RequestMapping(value = "/middle")
    public String middle(ModelMap map){
		map.addAttribute("resource","");
		return "middle";
    }
}
