package com.yu.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Gonggao {
    private Integer id;

    private String name;

    private String content;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Gonggao [id=" + id + ", name=" + name + ", content=" + content + ", date=" + date + "]";
	}
    
  
    
    
}