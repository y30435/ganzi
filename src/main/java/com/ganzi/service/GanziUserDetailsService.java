package com.ganzi.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.ganzi.dto.GanziUserDto;

public class GanziUserDetailsService implements UserDetailsService{
	
	// 사용자 db 조회를 위해 ganziUserService를 등록한다.
	@Autowired
	GanziUserService ganziUserService;
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userid)
			throws UsernameNotFoundException, DataAccessException {
	
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		//사용자 검색을 위해 GanziUserDto 에 userid 를 set 해준다.
		GanziUserDto ganziUser = new GanziUserDto();
		ganziUser.setUserid(userid);
		
		//사용자 검색 후 결과값을 리턴 받을 GanziUserDto 객체 선언
		GanziUserDto returnUser = new GanziUserDto();
		returnUser = null;
		
		//UserDetails setting시 필요한 값으로 별 의미가 없는듯 null 만 아니면 문제 없음
		String password = "";
		
		try {
			// db에서 사용자 정보를 조회 하고 결과 값을 리턴 받는다.
			returnUser = ganziUserService.getInfo(ganziUser);
			
		} catch (Exception e) {
			//TODO db exception 발생시 예외 처리
			//System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
			e.printStackTrace();
		}
		
		//사용자 조회 결과 아이디값이 존재하지 않는다면
		if(returnUser != null) {
			String User_Role = "ROLE_USER";
			User_Role = returnUser.getUserrole();
			
			authorities.add(new GrantedAuthorityImpl(User_Role));
			password = returnUser.getUserpwd();
			
		}else {
			throw new DisabledException("User Not Found");
		}
		
		UserDetails user = new User(userid,password, true, true, true, true, authorities);
		
		return user;
	}

}
