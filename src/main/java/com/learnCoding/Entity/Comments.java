package com.learnCoding.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comments 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int commetid;
	String comment;
	public Comments(int commetid, String comment) {
		super();
		this.commetid = commetid;
		this.comment = comment;
	}
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCommetid() {
		return commetid;
	}
	public void setCommetid(int commetid) {
		this.commetid = commetid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Comments [commetid=" + commetid + ", comment=" + comment + "]";
	}
	
	
}
