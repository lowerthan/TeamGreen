package com.green.user.vo;

public class UserVo {
	// Fields
	private   String   	user_id;
	private   String   	user_pw;
	private   String   	user_name;
	private   String   	user_cate;
	private	  String	univname;
	
	// constructor
	public UserVo() {}
	public UserVo(String user_id, String user_pw, String user_name, String user_cate, String univname) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_cate = user_cate;
		this.univname = univname;
	}
	
	// getter, setter
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
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
	public String getUnivname() {
		return univname;
	}
	public void setUnivname(String univname) {
		this.univname = univname;
	}
	
	// toString
	@Override
	public String toString() {
		return "UserVo [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_cate="
				+ user_cate + ", univname=" + univname + "]";
	}
	
	
	
	
	
}
