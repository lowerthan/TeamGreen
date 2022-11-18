package com.green.user.dao;

import java.util.HashMap;
import java.util.List;

import com.green.user.vo.MoimuserVo;

public interface MoimuserDao {

	List<MoimuserVo> getUserMoims(String user_id);
	
	int regcheck(HashMap<String, Object> map);

	void delete_moimuser(HashMap<String, Object> map);

	void delete_hi(HashMap<String, Object> map);

}
