package com.nchu.friends.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.appender.AbstractOutputStreamAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nchu.friends.mapper.HomenoteMapper;
import com.nchu.friends.mapper.NotereplyMapper;
import com.nchu.friends.mapper.UserinfoMapper;
import com.nchu.friends.mapper.UsermsgMapper;
import com.nchu.friends.my.po.MyUserMsg;
import com.nchu.friends.my.po.status;
import com.nchu.friends.po.Homenote;
import com.nchu.friends.po.HomenoteExample;
import com.nchu.friends.po.Notereply;
import com.nchu.friends.po.NotereplyExample;
import com.nchu.friends.po.Userinfo;
import com.nchu.friends.po.UserinfoExample;
import com.nchu.friends.po.Usermsg;
import com.nchu.friends.po.UsermsgExample;
import com.nchu.friends.utility.Encrypt;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.xml.internal.bind.v2.runtime.reflect.TransducedAccessor;


@Controller
public class testController {
	
	@Autowired
	UserinfoMapper userinfoMapper;
	
	@Autowired
	HomenoteMapper homenoteMapper;
	
	@Autowired
	UsermsgMapper usermsgMapper;
	
	@Autowired
	NotereplyMapper notereplyMapper;
	
	@RequestMapping("/")
	public String MainFrame(){
		
		
		return "websocketTest";
		
	}
	
	
	@RequestMapping("/checkReg")
	@ResponseBody
	public status checkReg(HttpServletRequest request,HttpServletResponse response,String user,String password,String repasswd,String QQ) throws IOException{
		
		status s=new status();
		
		/*判断两次输入的密码是否一致，本来可以在js里面判断*/
		if (password.equals(repasswd)) {
			
			/*注册前判断是否有相同的用户名存在*/
			UserinfoExample example =new UserinfoExample();
			com.nchu.friends.po.UserinfoExample.Criteria criteria=example.createCriteria();
			criteria.andUsernameEqualTo(user);
			
			List<Userinfo> list=userinfoMapper.selectByExample(example);
			if(list.size()>0){
				s.setState("false");
			}
			else if(QQ.length()<6 || QQ.length()>12){
				s.setState("QQ");
			}
			else if(password.length()<6){
				s.setState("short");
			}
			else{
				Userinfo login=new Userinfo();
				login.setUsername(user);
				login.setUserpsw(Encrypt.encryptLoginPassword(password));
				login.setUserqq(QQ);
				login.setLoginflag(1);
				userinfoMapper.insert(login);
				s.setState("true");
			}
			
			
			
			
		}
		else{
			/*response.setCharacterEncoding("utf-8");
			response.getWriter().write("{\"error\":true}");
			response.getWriter().flush();*/
			s.setState("pass");
		}
		return s;
	}
	
	@RequestMapping("/checkLogin")
	@ResponseBody
	public status checkLogin(String user,String password){
		status s=new status();
		
		UserinfoExample example =new UserinfoExample();
		com.nchu.friends.po.UserinfoExample.Criteria criteria=example.createCriteria();
		criteria.andUsernameEqualTo(user);
		criteria.andUserpswEqualTo(Encrypt.encryptLoginPassword(password));
		
		List<Userinfo> list=userinfoMapper.selectByExample(example);
		if(list.size()==1){
			/*添加通过username修改数据库中login表的loginFlag的状态*/
			list.get(0).setLoginflag(1);
			userinfoMapper.updateByExample(list.get(0), example) ;		
			/*彭建加上*/
			s.setState("true");
		}
		else
			s.setState("false");
		return s;
	}
	@RequestMapping("/logout")
	@ResponseBody
	public void logout(String user){
		UserinfoExample example =new UserinfoExample();
		com.nchu.friends.po.UserinfoExample.Criteria criteria=example.createCriteria();
		criteria.andUsernameEqualTo(user);
		
		List<Userinfo> list=userinfoMapper.selectByExample(example);
		if(list.size()==1){
			/*添加通过username修改数据库中login表的loginFlag的状态*/
			list.get(0).setLoginflag(0);
			userinfoMapper.updateByExample(list.get(0), example) ;		
			/*彭建加上*/
		}	
	}
	
	@RequestMapping("/getnotes")
	@ResponseBody
	public List<Homenote> getnotes(){
		HomenoteExample example =new HomenoteExample();
		List<Homenote> list =homenoteMapper.selectByExampleWithBLOBs(example);
		return list;
	}
	@RequestMapping("/tucao")
	@ResponseBody
	public void Tucao(String note,String user) {
		Homenote homenote =new Homenote();
		homenote.setUsername(user);
		homenote.setLikenum(0);
		homenote.setDislikenum(0);
		homenote.setNote(note);
		
		homenoteMapper.insert(homenote);
		
	}
	
	@RequestMapping("/supportnote")
	@ResponseBody
	public Integer support(Integer noteid, Integer likenum,String user){
		
		
		UserinfoExample example1 =new UserinfoExample();
		com.nchu.friends.po.UserinfoExample.Criteria criteria1=example1.createCriteria();
		criteria1.andUsernameEqualTo(user);
		
		List<Userinfo> userinfos=userinfoMapper.selectByExample(example1);
		Integer userid=userinfos.get(0).getUserid();
		
		NotereplyExample notereplyExample =new NotereplyExample();
		com.nchu.friends.po.NotereplyExample.Criteria criteria2=notereplyExample.createCriteria();
		criteria2.andUseridEqualTo(userid);
		criteria2.andNoteidEqualTo(noteid);
		
		List<Notereply> notereplies =notereplyMapper.selectByExample(notereplyExample);
		
		if(notereplies.size()>=1)  //如果该用户已为这个帖子点过赞，则直接返回-1，否则就记录该用户为该帖子点过赞或踩
			return -1;
		else{
			HomenoteExample example =new HomenoteExample();
			com.nchu.friends.po.HomenoteExample.Criteria criteria=example.createCriteria();
			criteria.andNoteidEqualTo(noteid);
			List<Homenote> list=homenoteMapper.selectByExample(example);
			if(list.size()==1){	
				list.get(0).setLikenum(likenum+1);
				homenoteMapper.updateByExample(list.get(0), example) ;
				
				Notereply record =new Notereply();
				record.setIslike(true);
				record.setIsdislike(false);
				record.setNoteid(noteid);
				record.setUserid(userid);
				
				notereplyMapper.insert(record);
			}	
			return likenum+1;
		}
	}
		
		
	
	@RequestMapping("/dislikenote")
	@ResponseBody
	public Integer dislike(Integer noteid, Integer dislikenum,String user){

		UserinfoExample example1 =new UserinfoExample();
		com.nchu.friends.po.UserinfoExample.Criteria criteria1=example1.createCriteria();
		criteria1.andUsernameEqualTo(user);
		
		List<Userinfo> userinfos=userinfoMapper.selectByExample(example1);
		Integer userid=userinfos.get(0).getUserid();
		
		NotereplyExample notereplyExample =new NotereplyExample();
		com.nchu.friends.po.NotereplyExample.Criteria criteria2=notereplyExample.createCriteria();
		criteria2.andUseridEqualTo(userid);
		criteria2.andNoteidEqualTo(noteid);
		
		List<Notereply> notereplies =notereplyMapper.selectByExample(notereplyExample);
		
		if(notereplies.size()>=1)  //如果该用户已为这个帖子点过赞，则直接返回-1，否则就记录该用户为该帖子点过赞或踩
			return -1;
		else{
			HomenoteExample example =new HomenoteExample();
			com.nchu.friends.po.HomenoteExample.Criteria criteria=example.createCriteria();
			criteria.andNoteidEqualTo(noteid);
			
			List<Homenote> list=homenoteMapper.selectByExample(example);
			if(list.size()==1){	
				list.get(0).setDislikenum(dislikenum+1);   
				homenoteMapper.updateByExample(list.get(0), example) ;
				
				Notereply record =new Notereply();
				record.setIsdislike(true);
				record.setIslike(false);
				record.setNoteid(noteid);
				record.setUserid(userid);
				
				notereplyMapper.insert(record);
			}	
			return dislikenum+1;
		}
	}
	
	@RequestMapping("/cooperation")
	public String cooperation(String user){
			
		return "cooperation";
	}
	
	@RequestMapping("/getmsgdata")
	@ResponseBody
	public List<MyUserMsg> getmsgdata(){
		UsermsgExample usermsgExample = new UsermsgExample() ;
		usermsgExample.setOrderByClause("msgdate DESC");
		List<Usermsg> usermsgs = usermsgMapper.selectByExampleWithBLOBs(usermsgExample);
		
		List<MyUserMsg> myUserMsgs = new ArrayList<MyUserMsg>() ;
		for(int i =0 ; i< usermsgs.size();i++)
		{

			MyUserMsg myUserMsg = new MyUserMsg() ;
			myUserMsg.setUserid(usermsgs.get(i).getUserid());
			myUserMsg.setMsgid(usermsgs.get(i).getMsgid());
			myUserMsg.setMsgbody(usermsgs.get(i).getMsgbody());
			myUserMsg.setMsgtitle(usermsgs.get(i).getMsgtitle());
			myUserMsg.setMsgdate(usermsgs.get(i).getMsgdate());
			myUserMsg.setLikenum(usermsgs.get(i).getLikenum());
			myUserMsg.setDislikenum(usermsgs.get(i).getDislikenum());	
			myUserMsg.setCommentnum(usermsgs.get(i).getCommentnum());

			
			Userinfo userinfo = userinfoMapper.selectByPrimaryKey(usermsgs.get(i).getUserid()) ;
			String msguser = userinfo.getUsername();
			myUserMsg.setMsguser(msguser);
			
			myUserMsgs.add(i,myUserMsg) ;				
			

		}
		
		return myUserMsgs ;
		
	}
	
	
	@RequestMapping("/classical")
	public String classical()
	{
		return "classical" ;
	}
	
	@RequestMapping("/classicaldata")
	@ResponseBody
	public List<MyUserMsg> classicaldata(){
		UsermsgExample usermsgExample = new UsermsgExample() ;
		usermsgExample.setOrderByClause("likeNum DESC");
		List<Usermsg> usermsgs = usermsgMapper.selectByExampleWithBLOBs(usermsgExample);
		
		List<MyUserMsg> myUserMsgs = new ArrayList<MyUserMsg>() ;
		for(int i =0 ; i< usermsgs.size();i++)
		{
			if(usermsgs.get(i).getLikenum() >= 64)
			{
				MyUserMsg myUserMsg = new MyUserMsg() ;
				myUserMsg.setMsgid(usermsgs.get(i).getMsgid());
				myUserMsg.setMsgbody(usermsgs.get(i).getMsgbody());
				myUserMsg.setMsgtitle(usermsgs.get(i).getMsgtitle());
				myUserMsg.setMsgdate(usermsgs.get(i).getMsgdate());
				myUserMsg.setLikenum(usermsgs.get(i).getLikenum());
				myUserMsg.setDislikenum(usermsgs.get(i).getDislikenum());	
				myUserMsg.setCommentnum(usermsgs.get(i).getCommentnum());
	
				
				Userinfo userinfo = userinfoMapper.selectByPrimaryKey(usermsgs.get(i).getUserid()) ;
				String msguser = userinfo.getUsername();
				myUserMsg.setMsguser(msguser);
				
				myUserMsgs.add(i,myUserMsg) ;
			}
		}
		
		return myUserMsgs ;
		
	}
	
	@RequestMapping("/getIsdot")
	@ResponseBody
	public Integer getIsdot(String username,Integer noteid){
		UserinfoExample example1 =new UserinfoExample();
		com.nchu.friends.po.UserinfoExample.Criteria criteria1=example1.createCriteria();
		criteria1.andUsernameEqualTo(username);
		
		List<Userinfo> userinfos=userinfoMapper.selectByExample(example1);
		Integer userid=userinfos.get(0).getUserid();
		
		NotereplyExample example =new NotereplyExample();
		com.nchu.friends.po.NotereplyExample.Criteria criteria =example.createCriteria();
		criteria.andNoteidEqualTo(noteid);
		criteria.andUseridEqualTo(userid);
		
		List<Notereply> list =notereplyMapper.selectByExample(example);
		if(list.size()>0){
			if(list.get(0).getIslike()==true){
				return 1;
			}
			else if(list.get(0).getIsdislike()==true)
				return -1;
		}
		
		return 0;
		
	}
	
	@RequestMapping("/about")
	public String about(){
		
		
		return "about";
	}
	
	@RequestMapping("/listUser")
	public String listUser(Map<String,Userinfo> map){
		Userinfo login =userinfoMapper.selectByPrimaryKey(1);
		map.put("user",login);	
		return "listUser";
	}
	
	
	@RequestMapping(value="/uploadPhoto",method=RequestMethod.POST )  
	   @ResponseBody  
	   public String uploadImage(HttpServletRequest request,  
	           HttpServletResponse response, HttpSession session,  
	           @RequestParam(value = "file", required = true) MultipartFile file)throws IllegalStateException, IOException {  
	       //String path = session.getServletContext().getRealPath("/upload");  
	       String pic_path = "F:/myJavaProject/Friends/WebContent/WEB-INF/touxiang";  
	       System.out.println("real path: " + pic_path);  
	       String fileName = file.getOriginalFilename();  
	       System.out.println("file name: " + fileName);  
	       File targetFile = new File(pic_path, fileName);  
	       if (!targetFile.exists()) {  
	           targetFile.mkdirs();  
	       }  
	       file.transferTo(targetFile);  
	       String fileUrl = fileName;  
	       return fileUrl;  
	   } 
	
}
