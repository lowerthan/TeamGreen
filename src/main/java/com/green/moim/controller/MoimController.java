package com.green.moim.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.green.moim.service.MoimService;
import com.green.moim.vo.MoimVo;
import com.green.user.service.MoimuserService;
import com.green.user.service.UserService;
import com.green.user.vo.UserVo;

@Controller
@RequestMapping("/Moim")
public class MoimController {
	
	@Autowired
	private MoimService moimService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MoimuserService moimuserService;
	
	
	// home.jsp에서 동아리 div 클릭시 mypage에서 내 동아리 클릭시
	@RequestMapping("/moimpage") // 모임화면 이동
	public String   moimpage(String moim_idx, Model model) {

		MoimVo moimVo = moimService.getmoim(moim_idx); // moim_idx 로 moimVo 에  모임정보담아오기 
		model.addAttribute("moimVo", moimVo );
		
		return  "moim/moimpage";
	}
	
	
	@ResponseBody
	@RequestMapping(value= "/regcheck") // 모임가입여부 체크
	public int regcheck(@RequestParam HashMap<String, Object> map) {
		
		int regcheck = moimuserService.regcheck(map); // moimuser 테이블 count --> 가입자 1, 미가입자 0
		
		return  regcheck;
	}
	
	@RequestMapping("/sign_up_moim")
	public ModelAndView Sign_Up_Moim(int moim_idx,
			String user_id) {
		ModelAndView mv = new ModelAndView();
		UserVo user_info = userService.getUserInfo(user_id);
		MoimVo moim_info = moimService.getMoimInfo(moim_idx);
		mv.addObject("user_info",user_info);
		mv.addObject("moim_info",moim_info);
		mv.setViewName("/moim/sign_up_moim");
		return mv;
	}
	
	@RequestMapping("/search_moim_name")
	@ResponseBody
	public ModelAndView Search_Moim_Name(String search_moim_name ) {
		ModelAndView mv = new ModelAndView();
		MappingJackson2JsonView jv = new MappingJackson2JsonView();
		List<MoimVo> moimVoList = moimService.search_moim_name(search_moim_name);
		mv.setView(jv);
		mv.addObject("moimVo" , moimVoList);
		
		return mv;
	}
	

}
