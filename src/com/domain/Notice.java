package com.domain;

import java.util.Date;

public class Notice {
    private int Nno;
    private String title;
    private String content;
    private String editor;
    private Date createtime;
    private int type;
    
    public Notice(){}

	public int getNno() {
		return Nno;
	}

	public void setNno(int nno) {
		Nno = nno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
    
    
}
