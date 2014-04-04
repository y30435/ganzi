package com.ganzi.service;

import java.util.List;

import com.ganzi.dto.GanziUserDto;

public interface GanziUserService {
	
	public GanziUserDto checkLogin(GanziUserDto ganziUserDto) throws Exception;
	
	public List<GanziUserDto> getList(GanziUserDto ganziUserDto) throws Exception;
	
	public GanziUserDto getInfo(GanziUserDto ganziUserDto) throws Exception;
	
	public int join(GanziUserDto ganziUserDto) throws Exception;
	
	public int update(GanziUserDto ganziUserDto) throws Exception;
	
	public int delete(GanziUserDto ganziUserDto) throws Exception;
}
