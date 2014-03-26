package com.ganzi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ganzi.dto.GanziUserDto;

@Repository
public class GanziUserDao extends BaseSqlMapDao{
	
	public GanziUserDto checkLogin(GanziUserDto ganziUserDto) {
		return (GanziUserDto) super.valueObject("ganziUser.getInfo", ganziUserDto);
	}

	@SuppressWarnings("unchecked")
	public List<GanziUserDto> list(GanziUserDto ganziUserDto) {
		
		return (List<GanziUserDto>) super.list("ganziUser.list", ganziUserDto);
	}
	
	public boolean join(GanziUserDto ganziUserDto) {
		return super.insert("ganziUser.join",ganziUserDto);
	}
	
	public GanziUserDto getInfo(GanziUserDto ganziUserDto) {
		return (GanziUserDto) super.valueObject("ganziUser.getInfo",ganziUserDto);
	}
	
	public boolean update(GanziUserDto ganziUserDto) {
		return super.update("ganziUser.update",ganziUserDto);
	}
	
	public boolean delete(GanziUserDto ganziUserDto) {
		return super.delete("ganziUser.delete",ganziUserDto);
	}
}
