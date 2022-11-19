package com.green.pds.vo;

public class PdsPagingVo {

	private int board_idx;
	private String board_title;
	private String board_cont;
	private String board_regdate;
	private int readcount;
	private String user_id;

	private int filescount;

	private int bnum;
	private int lvl;
	private int step;
	private int nref;
	private int delnum;

	public int getFilescount() {
		return filescount;
	}

	public void setFilescount(int filescount) {
		this.filescount = filescount;
	}

	private int menu_idx;
	private int moim_idx;

	private String file_num;
	private String filename;
	private String fileext;
	private String sfilename;

	// paging 처리를 위해 추가
	private int nowpage; // 현재페이지
	private int prevnowpage; // 이전 10개를 클릭시 적용되는 nowpage
	private int nextnowpage; // 다음 10개를 클릭시 적용되는 nowpage

	private int totalcount; // 전체 ROW 수
	private int totalpagecount; // 화면에 보여줄 페이지 수
	private int startnum; // 화면에 보여줄 페이지 시작 숫자
	private int endnum; // 화면에 보여줄 페이지 마지막 숫자
	private int pagegrpnum; // 페이지 그룹 숫자
	private int pagecount; // 한페이지에 보여줄 ROW 숫자

	private boolean isshowpageprev;
	private boolean isshowpagenext;

	// Getter /setter
	public int getboard_idx() {
		return board_idx;
	}

	public void setboard_idx(int board_idx) {
		this.board_idx = board_idx;
	}

	public String getboard_title() {
		return board_title;
	}

	public void setboard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getboard_cont() {
		return board_cont;
	}

	public void setboard_cont(String board_cont) {
		this.board_cont = board_cont;
	}

	public String getboard_regdate() {
		return board_regdate;
	}

	public void setboard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}

	public String getuser_id() {
		return user_id;
	}

	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
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

	public int getDelnum() {
		return delnum;
	}

	public void setDelnum(int delnum) {
		this.delnum = delnum;
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

	public String getFile_num() {
		return file_num;
	}

	public void setFile_num(String file_num) {
		this.file_num = file_num;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileext() {
		return fileext;
	}

	public void setFileext(String fileext) {
		this.fileext = fileext;
	}

	public String getSfilename() {
		return sfilename;
	}

	public void setSfilename(String sfilename) {
		this.sfilename = sfilename;
	}

	public int getNowpage() {
		return nowpage;
	}

	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	public int getTotalpagecount() {
		return totalpagecount;
	}

	public void setTotalpagecount(int totalpagecount) {
		this.totalpagecount = totalpagecount;
	}

	public int getstartnum() {
		return startnum;
	}

	public void setstartnum(int startnum) {
		this.startnum = startnum;
	}

	public int getendnum() {
		return endnum;
	}

	public void setendnum(int endnum) {
		this.endnum = endnum;
	}

	public boolean isIsshowpageprev() {
		return isshowpageprev;
	}

	public void setIsshowpageprev(boolean isshowpageprev) {
		this.isshowpageprev = isshowpageprev;
	}

	public boolean isIsshowpagenext() {
		return isshowpagenext;
	}

	public void setIsshowpagenext(boolean isshowpagenext) {
		this.isshowpagenext = isshowpagenext;
	}

	public int getPagegrpnum() {
		return pagegrpnum;
	}

	public void setPagegrpnum(int pagegrpnum) {
		this.pagegrpnum = pagegrpnum;
	}

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}

	public int getPrevnowpage() {
		return prevnowpage;
	}

	public void setPrevnowpage(int prenowpage) {
		this.prevnowpage = prenowpage;
	}

	public int getNextnowpage() {
		return nextnowpage;
	}

	public void setNextnowpage(int nextnowpage) {
		this.nextnowpage = nextnowpage;
	}
}
