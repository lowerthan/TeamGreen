package com.green.moim.vo;

public class MoimVo {
	
	private String moim_idx; 
	private String moim_name; 
	private String univname;
	private String moim_cate;
	private String user_id;
	private String moim_intro;
	private String user_name;
	private String user_cate;
	
	//Constructors
	public MoimVo() {}
	public MoimVo(String moim_idx, String moim_name, String univname, String moim_cate, String user_id,
			String moim_intro, String user_name, String user_cate) {
		this.moim_idx = moim_idx;
		this.moim_name = moim_name;
		this.univname = univname;
		this.moim_cate = moim_cate;
		this.user_id = user_id;
		this.moim_intro = moim_intro;
		this.user_name = user_name;
		this.user_cate = user_cate;
	}
	
	//Getter / Setter
	public String getMoim_idx() {
		return moim_idx;
	}
	public void setMoim_idx(String moim_idx) {
		this.moim_idx = moim_idx;
	}
	public String getMoim_name() {
		return moim_name;
	}
	public void setMoim_name(String moim_name) {
		this.moim_name = moim_name;
	}
	public String getUnivname() {
		return univname;
	}
	public void setUnivname(String univname) {
		this.univname = univname;
	}
	public String getMoim_cate() {
		return moim_cate;
	}
	public void setMoim_cate(String moim_cate) {
		this.moim_cate = moim_cate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMoim_intro() {
		return moim_intro;
	}
	public void setMoim_intro(String moim_intro) {
		this.moim_intro = moim_intro;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_cate() {
		return user_cate;
	}
	public void setUser_cate(String user_cate) {
		this.user_cate = user_cate;
	}
	@Override
	public String toString() {
		return "MoimVo [moim_idx=" + moim_idx + ", moim_name=" + moim_name + ", univname=" + univname + ", moim_cate="
				+ moim_cate + ", user_id=" + user_id + ", moim_intro=" + moim_intro + ", user_name=" + user_name
				+ ", user_cate=" + user_cate + "]";
	}
	
	

	
}
