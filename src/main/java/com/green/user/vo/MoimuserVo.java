package com.green.user.vo;

public class MoimuserVo {
	private String moim_idx;
	private String moim_name;
	private String moim_cate;
	private String moim_intro;
	private String user_id;
	
	//Constructor
	public MoimuserVo(){}

	public MoimuserVo(String moim_idx, String moim_name, String moim_cate, String moim_intro, String user_id) {
		super();
		this.moim_idx = moim_idx;
		this.moim_name = moim_name;
		this.moim_cate = moim_cate;
		this.moim_intro = moim_intro;
		this.user_id = user_id;
	}

	//Getter&Setter
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

	public String getMoim_cate() {
		return moim_cate;
	}

	public void setMoim_cate(String moim_cate) {
		this.moim_cate = moim_cate;
	}

	public String getMoim_intro() {
		return moim_intro;
	}

	public void setMoim_intro(String moim_intro) {
		this.moim_intro = moim_intro;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	
	//toString
	@Override
	public String toString() {
		return "MoimuserVo [moim_idx=" + moim_idx + ", moim_name=" + moim_name + ", moim_cate=" + moim_cate
				+ ", moim_intro=" + moim_intro + ", user_id=" + user_id + "]";
	}	

}
