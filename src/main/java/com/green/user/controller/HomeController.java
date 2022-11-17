package com.green.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.moim.service.MoimService;
import com.green.moim.vo.MoimVo;
import com.green.user.service.MoimuserService;
import com.green.user.service.UserService;
import com.green.user.vo.MoimuserVo;
import com.green.user.vo.UserVo;

@Controller
public class HomeController {
	
	@Autowired
	private  MoimService   moimService;
	
	@Autowired
	private  UserService   userService;
	
	@Autowired
	private  MoimuserService  moimuserService;
	 
	@RequestMapping("/")
	public String test() {
		
		return "startpage";
	}
	// 홈&인터셉터
	@RequestMapping("/mainpage")
	public  String  home(Model model,
			HttpSession     session,
			@RequestParam   HashMap<String, Object> map) {
		String returnURL = "";
		
		if( session.getAttribute("login") != null ) {		// 기존 login 이란 session 에 값이 존재한다면
			List<MoimVo> moimList = moimService.getMoimList();  // home화면의 모임리스트 
			model.addAttribute("moimList", moimList);			// 홈화면의 c:forEach문의 아이템 moimList
			System.out.println(moimList);
			return "home";  								
		}
		return "home";										//WEB-INF/views/user/home.jsp
	}

	
	
	// 로그인
	// 현재 로그아웃시&"/signUpProcess" == signUpForm.jsp에서 가입하기 버튼 클릭
	@RequestMapping("/login")								
	public  String  login() {								
		return "user/loginForm"; 							//WEB-INF/views/user/loginForm.jsp
	}
	
	// loginForm.jsp 로그인 버튼 클릭시  
	@RequestMapping("/loginProcess")
	public  String   loginProcess(
		HttpSession     session,
		@RequestParam   HashMap<String, Object> map) {
		String returnURL = "";
		if( session.getAttribute("login") != null ) {		// 기존 login 이란 session 에 값이 존재한다면
			session.removeAttribute("login");  				// 기존값을 제거한다
		}
		
		// 로그인을 성공하면 UserVo 객체를 반환
		UserVo  vo  = userService.login( map );
		if ( vo != null ) {
			session.setAttribute("login", vo);
			returnURL = "redirect:/mainpage";        				// 로그인 성공시
		} else {
			returnURL = "redirect:/login";	 				// 로그인 실패시 수정필요!!!!!!!!!!!!!!!!!!!!!!!	
		}
		return returnURL;		
	}
	
	// 로그아웃("/logout") home 화면의 로그아웃 클릭
	@RequestMapping("/logout") 
	public  String  logout(HttpSession session) {
		session.invalidate();								// 로그아웃시 세션값 비우기
		return "redirect:/login";  							// 로그아웃시 이동할 주소 -> /login
	}
	@RequestMapping("/logout2") 
	public  String  logout2(HttpSession session) {
		session.invalidate();								// 로그아웃시 세션값 비우기
		return "home";  							// 로그아웃시 이동할 주소 -> /login
	}
	
	// loginForm.jsp 파일의 회원가입 버튼 클릭
	@RequestMapping("/signUpForm")
	public	String	signUpForm() {
		return "user/signUpForm";							//WEB-INF/views/user/signForm.jsp
	}
	
	//@ModelAttribute : 폼에서 전달된 값을 저장하는 객체 
	
	// signUpForm.jsp에서 가입하기 버튼 클릭
	@RequestMapping("/signUpProcess")
	public	String signUpProcess ( UserVo userVo, Model model ) {
		userService.insertUser( userVo );					// user정보 테이블에 insert
		// System.out.println(userVo);
		return "redirect:/login";							// ("/login")으로 == loginForm.jsp
	}

	// 회원가입 中 아이디 중복체크
	@RequestMapping("/user_id_check")
	@ResponseBody
	public int user_id_check(String user_id) {
		System.out.println("user_id:" + user_id);
		boolean a = user_id.trim() == "";
		
		int cnt = userService.user_id_check(user_id);
		System.out.println("cnt:" + cnt);

		if(a == true) {
			cnt = 1;
		} // moim_name 이 공백일 경우 mc를 1 증가시켜 
		  // 모임이름으로 사용할 수 없게 만듬
		return cnt;
	}
	
	// 마이페이지 home.jsp의 상단 메뉴바의 mypage_icon 클릭
	@GetMapping("/Mypage")
	public String mypage( String user_id, Model model ) {

		List<MoimuserVo> usermoimslist = moimuserService.getUserMoims(user_id); // 내모임리스트 가져오기
		model.addAttribute("usermoimslist", usermoimslist );

		return "user/mypage";								//WEB-INF/views/user/mypage.jsp
	}
	
	
	// 대학교검색 signUpForm.jsp 대학교검색 / mypage.jsp 대학교 정보수정의 검색
	@RequestMapping("/univSearch")
	public  String  univSearch() {
		return "user/univSearch";							//WEB-INF/views/user/univSearch.jsp
	}	
	
	// 수정하기 mypage.jsp에서 수정하기 버튼 클릭
	@RequestMapping("/Update")
	public  String   update(HttpSession session, UserVo  user) {

		userService.updateUser( user ); //입력된 새로운 데이터를 테이블에 UPDATE
		session.setAttribute("login", user); //세션값도 user로 바꿈
		
		return   "redirect:/mainpage";  //WEB-INF/views/user/home.jsp
	}
	
	@RequestMapping("sign_moim_user")
	public ModelAndView Sign_Moim_User(String user_id, int moim_idx,
			String sign_up_intro) {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("moim_idx", moim_idx);
		userService.inputMoimUser(map); // MoimUser 테이블에 추가
		
		//가입인사게시판 등록 구현필요
		
		//가입한 모임화면으로 다시 이동
		mv.setViewName("redirect:/Moim/moimpage?moim_idx=" + moim_idx);
		return mv;
	}
	
	@RequestMapping("Delete_moimuser")
	public String delete_moimuser(@RequestParam   HashMap<String, Object> map) {
		System.out.println("user_id:" + map.get("user_id"));
		System.out.println("moim_idx:" + map.get("moim_idx"));
		
		moimuserService.delete_moimuser(map);
		
		return "redirect:/Moim/moimpage?moim_idx=" + map.get("moim_idx");
	}
	

		
		
	
	
}

