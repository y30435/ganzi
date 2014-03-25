package com.ganzi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ganzi.dto.GanziUserDto;

@Repository
public class GanziUserDao extends BaseSqlMapDao{
	
	public GanziUserDto checkLogin(GanziUserDto ganziUserDto) {
		return (GanziUserDto) super.valueObject("ganziUser.login", ganziUserDto);
	}

	@SuppressWarnings("unchecked")
	public List<GanziUserDto> list(GanziUserDto ganziUserDto) {
		
		return (List<GanziUserDto>) super.list("ganziUser.list", ganziUserDto);
	}
}
