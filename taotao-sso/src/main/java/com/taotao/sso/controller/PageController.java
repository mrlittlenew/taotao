package com.taotao.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.sso.service.UserService;

@Controller
@RequestMapping("/page")
public class PageController {
	
	
	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public String showRegister() {
		return "register";
	}
	@RequestMapping("/login")
	public String showLogin(String redirect,Model model) {
		model.addAttribute("redirect", redirect);
		return "login";
	}
	
	@RequestMapping(value = "/logout")
	public String userLogout(HttpServletRequest request, HttpServletResponse response) {
		try {
			TaotaoResult result = userService.userLogout(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "login";
	}
	
	


}
