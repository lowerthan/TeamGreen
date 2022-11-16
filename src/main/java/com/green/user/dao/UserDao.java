package com.green.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.green.moim.vo.MoimVo;
import com.green.user.vo.UserVo;

public interface UserDao {

	UserVo login(HashMap<String, Object> map);

	void insertUser(UserVo userVo);

	
	// 진성이 담당한 부분
	UserVo getUserInfo(String user_id);

	void inputMoim(MoimVo moimVo);
	
	int Moim_Name_Check(String moim_name);
	
	
	
	
	
	// 현태행님 담당한 부분
	UserVo getUser(String user_id);

	void updateUser(UserVo user);

	void inputMoimUser(Map<String, Object> map);




	
}
