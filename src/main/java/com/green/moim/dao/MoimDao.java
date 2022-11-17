package com.green.moim.dao;


import java.util.List;

import com.green.moim.vo.MoimVo;
import com.green.user.vo.UserVo;

public interface MoimDao {

	void inputMoim(MoimVo moimVo);

	MoimVo getmoim(String moim_idx);

	List<MoimVo> getMoimList();

	MoimVo getMoimInfo(int moim_idx);

	List<MoimVo> search_moim_name(String search_moim_name);

	List<MoimVo> getRecommend(UserVo userVo);
	

	
}
