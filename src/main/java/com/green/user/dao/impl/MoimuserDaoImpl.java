package com.green.user.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.user.dao.MoimuserDao;
import com.green.user.vo.MoimuserVo;

@Repository("MoimuserDao")
public class MoimuserDaoImpl implements MoimuserDao {
	
	@Autowired
	private SqlSession  sqlSession;

	@Override
	public List<MoimuserVo> getUserMoims(String user_id) {
		
		List<MoimuserVo> usermoimslist = sqlSession.selectList("User.Usermoimslist", user_id);
		return usermoimslist;
	}
	
	@Override
	public int regcheck(HashMap<String, Object> map) {
		int regcheck = sqlSession.selectOne("User.Regcheck", map);
		return regcheck;
	}

	@Override
	public void delete_moimuser(HashMap<String, Object> map) {
		sqlSession.delete("User.delete_moimuser", map);
	}

	@Override
	public void delete_hi(HashMap<String, Object> map) {
		sqlSession.delete("User.delete_hi", map);
		
	}

}
