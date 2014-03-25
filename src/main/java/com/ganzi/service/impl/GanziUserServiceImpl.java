package com.ganzi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganzi.dao.GanziUserDao;
import com.ganzi.dto.GanziUserDto;
import com.ganzi.service.GanziUserService;

@Service
public class GanziUserServiceImpl implements GanziUserService {
	@Autowired
	GanziUserDao ganziUserDao;
	//GanziUserDao ganziUserDao = new GanziUserDao();

	public GanziUserDto checkLogin(GanziUserDto ganziUserDto) throws Exception {
		return (GanziUserDto) ganziUserDao.checkLogin(ganziUserDto);
	}

	public List<GanziUserDto> getList(GanziUserDto ganziUserDto) throws Exception {
		return (List<GanziUserDto>) ganziUserDao.list(ganziUserDto);
	}

	public GanziUserDto getInfo(GanziUserDto ganziUserDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(GanziUserDto ganziUserDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(GanziUserDto ganziUserDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(GanziUserDto ganziUserDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
