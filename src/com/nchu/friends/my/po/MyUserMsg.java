package com.nchu.friends.my.po;

import java.util.Date;

public class MyUserMsg {
	Integer msgid;
	Integer userid;
	Date msgdate ;
	String msgtitle ;
	String msguser ;
	String msgbody ;
	Integer commentnum ;
	Integer likenum ;
	Integer dislikenum ;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getMsgid() {
		return msgid;
	}
	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
	}
	public Date getMsgdate() {
		return msgdate;
	}
	public String getMsgtitle() {
		return msgtitle;
	}
	public String getMsguser() {
		return msguser;
	}
	public String getMsgbody() {
		return msgbody;
	}
	public Integer getCommentnum() {
		return commentnum;
	}
	public Integer getLikenum() {
		return likenum;
	}
	public Integer getDislikenum() {
		return dislikenum;
	}
	public void setMsgdate(Date date) {
		this.msgdate = date;
	}
	public void setMsgtitle(String msgtitle) {
		this.msgtitle = msgtitle;
	}
	public void setMsguser(String msguser) {
		this.msguser = msguser;
	}
	public void setMsgbody(String msgbody) {
		this.msgbody = msgbody;
	}
	public void setCommentnum(Integer commentnum) {
		this.commentnum = commentnum;
	}
	public void setLikenum(Integer likenum) {
		this.likenum = likenum;
	}
	public void setDislikenum(Integer dislikenum) {
		this.dislikenum = dislikenum;
	}
	
}
