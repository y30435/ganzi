package com.ganzi.model;

/**
 * Naver 검색 OpenAPI request에 필요한 파라미터 정의
 * - 
 * @author 개발지원 2팀 - 한주희 과장 
 * @when   2014.3.25
 */

public class NaverRequest {
	
	private String regKey;
	private String regUrl;
	private String target;
	private String query;
	private String display;
	private String start;
	private String sort;

	public String getRegKey() {
		return regKey;
	}

	public void setRegKey(String regKey) {
		this.regKey = regKey;
	}

	public String getRegUrl() {
		return regUrl;
	}

	public void setRegUrl(String regUrl) {
		this.regUrl = regUrl;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
	
}
