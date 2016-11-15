package com.taotao.sso.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.pojo.TbUser;
import com.taotao.sso.pojo.ValidateModel;

@Controller
@RequestMapping("/demo")
public class DemoController {
	@RequestMapping("/demo")
	public String showDemo(HttpServletRequest request) {
		request.getSession().setAttribute("hihi", "Gary");
		TbUser u=new TbUser();
		u.setUsername("new");
		request.getSession().setAttribute("user", u);
		String name=(String) request.getSession().getAttribute("hihi");
		return "demo";
	}
	
	@RequestMapping("/demo2")
	public String showDemo2(HttpServletRequest request) {
		String name=(String) request.getSession(true).getAttribute("hihi");
		TbUser u=(TbUser) request.getSession(true).getAttribute("user");
		return "demo";
	}
	
	
	@RequestMapping("/vdemo")
	public String validationDemo(ValidateModel model,BindingResult result) {
		result.rejectValue("name", "name error","dsdasda");
		return "demo";
	}
}
