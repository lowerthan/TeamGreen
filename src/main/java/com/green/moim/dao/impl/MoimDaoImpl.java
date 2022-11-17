package com.green.moim.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.moim.dao.MoimDao;
import com.green.moim.vo.MoimVo;
import com.green.user.vo.UserVo;

@Repository("moimDao")
public class MoimDaoImpl implements MoimDao {
	
	@Autowired
	private SqlSession  sqlSession;

	@Override
	public void inputMoim(MoimVo moimVo) {
		sqlSession.insert("Moim.inputMoim",moimVo);
		sqlSession.insert("Moim.inputMoimuser",moimVo);		
			
		}

	@Override
	public MoimVo getmoim(String moim_idx) {
		MoimVo  moimVo = sqlSession.selectOne("Moim.Getmoim", moim_idx );
		return moimVo;
	}
	
	@Override
	public List<MoimVo> getMoimList() {
		List<MoimVo> moimList = sqlSession.selectList("Moim.MoimList");
		return moimList;
	}

	@Override
	public MoimVo getMoimInfo(int moim_idx) {
		MoimVo moim_info = sqlSession.selectOne("Moim.MoimInfo",moim_idx);
		return moim_info;
	}

	@Override
	public List<MoimVo> search_moim_name(String search_moim_name) {
		List<MoimVo> moimVoList = sqlSession.selectList("Moim.Search_moim_name",search_moim_name);
		return moimVoList;
	}

	@Override
	public List<MoimVo> getRecommend(UserVo userVo) {
		
		System.out.println("다오까지옴 userVo:" + userVo);
		List<MoimVo> moimList = sqlSession.selectList("Moim.getRecommend", userVo);
		System.out.println("다오에서감 moimList:" + moimList);
		return moimList;
	}
}

	










