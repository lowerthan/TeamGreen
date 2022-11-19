package com.green.pds.vo;

import org.springframework.web.multipart.MultipartFile;

public class PdsVo {
	// Fields
	// Board 게시물
	private  int     board_idx;
	private  String  board_title;
	private  String  board_cont;
	private  String  user_id;
	private  String  board_regdate;
	private  String  readcount;
	
	// board 답글 관련
	private  int     bnum;
	private  int     lvl;
	private  int     step;
	private  int     nref;
	
	// 현재 menu 정보
	private  int  menu_idx;

	private int   moim_idx;
	
	// 파일관련
	private MultipartFile file;

	private  int  filescount;

	//paging 처리를 위해 추가
	private int nowpage; //현재페이지
	private int prevnowpage; //이전 10개를 클릭시 적용되는 nowpage
	private int nextnowpage; //다음 10개를 클릭시 적용되는  nowpage
	
	
	// Constructor
	public PdsVo() { }

	public PdsVo(int board_idx, String board_title, String board_cont, String user_id, String board_regdate, String readcount, int bnum, int lvl, int step, int nref, int menu_idx, MultipartFile file, int filescount,
			int nowpage, int prevnowpage, int nextnowpage, int moim_idx) {
		this.board_idx = board_idx;
		this.board_title = board_title;
		this.board_cont = board_cont;
		this.user_id = user_id;
		this.board_regdate = board_regdate;
		this.readcount = readcount;
		this.bnum = bnum;
		this.lvl = lvl;
		this.step = step;
		this.nref = nref;
		this.menu_idx = menu_idx;
		this.moim_idx = moim_idx;
		this.file = file;
		this.filescount = filescount;
		this.nowpage = nowpage;
		this.prevnowpage = prevnowpage;
		this.nextnowpage = nextnowpage;
		
	}



	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_cont() {
		return board_cont;
	}

	public void setBoard_cont(String board_cont) {
		this.board_cont = board_cont;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBoard_regdate() {
		return board_regdate;
	}

	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}

	public String getReadcount() {
		return readcount;
	}

	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getNref() {
		return nref;
	}

	public void setNref(int nref) {
		this.nref = nref;
	}

	public int getMenu_idx() {
		return menu_idx;
	}

	public void setMenu_idx(int menu_idx) {
		this.menu_idx = menu_idx;
	}

	public int getMoim_idx() {
		return moim_idx;
	}

	public void setMoim_idx(int moim_idx) {
		this.moim_idx = moim_idx;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getFilescount() {
		return filescount;
	}

	public void setFilescount(int filescount) {
		this.filescount = filescount;
	}

	public int getNowpage() {
		return nowpage;
	}

	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}

	public int getPrevnowpage() {
		return prevnowpage;
	}

	public void setPrevnowpage(int prevnowpage) {
		this.prevnowpage = prevnowpage;
	}

	public int getNextnowpage() {
		return nextnowpage;
	}

	public void setNextnowpage(int nextnowpage) {
		this.nextnowpage = nextnowpage;
	}

	@Override
	public String toString() {
		return "PdsVo [board_idx=" + board_idx + ", board_title=" + board_title + ", board_cont=" + board_cont
				+ ", user_id=" + user_id + ", board_regdate=" + board_regdate + ", readcount=" + readcount + ", bnum="
				+ bnum + ", lvl=" + lvl + ", step=" + step + ", nref=" + nref + ", menu_idx=" + menu_idx + ", moim_idx="
				+ moim_idx + ", file=" + file + ", filescount=" + filescount + ", nowpage=" + nowpage + ", prevnowpage="
				+ prevnowpage + ", nextnowpage=" + nextnowpage + "]";
	}

	
	
	
//	public int getMenu_board_idx() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
		
	
}








