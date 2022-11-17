package com.green.pds.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.pds.service.PdsService;
import com.green.pds.vo.FilesVo;
import com.green.pds.vo.PdsPagingVo;
import com.green.pds.vo.PdsVo;

@Controller
@RequestMapping("/Pds")
public class PdsController {


	@Autowired
	private  PdsService    pdsService;
	

	@RequestMapping("/album")
	public String   list() {
		return  "pds/album";
	}

//   @RequestMapping("/board")
//   public String board(HashMap<String, Object> map, Model model) {
//	   
////      List<PdsPagingVo>  pdsPagingList =  pdsService.getPdsPagingList( map );
//       List<PdsVo>      pdsList       = pdsService.getPdsList(map);
////      int nowpage       =   Integer.parseInt( map.get("nowpage").toString() );
////      int pagegrpnum    =   Integer.parseInt( map.get("pagegrpnum").toString() );
//      
////      int nowpage       =   Integer.parseInt(String.valueOf(map.get("nowpage")));
////	  int pagegrpnum    =   Integer.parseInt(String.valueOf(map.get("pagegrpnum")));
//      
//      System.out.println("맵1:" + map);
//      
////      model.addAttribute("pdsList", pdsPagingList);
//      model.addAttribute("pdsList", pdsList);
////      model.addAttribute("nowpage", nowpage);
////      model.addAttribute("pagegrpnum", pagegrpnum);
//
//      System.out.println("맵2:" + map);
// //     map.put("nowpage", nowpage);
// //     map.put("pagegrpnum", pagegrpnum);
//      
//      return  "pds/list";
//   }
	
	

	@RequestMapping("/List")
	public  String   list(@RequestParam HashMap<String, Object> map, Model mv) {
		
		System.out.println("요기야");
		// 게시물 목록
	List <PdsVo> pdsList  =  pdsService.getPdsList(map);
		
    mv.addAttribute("pdsList", pdsList);

		//int menu_idx   =   (int) map.get("menu_idx");
		System.out.println(map.get("menu_idx"));
		
		int menu_idx   =   Integer.parseInt(String.valueOf(map.get("menu_idx")));
		int nowpage    =   Integer.parseInt( map.get("nowpage").toString() );
		int pagecount  =   Integer.parseInt( map.get("pagecount").toString() ); 
		int startnum   =   ( nowpage - 1  ) * pagecount + 1;
	    int endnum     =   nowpage * pagecount; 
	    
	    map.put("startnum",   startnum);
		map.put("endnum",     endnum);
		
System.out.println("맵찍어보자:" + map);
		
	List<PdsPagingVo>  pdsPagingList =  pdsService.getPdsPagingList( map );
	
System.out.println("pdsPagingList:" + pdsPagingList);
		
		PdsPagingVo        pagePdsVo  = (PdsPagingVo) map.get("pagePdsVo");
		
		mv.addAttribute("pdsList",    pdsPagingList);
//		mv.addAttribute("찐pdsList",    pdsList);
//				mv.addAttribute("pdsPagingList",    pdsPagingList);
//				mv.addAttribute("pdsList",    pdsList);
		mv.addAttribute("pagePdsVo",  pagePdsVo );
        mv.addAttribute("menu_idx",   menu_idx);
        mv.addAttribute("map",   map);
        
System.out.println("1:" + pdsPagingList);
System.out.println("2:" + pdsList);
        
		mv.addAttribute("pagePdsVo",  pagePdsVo);
System.out.println("mv:" + mv);
		return   "pds/list";		
	}
	
	
	@RequestMapping("/WriteForm")
	   public  ModelAndView   writeForm(
	         @RequestParam HashMap<String, Object> map   ) {
	         
System.out.println("writeForm() map:" + map);
	         


	         ModelAndView  mv  =  new ModelAndView();
	         mv.addObject("map", map);
	         mv.setViewName("pds/write");  
	         
System.out.println("writeform내:" + map);	         
	         return        mv;
	      }
	   
	   
	
	   @RequestMapping("/Write")
	   public  ModelAndView  write(
	      @RequestParam  HashMap<String, Object> map) {
	      
	      int menu_idx   =   Integer.parseInt(String.valueOf(map.get("menu_idx")));
	      
	      pdsService.setWrite(map);
	            
	      int  nowpage = Integer.parseInt((String) map.get("nowpage")); 
	      int  pagecount = Integer.parseInt((String) map.get("pagecount")); 
	      int  pagegrpnum = Integer.parseInt((String) map.get("pagegrpnum")); 
	     
	      String fmt = "redirect:/Pds/List?menu_idx=%d";
	      fmt       += "&nowpage=%d";
	      fmt       += "&pagecount=%d";
	      fmt       += "&pagegrpnum=%d";
	      
	      String loc = String.format(fmt, 
	           menu_idx, nowpage, pagecount, pagegrpnum);   
	      
System.out.println(loc);
	      
	      ModelAndView  mv = new ModelAndView();      
	      mv.addObject("map",  map);
	      mv.setViewName( loc );
	      return  mv;
	   }
	

	   
	@RequestMapping("/View")
	public  ModelAndView   view(@RequestParam HashMap<String, Object> map) {

System.out.println("Pds/View map:" + map);
		
System.out.println("TTTTTTTT");
		// idx 로 조회된 글 정보
		PdsVo          pdsVo    = pdsService.getPds( map );
		
		
		int  menu_idx = Integer.parseInt((String) map.get("menu_idx"));
System.out.println("222222222222");		
		PdsPagingVo pdspagingVo = new PdsPagingVo();
		
		ModelAndView  mv  =  new ModelAndView();
		//mv.addObject("menuList",   menuList );
		mv.addObject("pdsVo",      pdsVo );
		mv.addObject("menu_idx",   menu_idx );
		mv.addObject("PdsPagingVo", pdspagingVo);
		System.out.println(pdsVo);

		mv.addObject("map", map );		
		mv.setViewName( "pds/view" );
		return  mv;
	}
	
	   // Delete
	   @RequestMapping("/Delete")
	   public  ModelAndView  delete(
	      @RequestParam HashMap<String, Object>  map ) {
	      
	      // 넘어온 값은? board_idx=21
	      System.out.println("delete() map:" + map);
	      // delete() map:{board_idx=21}
	      
	      // 글삭제 서비스 실행
	      pdsService.boardDelete( map );
	      
	      ModelAndView  mv  =  new ModelAndView();
	      
	      String fmt  = "redirect:/mainpage";
	        
	      String loc = String.format(fmt);      
	      mv.setViewName( loc );
	   
	      return   mv;   
	   }
	
	// Update
	// <a href="/Pds/UpdateForm?menu_id=${pdsVo.menu_id}
	// &idx=${pdsVo.idx}&nowpage=${map.nowpage}
	// &pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}">
	@RequestMapping("/UpdateForm")
	public   ModelAndView   updateForm(
		@RequestParam  HashMap<String, Object> map ) {
		
		// 메뉴 목록
//		List<MenuVo>   menuList   =  menuService.getMenuList();
				
		// idx로 수정할 자료 검색
		PdsVo          pdsVo      =  pdsService.getPds( map );
		
		// idx로 수정할 파일들정보 검색
		List<FilesVo>  filesList  =  pdsService.getFilesList(map); 
		
		System.out.println("인영" + map);
		
		ModelAndView   mv  =  new ModelAndView();
//		mv.addObject("menuList",  menuList );
//		mv.addObject("filesList", filesList );
		mv.addObject("pdsVo",    pdsVo   );
		mv.addObject("map", map);
		mv.setViewName("pds/update");
		return  mv;
	}
	
	// /Pds/Update
	@RequestMapping("/Update")
	public   ModelAndView   update(
		@RequestParam  HashMap<String, Object> map ) {
		
		System.out.println("PDsController update() map:" + map);
		
		//    수정 (idx, tite, cont, menu_id, file 정보) 
		pdsService.setUpdate(  map  );
		
//		int      menu_idx = (int) map.get("menu_idx");
		//int  	 menu_idx = Integer.parseInt((String) map.get("menu_idx"));
		
/*		int      nowpage     = Integer.parseInt(  
			     (String) map.get("nowpage") ); 
		int      pagecount   = Integer.parseInt(  
				 (String) map.get("pagecount") ); 
		int      pagegrpnum  = Integer.parseInt(  
				 (String) map.get("pagegrpnum") ); 
*/
		
		// 이동		
		ModelAndView  mv  =  new  ModelAndView();
//		String fmt  = "redirect:/Pds/List";
		mv.setViewName("redirect:/mainpage") ;
/*		fmt        += "?menu_idx=%d";
		fmt        += "&nowpage=%d";
		fmt        += "&pagecount=%d";
		fmt        += "&pagegrpnum=%d";
		String loc = String.format(fmt, 
				menu_idx, nowpage, pagecount, pagegrpnum);
		
		mv.setViewName( loc );
*/
		return mv;
	}	
	
	
	// 찐사진첩 
	@RequestMapping("{MOIM_IDX}/Album")
	public  String  album(@PathVariable("MOIM_IDX") int moim_idx, Model model) {

		System.out.println("moim_idx:" + moim_idx);
		 PdsVo pdsVo = new PdsVo();
		 pdsVo.setMoim_idx(moim_idx);
		 
		 
		 List<FilesVo> filesVos =  pdsService.selectImage(pdsVo);

		System.out.println("filesVos:" + filesVos);
		 model.addAttribute("ImageList", filesVos);
//		 model.addAttribute("model", model);
		 
		// 추가필수 !!!
		// SELCET * FROM BOARD WHERE MOIM_IDX = moim_idx 해서 보드 데이터 가져온후
		// 모델에 담아서 보내줘야함 !!  ex) 		model.addAttribute("board",Object);
		return "pds/album";
	}
	
		@RequestMapping("/Album/WriteForm")
	public  String  album_WriteForm(@RequestParam int moim_idx, Model model) {
		model.addAttribute("moim_idx", moim_idx);
		return "pds/upload";
	}

			@RequestMapping("/Album/upload")
	public  String  album_upload(PdsVo pdsVo) {
				System.out.println("pdsVo:"+pdsVo);

		UUID uuid = UUID.randomUUID();
		String imageFileName = uuid+"_"+pdsVo.getFile().getOriginalFilename();
		//System.out.println("파일명 : "+imageFileName);

	 // String uploadFolder ="C://YD/moim_db/src/main/webapp/WEB-INF/resources/imgup/";
	    String uploadFolder ="D:\\ws\\spring\\moim_db2\\src\\main\\webapp\\WEB-INF\\resources\\imgup2\\";


		Path imageFilePath = Paths.get(uploadFolder+imageFileName);
		System.out.println("파일패스 : "+imageFilePath);
		try {
			Files.write(imageFilePath, pdsVo.getFile().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		pdsService.ImageUpload(pdsVo,imageFileName);
		
		return "redirect:/Pds/"+pdsVo.getMoim_idx()+"/Album";
		
	}
	
	//--------------------------------------------------------------------------
	// 다운로드
	// http://localhost:9090/Pds/download/external/taglibs-standard-impl-1.2.5_3.jar
	// {sfile}    : .jpg와 같은 .포함문자가 들어오면 그 문자를 무시 - 사용금지
	// {sfile:.+} : 정규식문법으로  + (한개이상 존재해야한다)  ".한개 이상"
	//              확장자가 한개이상 존재하는
	@RequestMapping(value  ="/download/{type}/{sfile:.+}",
		            method = RequestMethod.GET	)
	public  void  downloadFile(
		@PathVariable("type")  String type,
		@PathVariable("sfile") String sfile,
		HttpServletResponse    response
			)  throws IOException {
		
		String  INTERNAL_FILE         = sfile;
		String  EXTERNAL_FILE_PATH    = "c:\\upload\\" + sfile;
		
		File    file  = null;
		if ( type.equalsIgnoreCase("internal") ) {   //internal
			ClassLoader  classLoader = 
				Thread.currentThread().getContextClassLoader(); // 현재시스템정보
			file = new File(classLoader.getResource(INTERNAL_FILE).getFile() );
		} else {  // extenal
			file = new File ( EXTERNAL_FILE_PATH );
		}
		
		if( !file.exists() ) {
			String  errorMessage = "죄송합니다. 파일이 없습니다";
			System.out.println( errorMessage );
			OutputStream  outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}
		
		//String  mimeType = URLConnection.guessContentTypeFromName(file.getName());
		String  mimeType   = "application/octet-stream";  // 무조건 다운로드
		
		//String  fname = URLEncoder.encode(file.getName(), "UTF-8");
		// 파일명 한글 처리
		String  fname = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1" );
		response.setContentType( mimeType );
		response.setHeader("Content-Disposition",
			String.format( "inline; filename=\"" + fname  + "\"" )	);
		
		 
		response.setContentLength((int) file.length() );
		
		InputStream  inputStream = new BufferedInputStream(
			new FileInputStream(file) );
		
		FileCopyUtils.copy(inputStream, response.getOutputStream() );
		
		
		
		}

	}
	
	

