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
import com.green.pds.vo.CommentsVo;
import com.green.pds.vo.FilesVo;
import com.green.pds.vo.PdsPagingVo;
import com.green.pds.vo.PdsVo;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/Pds")
public class PdsController {


    @Autowired
    private PdsService pdsService;
	

	
	@RequestMapping("/album")
	public String   list() {
		return  "pds/album";
	}
	

    @RequestMapping("/List")
    public String list(@RequestParam HashMap<String, Object> map, Model mv) {

    	List <PdsVo> pdsList  =  pdsService.getPdsList(map);
		
        mv.addAttribute("pdsList", pdsList);
        //int menu_idx   =   (int) map.get("menu_idx");

        int menu_idx = Integer.parseInt(String.valueOf(map.get("menu_idx")));
        int nowpage = Integer.parseInt(map.get("nowpage").toString());
        int pagecount = Integer.parseInt(map.get("pagecount").toString());
        int startnum = (nowpage - 1) * pagecount + 1;
        int endnum = nowpage * pagecount;

        map.put("startnum", startnum);
        map.put("endnum", endnum);

System.out.println("맵찍어보자:" + map);

        List<PdsPagingVo> pdsPagingList = pdsService.getPdsPagingList(map);

System.out.println("pdsPagingList:" + pdsPagingList);

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


int moim_idx = Integer.parseInt((String) map.get("moim_idx"));

        //   PdsVo   pdsVo    = pdsService.getPds( map );

        ModelAndView mv = new ModelAndView();
        mv.addObject("map", map);
	    mv.addObject("moim_idx", moim_idx);
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

     // 댓글 리스트 불러오기
     	int board_idx = pdsVo.getBoard_idx();
     	List<CommentsVo> CommentsList = pdsService.getCommentsList(board_idx);
     	System.out.println(CommentsList);
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("pdsVo", pdsVo);
        mv.addObject("menu_idx", menu_idx);
        mv.addObject("PdsPagingVo", pdspagingVo);
		mv.addObject("CommentsList", CommentsList);

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
        
        if(map.get("menu_idx").toString().equals("3")){
            return "redirect:/Pds/Album";
             }else{
                   return "redirect:/Pds/List";
             }
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
        pdsService.setUpdate(map);
        
        redirect.addAttribute("menu_idx", map.get("menu_idx").toString());
        redirect.addAttribute("nowpage", "1");
        redirect.addAttribute("pagecount", "10");
        redirect.addAttribute("pagegrpnum", "1");
        redirect.addAttribute("moim_idx",map.get("moim_idx").toString());
        
        if(map.get("menu_idx").toString().equals("3")){
       return "redirect:/Pds/Album";
        }else{
              return "redirect:/Pds/List";
        }
    }


    // 찐사진첩
    @RequestMapping("/Album")
    public String album(PdsVo pdsVo, Model model) {

        List<FilesVo> filesVos = pdsService.selectImage(pdsVo);

        model.addAttribute("ImageList", filesVos);
		model.addAttribute("pdsVo", pdsVo);
		
System.out.println("pdsVo는뭘까22222222?" + pdsVo);

        // 추가필수 !!!
        // SELCET * FROM BOARD WHERE MOIM_IDX = moim_idx 해서 보드 데이터 가져온후
        // 모델에 담아서 보내줘야함 !!  ex) 		model.addAttribute("board",Object);
        return "pds/album";
    }


    @RequestMapping("/Album/WriteForm")
    public ModelAndView album_WriteForm(@RequestParam HashMap<String, Object> map) {
        
    	int moim_idx = Integer.parseInt((String) map.get("moim_idx"));

        ModelAndView mv = new ModelAndView();
        mv.addObject("map", map);
	    mv.addObject("moim_idx", moim_idx);
        mv.setViewName("pds/upload");
        
        return mv;
    }


    @RequestMapping("/Album/upload")
    public String album_upload(PdsVo pdsVo) {
    	
System.out.println("pdsVo:" + pdsVo);

        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid + "_" + pdsVo.getFile().getOriginalFilename();

// 경로 수정할것!!!
//        String uploadFolder = "D:\\ws\\spring\\moim_db2\\src\\main\\webapp\\WEB-INF\\resources\\imgup2\\";
        String uploadFolder = "C:\\Users\\gaden\\git\\TeamGreen\\src\\main\\webapp\\WEB-INF\\resources\\imgup\\";


        Path imageFilePath = Paths.get(uploadFolder + imageFileName);
        System.out.println("파일패스 : " + imageFilePath);
        try {
            Files.write(imageFilePath, pdsVo.getFile().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        pdsService.ImageUpload(pdsVo, imageFileName);

       return "redirect:/Pds/Album?moim_idx=" + pdsVo.getMoim_idx();

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
	
	

