package org.scau.mall.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@RequestMapping(value = "/index")
    public String index(ModelMap map){
        map.addAttribute("resource","");
        return "login";
    }
	
	@RequestMapping(value = "/submit")
    public String submit(ModelMap map){
        map.addAttribute("resource","");
        return "index";
    }
}
