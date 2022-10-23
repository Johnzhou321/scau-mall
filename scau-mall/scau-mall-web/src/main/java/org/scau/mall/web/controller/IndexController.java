package org.scau.mall.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scau.mall.utils.EncodeImgZxing;
import org.scau.mall.utils.ImgUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class IndexController {
	
	@RequestMapping(value = "/index")
    public String index(ModelMap map){
        map.addAttribute("resource","");
        return "filling";
    }
	
	@RequestMapping(value = "/encodeImg")
    public void encodeImg(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		OutputStream print = resp.getOutputStream();
		//EncodeImgZxing.writeToStream("http://127.0.0.1:8081/test/middle", "jpeg", print);
//		ImgUtils.drawImage("http://127.0.0.1:8082/test/middle", print, "jpeg");
		ImgUtils.drawImage("https://e0dd-14-23-100-75.ngrok.io/test/middle", print, "jpeg");
    }
	
	@RequestMapping(value = "/middle")
    public String middle(ModelMap map){
		map.addAttribute("resource","");
		return "middle";
    }
}
