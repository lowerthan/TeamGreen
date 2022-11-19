package com.green.moim.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.moim.dao.MoimDao;
import com.green.moim.service.MoimService;
import com.green.moim.vo.MoimVo;
import com.green.user.vo.UserVo;


@Service("moimService")
public class MoimServiceImpl implements MoimService {
	
	@Autowired
	private MoimDao moimDao;

	@Override
	public void inputMoim(MoimVo moimVo) {
		moimDao.inputMoim(moimVo);
		
	}

	@Override
	public MoimVo getmoim(String moim_idx) {
		MoimVo moimVo = moimDao.getmoim(moim_idx);
		System.out.println("moimDaoImpl:" + moimVo);
		return moimVo;
	}

	@Override
	public List<MoimVo> getMoimList() {
		List<MoimVo> moimList = moimDao.getMoimList();
		return moimList;
	}

	@Override
	public MoimVo getMoimInfo(int moim_idx) {
		MoimVo moim_info = moimDao.getMoimInfo(moim_idx);
		return moim_info;
	}

	@Override
	public List<MoimVo> search_moim_name(String search_moim_name) {
		List<MoimVo> moimVoList = moimDao.search_moim_name(search_moim_name);
		return moimVoList;
	}

	@Override
	public List<MoimVo> getRecommend(UserVo userVo) {
		List<MoimVo> moimList = moimDao.getRecommend(userVo);
		return moimList;
	}
	
	@Override
	public List<MoimVo> cateMoimList(Map<String, Object> map) {
		List<MoimVo> cateMoimList = moimDao.cateMoimList(map);
		System.out.println("서비스카테모임리스트:"+cateMoimList);
		return cateMoimList;
	}




}





