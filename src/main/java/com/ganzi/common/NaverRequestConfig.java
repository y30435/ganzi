package com.ganzi.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.ganzi.model.NaverRequest;

/**
 * Naver Request에 필요한 값을 설정
 * - properties에 정의 되어 있는 설정 값을 NaverRequest 객체에 치환
 * 
 * @author 개발지원 2팀 - 한주희 과장 
 * @when   2014.3.25
 */

@Configuration
@PropertySource("classpath:/config/naver.openapi.properties")
public class NaverRequestConfig {
	@Autowired
    Environment env;
	
	@Bean(name="naverRequest")
	public NaverRequest NaverRequest() {
		
		NaverRequest naverRequest = new NaverRequest();
		
		naverRequest.setRegUrl(env.getProperty("naver.openapi.url"));
		naverRequest.setRegKey(env.getProperty("naver.openapi.key"));
		naverRequest.setTarget(env.getProperty("naver.openapi.target"));
		naverRequest.setQuery(env.getProperty("naver.openapi.query"));
		naverRequest.setDisplay(env.getProperty("naver.openapi.display"));
		naverRequest.setStart(env.getProperty("naver.openapi.start"));
		naverRequest.setSort(env.getProperty("naver.openapi.sort"));
		
		return naverRequest;
	}
}
