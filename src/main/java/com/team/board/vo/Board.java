package com.team.board.vo;

import java.util.Date;

import com.team.board.vo.type.BoardType;

public class Board {
	private String b_title;
	private String b_writer;
	private int b_id;
	private String b_date;
	private String b_content;
	private int b_readcount;
	private BoardType b_type;
	
	
	public BoardType getB_type() {
		return b_type;
	}
	public void setB_type(BoardType b_type) {
		this.b_type = b_type;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public int getB_readcount() {
		return b_readcount;
	}
	public void setB_readcount(int b_readcount) {
		this.b_readcount = b_readcount;
	}
	@Override
	public String toString() {
		return "Board [b_title=" + b_title + ", b_writer=" + b_writer + ", b_id=" + b_id + ", b_date=" + b_date
				+ ", b_content=" + b_content + ", b_readcount=" + b_readcount + ", b_type=" + b_type + "]";
	}
	
	
}
