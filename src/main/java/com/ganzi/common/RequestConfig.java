package com.ganzi.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.ganzi.model.DaumRequest;
import com.ganzi.model.NaverRequest;

/**
 * Naver Request에 필요한 값을 설정
 * - properties에 정의 되어 있는 설정 값을 NaverRequest 객체에 치환
 * 
 * @author 개발지원 2팀 - 한주희 과장 
 * @when   2014.3.25
 * 아무거나 수정 ㅎㅎㅎ
 * 저도 수정 ! 
 * 2차 수정 !
 */

@Configuration
@PropertySource("classpath:/config/search.openapi.properties")
public class RequestConfig {
	@Autowired
    Environment env;
	
	@Bean(name="naverRequest")
	public NaverRequest NaverRequest() {
		
		NaverRequest naverRequest = new NaverRequest();
		
		naverRequest.setRegUrl(env.getProperty("naver.openapi.url"));
		naverRequest.setKey(env.getProperty("naver.openapi.key"));
		naverRequest.setDisplay(env.getProperty("naver.openapi.display"));
		naverRequest.setStart(env.getProperty("naver.openapi.start"));
		
		return naverRequest;
	}
	
	@Bean(name="daumRequest")
	public DaumRequest DaumRequest() {
		
		DaumRequest daumRequest = new DaumRequest();
		// http://apis.daum.net/search/blog?apikey=[사용자 api키]&q='
		daumRequest.setRegUrl(env.getProperty("daum.openapi.url"));
		daumRequest.setApkey(env.getProperty("daum.openapi.apikey"));
		daumRequest.setResult(env.getProperty("daum.openapi.result"));
		
		return daumRequest;
	}
}

