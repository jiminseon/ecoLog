package model;

import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
public class Post implements Serializable{
	private int postNum; //게시글 번호
	private String title; //제목
	private String writer; //작성자
	private String category; //게시글 유형
	private String content; //게시글 내용
	private int visitCount; //조회수
	private Date writeDate; //작성일
	private String regdate; //작성일(String)
	
	public Post() {}
	
	public Post(int postNum, String title, String content) {
		super();
		this.postNum = postNum;
		this.title = title;
		this.content = content;
	}
	
	public Post(int postNum, String title, String writer, String category, String content, Date writeDate) {
		super();
		this.postNum = postNum;
		this.title = title;
		this.writer = writer;
		this.category = category;
		this.content = content;
		this.writeDate = writeDate;
	}

	public Post(String title, String writer, String category, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.category = category;
		this.content = content;
	}
	
	public Post(int postNum, String title, String writer, String category, String content, Date writeDate, int visitCount) {
		super();
		this.postNum = postNum;
		this.title = title;
		this.writer = writer;
		this.category = category;
		this.content = content;
		this.writeDate = writeDate;
		this.visitCount = visitCount;
	}
	
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
