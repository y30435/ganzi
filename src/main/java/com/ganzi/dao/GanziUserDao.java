package com.ganzi.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ganzi.dto.GanziUserDto;

@Repository
public class GanziUserDao extends SqlSessionDaoSupport{
	public GanziUserDto checkLogin(GanziUserDto ganziUserDto) {
		return (GanziUserDto) getSqlSession().selectOne("ganziUser.getInfo", ganziUserDto);
	}
	
	@SuppressWarnings("unchecked")
	public List<GanziUserDto> list(GanziUserDto ganziUserDto) {
		
		return (List<GanziUserDto>) getSqlSession().selectList("ganziUser.list", ganziUserDto);
	}
	
	public int join(GanziUserDto ganziUserDto) {
		return getSqlSession().update("ganziUser.join",ganziUserDto);
	}
	
	public GanziUserDto getInfo(GanziUserDto ganziUserDto) {
		return (GanziUserDto) getSqlSession().selectOne("ganziUser.getInfo",ganziUserDto);
	}
	
	public int update(GanziUserDto ganziUserDto) {
		return getSqlSession().update("ganziUser.update",ganziUserDto);
	}
	
	public int delete(GanziUserDto ganziUserDto) {
		return getSqlSession().delete("ganziUser.delete",ganziUserDto);
	}
}


//public class GanziUserDao extends BaseSqlMapDao{
//	
//	public GanziUserDto checkLogin(GanziUserDto ganziUserDto) {
//		return (GanziUserDto) super.valueObject("ganziUser.getInfo", ganziUserDto);
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<GanziUserDto> list(GanziUserDto ganziUserDto) {
//		
//		return (List<GanziUserDto>) super.list("ganziUser.list", ganziUserDto);
//	}
//	
//	public boolean join(GanziUserDto ganziUserDto) {
//		return super.insert("ganziUser.join",ganziUserDto);
//	}
//	
//	public GanziUserDto getInfo(GanziUserDto ganziUserDto) {
//		return (GanziUserDto) super.valueObject("ganziUser.getInfo",ganziUserDto);
//	}
//	
//	public boolean update(GanziUserDto ganziUserDto) {
//		return super.update("ganziUser.update",ganziUserDto);
//	}
//	
//	public boolean delete(GanziUserDto ganziUserDto) {
//		return super.delete("ganziUser.delete",ganziUserDto);
//	}
//}
