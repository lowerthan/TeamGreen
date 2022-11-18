package com.green.user.service;

import java.util.HashMap;
import java.util.List;

import com.green.user.vo.MoimuserVo;

public interface MoimuserService {

	List<MoimuserVo> getUserMoims(String user_id);
	
	int regcheck(HashMap<String, Object> map);

	void delete_moimuser(HashMap<String, Object> map);

	void delete_hi(HashMap<String, Object> map);

}
