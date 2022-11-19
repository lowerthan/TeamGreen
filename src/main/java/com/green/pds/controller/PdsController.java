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
import java.util.Map;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/Pds")
public class PdsController {


    @Autowired
    private PdsService pdsService;
	

	/*
	@RequestMapping("/album")
	public String   list() {
		return  "pds/album_test";
	}
	*/

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
    public String list(@RequestParam HashMap<String, Object> map, Model mv) {
        System.out.println("map은뭘까요:" + map);


//System.out.println("pdsList는뭘까요:" + pdsList);


        //int menu_idx   =   (int) map.get("menu_idx");

        int menu_idx = Integer.parseInt(String.valueOf(map.get("menu_idx")));
        int nowpage = Integer.parseInt(map.get("nowpage").toString());
        int pagecount = Integer.parseInt(map.get("pagecount").toString());
        int startnum = (nowpage - 1) * pagecount + 1;
        int endnum = nowpage * pagecount;

        map.put("startnum", startnum);
        map.put("endnum", endnum);

//System.out.println("맵찍어보자:" + map);

        List<PdsPagingVo> pdsPagingList = pdsService.getPdsPagingList(map);

//System.out.println("pdsPagingList:" + pdsPagingList);

        PdsPagingVo pagePdsVo = (PdsPagingVo) map.get("pagePdsVo");

        mv.addAttribute("pdsList", pdsPagingList);
//		mv.addAttribute("찐pdsList",    pdsList);
        mv.addAttribute("pagePdsVo", pagePdsVo);
        mv.addAttribute("menu_idx", menu_idx);
        mv.addAttribute("map", map);

//System.out.println("1:" + pdsPagingList);
//System.out.println("2:" + pdsList);

        mv.addAttribute("pagePdsVo", pagePdsVo);
//System.out.println("mv:" + mv);
        return "pds/list";
    }


    @RequestMapping("/WriteForm")
    public ModelAndView writeForm(
            @RequestParam HashMap<String, Object> map) {

        System.out.println("writeForm안의 맵:" + map);

        //   PdsVo   pdsVo    = pdsService.getPds( map );

        ModelAndView mv = new ModelAndView();
        mv.addObject("map", map);
//	         mv.addObject("moim_idx", moim_idx);
        mv.setViewName("pds/write");
        return mv;
    }


    @RequestMapping("/Write")
    public ModelAndView write(
            @RequestParam HashMap<String, Object> map) {

        int menu_idx = Integer.parseInt(String.valueOf(map.get("menu_idx")));

        pdsService.setWrite(map);
        System.out.println(map);

        int nowpage = Integer.parseInt((String) map.get("nowpage"));
        int pagecount = Integer.parseInt((String) map.get("pagecount"));
        int pagegrpnum = Integer.parseInt((String) map.get("pagegrpnum"));
        int moim_idx = Integer.parseInt((String) map.get("moim_idx"));

        String fmt = "redirect:/Pds/List?menu_idx=%d";
        fmt += "&nowpage=%d";
        fmt += "&pagecount=%d";
        fmt += "&pagegrpnum=%d";
        fmt += "&moim_idx=%d";

        String loc = String.format(fmt,
                menu_idx, nowpage, pagecount, pagegrpnum, moim_idx);

        System.out.println(loc);

        ModelAndView mv = new ModelAndView();
        mv.addObject("map", map);
        mv.setViewName(loc);
        return mv;
    }


    @RequestMapping("/View")
    public ModelAndView view(@RequestParam HashMap<String, Object> map) {

        System.out.println("Pds/View map:" + map);

        PdsVo pdsVo = pdsService.getPds(map);

        int menu_idx = Integer.parseInt((String) map.get("menu_idx"));
        System.out.println("222222222222");
        PdsPagingVo pdspagingVo = new PdsPagingVo();

        ModelAndView mv = new ModelAndView();
        mv.addObject("pdsVo", pdsVo);
        mv.addObject("menu_idx", menu_idx);
        mv.addObject("PdsPagingVo", pdspagingVo);
        System.out.println(pdsVo);

        mv.addObject("map", map);
        mv.setViewName("pds/view");
        return mv;
    }


    @RequestMapping("/Delete")
    public String delete(
            @RequestParam HashMap<String, Object> map,RedirectAttributes redirect) {
        System.out.println("delete() map:" + map);
        // 글삭제 서비스 실행
        pdsService.boardDelete(map);

       redirect.addAttribute("menu_idx", map.get("menu_idx").toString());
        redirect.addAttribute("nowpage", "1");
        redirect.addAttribute("pagecount", "10");
        redirect.addAttribute("pagegrpnum", "1");
        redirect.addAttribute("moim_idx",map.get("moim_idx").toString());
        return "redirect:/Pds/List";
    }


    @RequestMapping("/UpdateForm")
    public ModelAndView updateForm(
            @RequestParam HashMap<String, Object> map) {

        PdsVo pdsVo = pdsService.getPds(map);

        List<FilesVo> filesList = pdsService.getFilesList(map);

        System.out.println("인영" + map);

        ModelAndView mv = new ModelAndView();
        mv.addObject("pdsVo", pdsVo);
        mv.addObject("map", map);
        mv.setViewName("pds/update");
        return mv;
    }


    @RequestMapping("/Update")
    public String update(@RequestParam HashMap<String, Object> map, RedirectAttributes redirect) {
        System.out.println("PDsController update() map:" + map);
        pdsService.setUpdate(map);

        redirect.addAttribute("menu_idx", map.get("menu_idx").toString());
        redirect.addAttribute("nowpage", "1");
        redirect.addAttribute("pagecount", "10");
        redirect.addAttribute("pagegrpnum", "1");
        redirect.addAttribute("moim_idx",map.get("moim_idx").toString());
        return "redirect:/Pds/List";
    }


    // 찐사진첩
    @RequestMapping("/Album")
    public String album(PdsVo pdsVo, Model model) {

        List<FilesVo> filesVos = pdsService.selectImage(pdsVo);

        model.addAttribute("ImageList", filesVos);
//		 model.addAttribute("model", model);

        // 추가필수 !!!
        // SELCET * FROM BOARD WHERE MOIM_IDX = moim_idx 해서 보드 데이터 가져온후
        // 모델에 담아서 보내줘야함 !!  ex) 		model.addAttribute("board",Object);
        return "pds/album";
    }


    @RequestMapping("/Album/WriteForm")
    public String album_WriteForm(@RequestParam int moim_idx, Model model) {
        model.addAttribute("moim_idx", moim_idx);
        return "pds/upload";
    }


    @RequestMapping("/Album/upload")
    public String album_upload(PdsVo pdsVo) {
        System.out.println("pdsVo:" + pdsVo);

        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid + "_" + pdsVo.getFile().getOriginalFilename();

        String uploadFolder = "D:\\ws\\spring\\moim_db2\\src\\main\\webapp\\WEB-INF\\resources\\imgup2\\";


        Path imageFilePath = Paths.get(uploadFolder + imageFileName);
        System.out.println("파일패스 : " + imageFilePath);
        try {
            Files.write(imageFilePath, pdsVo.getFile().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        pdsService.ImageUpload(pdsVo, imageFileName);

        return "redirect:/Pds/" + pdsVo.getMoim_idx() + "/Album";

    }

    //--------------------------------------------------------------------------
    // 다운로드
    // http://localhost:9090/Pds/download/external/taglibs-standard-impl-1.2.5_3.jar
    // {sfile}    : .jpg와 같은 .포함문자가 들어오면 그 문자를 무시 - 사용금지
    // {sfile:.+} : 정규식문법으로  + (한개이상 존재해야한다)  ".한개 이상"
    //              확장자가 한개이상 존재하는
    @RequestMapping(value = "/download/{type}/{sfile:.+}",
            method = RequestMethod.GET)
    public void downloadFile(
            @PathVariable("type") String type,
            @PathVariable("sfile") String sfile,
            HttpServletResponse response
    ) throws IOException {

        String INTERNAL_FILE = sfile;
        String EXTERNAL_FILE_PATH = "c:\\upload\\" + sfile;

        File file = null;
        if (type.equalsIgnoreCase("internal")) {   //internal
            ClassLoader classLoader =
                    Thread.currentThread().getContextClassLoader(); // 현재시스템정보
            file = new File(classLoader.getResource(INTERNAL_FILE).getFile());
        } else {  // extenal
            file = new File(EXTERNAL_FILE_PATH);
        }

        if (!file.exists()) {
            String errorMessage = "죄송합니다. 파일이 없습니다";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        //String  mimeType = URLConnection.guessContentTypeFromName(file.getName());
        String mimeType = "application/octet-stream";  // 무조건 다운로드

        //String  fname = URLEncoder.encode(file.getName(), "UTF-8");
        // 파일명 한글 처리
        String fname = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1");
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition",
                String.format("inline; filename=\"" + fname + "\""));


        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(
                new FileInputStream(file));

        FileCopyUtils.copy(inputStream, response.getOutputStream());


    }

 // 댓글 넣기
 	@RequestMapping("/inputcomment")
 	public String InputComments(String comment,
 			int board_idx, int menu_idx, String user_id) {
 		Map<String, Object> map = new HashMap<String, Object>();
 		map.put("user_id", user_id);
 		map.put("comment", comment);
 		map.put("board_idx", board_idx);
 		pdsService.InputComments(map);
 		
 		return "redirect:/Pds/View?board_idx="+board_idx+"&menu_idx="+menu_idx;
 	}
 	// 인사게시판으로 이동
 	@RequestMapping("/hi") // 모임화면 이동
 	public ModelAndView moimpage(String moim_idx) {
 		ModelAndView mv = new ModelAndView();
 		List<PdsVo> pdsVo = pdsService.getHiBoardList(moim_idx);
 		System.out.println(pdsVo);
 		mv.addObject("pdsVo",pdsVo);
 		mv.setViewName("pds/hi");
 		return  mv;
 	}
    
}
	
	

