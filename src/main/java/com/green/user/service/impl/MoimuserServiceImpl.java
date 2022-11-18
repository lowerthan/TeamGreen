package com.green.user.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.user.dao.MoimuserDao;
import com.green.user.service.MoimuserService;
import com.green.user.vo.MoimuserVo;

@Service("MoimuserService")
public class MoimuserServiceImpl implements MoimuserService {
	
	@Autowired
	private  MoimuserDao  moimuserDao;

	@Override
	public List<MoimuserVo> getUserMoims(String user_id) {
		
		List<MoimuserVo> usermoimslist = moimuserDao.getUserMoims(user_id);
		return usermoimslist;
	}
	
	@Override
	public int regcheck(HashMap<String, Object> map) {
		int regcheck = moimuserDao.regcheck(map);
		return regcheck;
	}

	@Override
	public void delete_moimuser(HashMap<String, Object> map) {
		moimuserDao.delete_moimuser(map);
	}

	@Override
	public void delete_hi(HashMap<String, Object> map) {
		moimuserDao.delete_hi(map);
		
	}

}
