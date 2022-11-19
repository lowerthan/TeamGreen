package com.green.user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.moim.dao.MoimDao;
import com.green.moim.vo.MoimVo;
import com.green.user.dao.UserDao;
import com.green.user.vo.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession  sqlSession;

	@Override
	public UserVo login(HashMap<String, Object> map) {
		System.out.println("userdao map:" + map);
		UserVo  vo  =  sqlSession.selectOne("User.login", map); 
		
		return  vo;
	}

	@Override
	public void insertUser(UserVo userVo) {
		sqlSession.insert("User.insertUser", userVo );
	}

	
	
	
	// 진성이 담당한 부분
	@Override
	public UserVo getUserInfo(String user_id) {
		UserVo a = sqlSession.selectOne("User.UserInfo",user_id);
		return a;
	}

	@Override
	public void inputMoim(MoimVo moimVo) {
		sqlSession.insert("User.inputMoim",moimVo);
	}
	
	@Override
	public int Moim_Name_Check(String moim_name) {
		int mc = sqlSession.selectOne( "User.moim_name_check", moim_name );
		return mc;
	}
	@Override
	public void input_hi_board(Map<String, Object> map2) {
		sqlSession.insert("User.input_hi_board", map2);
		
	}
	
	@Override
	public int find_moim_idx(String moim_name) {
		int moim_idx = sqlSession.selectOne("User.find_moim_idx", moim_name); 
		return moim_idx;
	}

	
	
	
	// 현태행님 담당한 부분
	@Override
	public UserVo getUser(String user_id) {
		UserVo  vo = sqlSession.selectOne("User.User", user_id );
		return vo;
	}

	@Override
	public void updateUser(UserVo user) {
		System.out.println(user);
		sqlSession.update("User.UserUpdate", user);
		
	}

	@Override
	public void inputMoimUser(Map<String, Object> map) {
		sqlSession.insert("User.inputMoimUser", map);
		
	}

	@Override
	public int user_id_check(String user_id) {
		System.out.println(" user_id : " + user_id);
		int cnt = sqlSession.selectOne( "User.user_id_check", user_id );
		return cnt;
	}

	






}





