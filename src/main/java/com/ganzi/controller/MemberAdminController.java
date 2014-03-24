package com.ganzi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MemberAdminController {
	
	/**
	 * 로그인 페이지
	 * @author 
	 * @when 
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "gaziLogin"; 
	}
	
	/**
	 * 회원 정보 수정 페이지
	 * @author 
	 * @when 
	 */
	@RequestMapping("/update")
	public String update(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "gaziUpdate"; 
	}
	
	
	/**
	 * 회원 정보 리스트 페이지
	 * @author 
	 * @when 
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "gaziList"; 
	}
	
	
	/**
	 * 회원 등록 페이지
	 * @author 
	 * @when 
	 */
	@RequestMapping("/join")
	public String join(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "gaziJoin"; 
	}
	
	
	/**
	 * 회원 등록 페이지
	 * @author 
	 * @when 
	 */
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "gaziDetail"; 
	}
}
