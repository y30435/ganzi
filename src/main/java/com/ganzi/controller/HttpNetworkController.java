package com.ganzi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ganzi.common.NaverRequestConfig;
import com.ganzi.model.NaverRequest;
import com.ganzi.service.HttpNetworkService;
import com.ganzi.service.XpathService;

/**
 * url http통신을 위한 controller
 * - 
 * @author 개발지원 2팀 - 한주희 과장 
 * @when   2014.3.25
 */

@Controller
@RequestMapping("/socket")
public class HttpNetworkController {

	/**
	 * http Request 처리
	 * 
	 * - 검색어(query)를 받아 NaverRequest Model에 셋팅
	 * - URL 접속에 필요한 CONFIG 정보를 빈에 등록및 사용
	 * - request요청 후 response 결과값(xml)을 xpathService 를 이용하여 파싱함.
	 * - 파싱 결과값을 view 페이지에 전달
	 * 
	 * @author 개발지원 2팀 - 한주희 과장 
	 * @when   2014.3.25
	 */
	@RequestMapping("/request")
	public String request(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String strRslt = "";
		HttpNetworkService httpNetwork = new HttpNetworkService();
		XpathService xpathService = new XpathService();
		
		try {
			//Naver request를 위한 config bean을 등록 및 사용
			ApplicationContext context = new AnnotationConfigApplicationContext(NaverRequestConfig.class);
			NaverRequest naverRequest = (NaverRequest) context.getBean("naverRequest");
			
			//검색어 set
			String searchKey = request.getParameter("searchKey");
			String searchTarget = request.getParameter("searchTarget");
			
			naverRequest.setQuery(searchKey);
			naverRequest.setTarget(searchTarget);
			
			//request
			String xml = (String) httpNetwork.strGetData(naverRequest);
			
			//xPath를 이용하여 파싱
			strRslt = xpathService.XpathParsing(xml);
			
			request.setAttribute("strRslt", strRslt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "socket/request"; 
	}
	
	/**
	 * 검색어 입력 화면
	 * 
	 * @author 개발지원 2팀 - 한주희 과장 
	 * @when   2014.3.25
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, HttpServletResponse response) {
		
		return "socket/search"; 
	}
}
