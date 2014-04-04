package com.ganzi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ganzi.dto.GanziUserDto;
import com.ganzi.service.GanziUserService;

@Controller
public class MemberAdminController {
	@Autowired
	GanziUserService ganziUserService;
	
	
	/**
	 * 디비연결 테스
	 * @author 
	 * @throws Exception 
	 * @when 
	 */
	@RequestMapping("/test")
	public String test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GanziUserDto ganziUserDto = new GanziUserDto();
		List<GanziUserDto> data = null;
		
		try {
			data = ganziUserService.getList(ganziUserDto);

			request.setAttribute("data", data);
		} catch(Exception e){
			e.printStackTrace();
			
		}
		return "list"; 
	}
	
	
	/**
	 * 회원 정보 리스트 페이지
	 * @author 
	 * @throws Exception 
	 * @when 
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GanziUserDto ganziUserDto = new GanziUserDto();
		List<GanziUserDto> data = null;
		
		try {
			data = ganziUserService.getList(ganziUserDto);

			request.setAttribute("data", data);
		} catch(Exception e){
			e.printStackTrace();
			
		}
		return "ganziList"; 
	}
	
	
	/**
	 * 로그인 뷰 페이지
	 * @author 
	 * @when 
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {

		
		return "gaziLogin"; 
	}
	
	
	/**
	 * 회원 등록 뷰 페이지
	 * @author 
	 * @when 
	 */
	@RequestMapping("/join")
	public String join(HttpServletRequest request, HttpServletResponse response) {
		return "ganziJoin"; 
	}
	
	
	/**
	 * 회원 정보 수정 페이지
	 * @author 
	 * @when 
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam("id") String userid) {
		GanziUserDto ganziUserDto = new GanziUserDto();
		GanziUserDto data = null;
		ModelAndView mav = new ModelAndView("mod");
		try {			
			ganziUserDto.setUserid(userid);
			data = ganziUserService.getInfo(ganziUserDto);
		} catch(Exception e){
			e.printStackTrace();
		}
		mav.setViewName("ganziUpdate");
		mav.addObject("userid", data.getUserid());
		mav.addObject("username", data.getUsername());
		mav.addObject("userpwd", data.getUserpwd());
		mav.addObject("userrole", data.getUserrole());
		return mav;
	}
	
	
	/**
	 * 회원 정보 상세 뷰 페이지
	 * @author 
	 * @when 
	 */
	@RequestMapping("/detail")
	public ModelAndView detail(@RequestParam("id") String userid) {
		GanziUserDto ganziUserDto = new GanziUserDto();
		GanziUserDto data = null;
		ModelAndView mav = new ModelAndView("mod");
		try {
			ganziUserDto.setUserid(userid);
			data = ganziUserService.getInfo(ganziUserDto);
		} catch(Exception e){
			e.printStackTrace();
		}
		mav.setViewName("ganziDetail");
		mav.addObject("userid", data.getUserid());
		mav.addObject("username", data.getUsername());
		mav.addObject("userpwd", data.getUserpwd());
		mav.addObject("userrole", data.getUserrole());
		return mav;
	}
	
	
	/**
	 * 로그인 처리 페이지
	 * @author 
	 * @when 
	 */
	@RequestMapping("/loginProc")
	public ModelAndView loginProc(HttpServletRequest request, HttpServletResponse response) {
		GanziUserDto ganziUserDto = new GanziUserDto();
		String url;
		boolean result = false;
		try {
			String userid = request.getParameter("userid");
			String userpwd = request.getParameter("userpwd");
			
			ganziUserDto.setUserid(userid);
			GanziUserDto aaa = ganziUserService.checkLogin(ganziUserDto);
			if(aaa.getUserpwd().equals(userpwd)){
				result = true;
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		if (result){
			url = "redirect:/list.do";
		} else{
			url = "redirect:/login.do";
		}
		return new ModelAndView(url);
	}
	
	
	/**
	 * 회원 등록 처리 페이지
	 * @author 
	 * @when 
	 */
	@RequestMapping("/joinProc")
	public ModelAndView proc(HttpServletRequest request, HttpServletResponse response) {
		GanziUserDto ganziUserDto = new GanziUserDto();
		int result = 0;
		try {
			String userid = request.getParameter("userid");
			String userpwd = request.getParameter("userpwd");
			String userrole = "ROLE_USER";
			String username = request.getParameter("username");
			
			ganziUserDto.setUserid(userid);
			ganziUserDto.setUserpwd(userpwd);
			ganziUserDto.setUserrole(userrole);
			ganziUserDto.setUsername(username);
			
			result = ganziUserService.join(ganziUserDto);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		String url = "redirect:/join.do";
		if (result == 1){
			url = "redirect:/list.do";
		} 
		
		return new ModelAndView(url);
	}
	
	/**
	 * 회원 수정 처리 페이지
	 * @author 
	 * @when 
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping("/updateProc")
//	public ModelAndView updateProc( Article article) {
	public ModelAndView updateProc( HttpServletRequest request, HttpServletResponse response) {
		GanziUserDto ganziUserDto = new GanziUserDto();
		int result = 0;
		String userid = "";
		try {
			userid = request.getParameter("userid");
			String userpwd = request.getParameter("userpwd");
			String userrole = request.getParameter("userrole");
			String username = request.getParameter("username");
			
			ganziUserDto.setUserid(userid);
			ganziUserDto.setUserpwd(userpwd);
			ganziUserDto.setUserrole(userrole);
			ganziUserDto.setUsername(username);
			
			//result = ganziUserService.update(article);
			result = ganziUserService.update(ganziUserDto);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		String url = "redirect:/update.do?id="+userid;
		if (result == 1){
			url = "redirect:/list.do";
		} 
		
		return new ModelAndView(url);
	}
	
	/**
	 * 회원 삭제 처리 페이지
	 * @author 
	 * @when 
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping("/deleteProc")
	public ModelAndView deleteProc(@RequestParam("id") String userid) {
		GanziUserDto ganziUserDto = new GanziUserDto();
		int result = 0;
		try {
			ganziUserDto.setUserid(userid);
			result = ganziUserService.delete(ganziUserDto);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		String url = "redirect:/update.do?id="+userid;
		if (result == 1){
			url = "redirect:/logout.do";
		} 
		
		return new ModelAndView(url);
	}
}
