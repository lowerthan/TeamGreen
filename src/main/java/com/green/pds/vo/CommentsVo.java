package com.green.pds.vo;

public class CommentsVo {
	private String user_id;
	private String regdate;
	private String cont;
	private int board_idx;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	
	public CommentsVo() {}
	public CommentsVo(String user_id, String regdate, String cont, int board_idx) {
		this.user_id = user_id;
		this.regdate = regdate;
		this.cont = cont;
		this.board_idx = board_idx;
	}
	
	@Override
	public String toString() {
		return "CommentsVo [user_id=" + user_id + ", regdate=" + regdate + ", cont=" + cont + ", board_idx=" + board_idx
				+ "]";
	}
	
	
}
