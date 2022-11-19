package com.green.moim.service;


import java.util.List;
import java.util.Map;

import com.green.moim.vo.MoimVo;
import com.green.user.vo.UserVo;

public interface MoimService {

	void inputMoim(MoimVo moimVo);

	MoimVo getmoim(String moim_idx);
	
	List<MoimVo> getMoimList();
	
	MoimVo getMoimInfo(int moim_idx);

	List<MoimVo> search_moim_name(String search_moim_name);

	List<MoimVo> getRecommend(UserVo userVo);

	List<MoimVo> cateMoimList(Map<String, Object> map);






}
