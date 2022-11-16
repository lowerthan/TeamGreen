package com.green.main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.moim.service.MoimService;
import com.green.moim.vo.MoimVo;
import com.green.user.service.UserService;
import com.green.user.vo.UserVo;

@Controller
@RequestMapping("/Main") 
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MoimService moimService;
	
	// 모임생성 home.jsp의 상단 메뉴바의 +모양의 이미지 클릭시
	@RequestMapping("/Createmoim")
	public ModelAndView CreateMoim(String user_id) {			//생성자가 모임장이 되므로 user_id받아옴
		ModelAndView mv = new ModelAndView();
		
		UserVo a = userService.getUserInfo(user_id);			//userVo의 내용 defalut값을 위해 가져옴 
		// System.out.println( a );
		mv.addObject("a", a);
		mv.setViewName("/user/createmoim");						//WEB-INF/views/user/createmoim.jsp  경로수정필요해보임!!
		
		return mv;
	}
	
	// createmoim.jsp에서 생성하기 모임개설하기 버튼 클릭시 
	@RequestMapping("/Inputmoim")
	public ModelAndView InputMoim(MoimVo moimVo) {

		ModelAndView mv = new ModelAndView();
		moimService.inputMoim(moimVo);							//테이블에 개설한 모임내용(moimVo)을 추가
		mv.setViewName("redirect:/");							// home.jsp 리다이렉트
		return mv;
	}
	
	@RequestMapping("/moim_name_check")
	@ResponseBody
	public int Moim_Name_Check(String moim_name) {
		boolean a = moim_name.trim() == "";
		int mc = userService.Moim_Name_Check(moim_name);
		// mc 는 DB에서 moim_name을 count한 값이다.
		if(a == true) {
			mc = 1;
		} // moim_name 이 공백일 경우 mc를 1 증가시켜 
		  // 모임이름으로 사용할 수 없게 만듬
		return mc;
	}
	
	@RequestMapping("/searchmoim")
	public ModelAndView SearchMoim(String user_id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("moim/searchmoim");
		return mv;
	}


}









