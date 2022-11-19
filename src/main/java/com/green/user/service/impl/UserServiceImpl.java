package com.green.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.user.dao.UserDao;
import com.green.user.service.UserService;
import com.green.moim.vo.MoimVo;
import com.green.user.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private  UserDao  userDao;

	@Override
	public UserVo login(HashMap<String, Object> map) {
		UserVo    vo   =   userDao.login( map ); 
		return    vo;
	}

	@Override
	public void insertUser(UserVo userVo) {
		userDao.insertUser( userVo );
	}

	// 진성이 담당한 부분
	@Override
	public UserVo getUserInfo(String user_id) {
		UserVo a = userDao.getUserInfo(user_id);
		return a;
	}


	
	@Override
	public int Moim_Name_Check(String moim_name) {
		int mc = userDao.Moim_Name_Check( moim_name );
		return mc;
	}
	
	@Override
	public void input_hi_board(Map<String, Object> map2) {
		userDao.input_hi_board(map2);
		
	}

	@Override
	public int find_moim_idx(String moim_name) {
		
		int moim_idx = userDao.find_moim_idx(moim_name); 
		
		return moim_idx;
	}
	
	
	
	
	
	// 현태행님 담당한 부분
	@Override
	public UserVo getUser(String user_id) {
		UserVo user = userDao.getUser( user_id );
		return user;
	}

	@Override
	public void updateUser(UserVo user) {
		userDao.updateUser( user );
		
	}

	@Override
	public void inputMoimUser(Map<String, Object> map) {
		userDao.inputMoimUser(map);
		
	}

	@Override
	public int user_id_check(String user_id) {
		
		int cnt = userDao.user_id_check(user_id);
		return cnt;
	}












}





