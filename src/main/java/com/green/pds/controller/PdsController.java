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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
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

	// HOME.JSP
	// <a href="/Pds/List?menu_id=MENU01&nowpage=1&pagecount=4&pagegrpnum=1">자료실</a> 
	// 페이징 가능한 리스트로 수정


	
	
	@RequestMapping("/album")
	public String   list() {
		return  "pds/album";
	}

	   @RequestMapping("/board")
	   public String board(HashMap<String, Object> map) {
          // System.out.println(map);
	      pdsService.getPdsList(map);
	      return  "pds/list";
	}
	
	@RequestMapping("/WriteForm")
	public String   WriteForm() {
		return  "pds/write";
	}


	@RequestMapping("/List")
	public  ModelAndView   list(
			@RequestParam HashMap<String, Object>	map) {
//	public   ModelAndView   list( int  menu_idx ) {
		// {menu_id=MENU01, 
		// nowpage=1,     -- 현재 (보여줄) 페이지 번호
		// pagecount=2,   -- 한 페이지 당 보여줄 LINE수
		// pagegrpnum=1}  -- 페이지 그룹 번호 	 
				
		
		// 게시물 목록
		List <PdsVo> pdsList  =  pdsService.getPdsList(map);
		
		
		// 현재 menu 정보
		int       menu_idx  = (int) map.get("menu_idx");
				
		int nowpage    =   Integer.parseInt( map.get("nowpage").toString() );
		int pagecount  =   Integer.parseInt( map.get("pagecount").toString() ); 
		int startnum   =   ( nowpage - 1  ) * pagecount + 1;
	    int endnum     =   nowpage * pagecount; 
	    
	    map.put("startnum",   startnum);
		map.put("endnum",     endnum);
				
		List<PdsPagingVo>  pdsPagingList =  pdsService.getPdsPagingList( map );
		
		// 조회후  pdsService.getPdsList( map ) 명령 실행후 
		// map("pagePdsVo") 에 돌아온 결과 처리
		PdsPagingVo        pagePdsVo  = (PdsPagingVo) map.get("pagePdsVo");
		
		
		ModelAndView  mv  =  new ModelAndView();
		mv.addObject("pdsList",    pdsPagingList);
		mv.addObject("pagePdsVo",  pagePdsVo );
        mv.addObject("menu_idx",   menu_idx);
			
		mv.addObject("map",        map);
	//	mv.addObject("page",       page);
		mv.setViewName("pds/list");	
		return   mv;		
	}

	@PostMapping("/Write")
	public  String  write(PdsVo pdsVo ) {
		System.out.println("pdsVo:"+pdsVo);

		pdsService.pdsInsert ( pdsVo );
		return  "redirect:/Pds/board";} 
//		return  pdsVo;
	
	
//원래	String   menu_id  =  (String) map.get("menu_id");
		
		// 새글저장       : Board  Table  - 게시글 저장         - Dao		
		// 파일 정보저장  : Files  Table  - 첨부파일 이름저장   - Dao
		// 실제 파일 저장 : c:\\upload    - 첨부파일 자체 저장 		
//원래		pdsService.setWrite(map, request);
				
//원래이거		int  nowpage = Integer.parseInt( 
//				(String) map.get("nowpage")); 
//		int  pagecount = Integer.parseInt(
//				(String) map.get("pagecount")); 
//		int  pagegrpnum = Integer.parseInt( 
//				(String) map.get("pagegrpnum")); 
//		String fmt = "redirect:/Pds/List?menu_id=%s";
//		fmt       += "&nowpage=%d";
//		fmt       += "&pagecount=%d";
//		fmt       += "&pagegrpnum=%d";
//		String loc = String.format(fmt, 
//			  menu_id, nowpage, pagecount, pagegrpnum);	
//		ModelAndView  mv = new ModelAndView();		
//		mv.addObject("map",  map);
//		mv.setViewName( loc );
//		return  mv;
	

	// <a href="/Pds/View?
	//  idx=${ pdsVo.idx }
	//  &menu_id=${ menu_id }
	//  &nowpage=${pagePdsVo.nowpage}
	//  &pagecount=${pagePdsVo.pagecount}
	//  &pagrgrpnum=${pagePdsVo.pagegrpnum} "
	@RequestMapping("/View")
	public  ModelAndView   view(@RequestParam HashMap<String, Object> map) {

		System.out.println("Pds/View map:" + map);
		
		// idx 로 조회된 글 정보
		PdsVo          pdsVo    = pdsService.getPds( map );
		
		// idx 로 조회된 글 연결된 파일 목록 filesList
		List<FilesVo>  filesList =  pdsService.getFilesList( map );
		//System.out.println("Pds Controller pdsFilesList:" +  filesList);
		
		int  menu_idx = (int) map.get("menu_idx");					
		
		ModelAndView  mv  =  new ModelAndView();
		mv.addObject("pdsVo",      pdsVo );
		mv.addObject("filesList",  filesList );
		mv.addObject("menu_idx",    menu_idx );
				
		mv.addObject("map", map );		
		mv.setViewName( "pds/view" );
		return  mv;
	}
	
	// Delete
	@RequestMapping("/Delete")
	public  ModelAndView  delete(
		@RequestParam HashMap<String, Object>  map ) {
		
		// 넘어온 값은? menu_id, idx, nref, lvl, step
		   //  nowpage, pagecount, pagegrpnum 
		// 넘겨줄 값은? menu_id, idx, nref, lvl, step
	    //  nowpage, pagecount, pagegrpnum
		System.out.println("delete() map:" + map);
		int   menu_idx   =  (int) map.get("menu_idx");
		// 글삭제
		pdsService.setDelete( map );
		
		int  nowpage    = Integer.parseInt( (String) map.get("nowpage") );
		int  pagecount  = Integer.parseInt( (String) map.get("pagecount") );
		int  pagegrpnum = Integer.parseInt( (String) map.get("pagegrpnum") );
		
		String  fmt  = "redirect:/Pds/List";
		fmt         += "?menu_idx=%d";
		fmt         += "&nowpage=%d";
		fmt         += "&pagecount=%d";
		fmt         += "&pagegrpnum=%d";
		String  loc  = String.format(fmt, menu_idx,
				nowpage, pagecount, pagegrpnum );
		
		ModelAndView  mv =  new ModelAndView();
		mv.setViewName( loc );
		return  mv;
	}
	
	// Update
	// <a href="/Pds/UpdateForm?menu_id=${pdsVo.menu_id}
	// &idx=${pdsVo.idx}&nowpage=${map.nowpage}
	// &pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}">
	@RequestMapping("/UpdateForm")
	public   ModelAndView   updateForm(
		@RequestParam  HashMap<String, Object> map ) {
				
		// idx로 수정할 자료 검색
		PdsVo          pdsVo      =  pdsService.getPds( map );
		
		// idx로 수정할 파일들정보 검색
		List<FilesVo>  filesList  =  pdsService.getFilesList(map); 
		
		ModelAndView   mv  =  new ModelAndView();
		mv.addObject("filesList", filesList );
		mv.addObject("pdsVo",    pdsVo   );
		mv.addObject("map", map);
		mv.setViewName("pds/update");
		return  mv;
	}
	
	// /Pds/Update
	@RequestMapping("/Update")
	public   ModelAndView   update(
		@RequestParam  HashMap<String, Object> map,
		HttpServletRequest request ) {
		
		System.out.println("PDsController update() map:" + map);
		
		//    수정 (idx, tite, cont, menu_id, file 정보) 
		pdsService.setUpdate(  map, request  );
		
		int      menu_idx = (int) map.get("menu_idx");
		int      nowpage     = Integer.parseInt(  
			     (String) map.get("nowpage") ); 
		int      pagecount   = Integer.parseInt(  
				 (String) map.get("pagecount") ); 
		int      pagegrpnum  = Integer.parseInt(  
				 (String) map.get("pagegrpnum") ); 
		
		// 이동		
		ModelAndView  mv  =  new  ModelAndView();
		String fmt  = "redirect:/Pds/List";
		fmt        += "?menu_idx=%d";
		fmt        += "&nowpage=%d";
		fmt        += "&pagecount=%d";
		fmt        += "&pagegrpnum=%d";
		String loc = String.format(fmt, 
				menu_idx, nowpage, pagecount, pagegrpnum);
		
		mv.setViewName( loc );
		return mv;
	}	
	
	
	// 찐사진첩 
	@RequestMapping("{MOIM_IDX}/Album")
	public  String  album(@PathVariable("MOIM_IDX") int moim_idx,Model model) {

		System.out.println("moim_idx:"+moim_idx);
		 PdsVo pdsVo = new PdsVo();
		 pdsVo.setMoimIdx(moim_idx);
		 List<FilesVo> filesVos =  pdsService.selectImage(pdsVo);

		System.out.println("filesVos:"+filesVos);
		 model.addAttribute("ImageList",filesVos);
		// 추가필수 !!!
		// SELCET * FROM BOARD WHERE MOIM_IDX = moim_idx 해서 보드 데이터 가져온후
		// 모델에 담아서 보내줘야함 !!  ex) 		model.addAttribute("board",Object);
		return "pds/album";
	}
	
		@RequestMapping("/Album/WriteForm")
	public  String  album_WriteForm(@RequestParam int moim_idx, Model model) {
		model.addAttribute("moim_idx",moim_idx);
		return "pds/upload";
	}

			@RequestMapping("/Album/upload")
	public  String  album_upload(PdsVo pdsVo) {
				System.out.println("pdsVo:"+pdsVo);

		UUID uuid = UUID.randomUUID();
		String imageFileName = uuid+"_"+pdsVo.getFile().getOriginalFilename();
		//System.out.println("파일명 : "+imageFileName);

	 // String uploadFolder ="C://YD/moim_db/src/main/webapp/WEB-INF/resources/imgup/";
	    String uploadFolder ="C://ws/Java/moim_db-----------------------/src/main/webapp/WEB-INF/resources/imgup/";


		Path imageFilePath = Paths.get(uploadFolder+imageFileName);
		//System.out.println("파일패스 : "+imageFilePath);
		try {
			Files.write(imageFilePath, pdsVo.getFile().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		pdsService.ImageUpload(pdsVo,imageFileName);

		return "redirect:/Pds/"+pdsVo.getMoimIdx()+"/Album";
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
	
	

