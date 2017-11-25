package com.nchu.friends.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.Reader;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.friends.mapper.HomenoteMapper;
import com.nchu.friends.mapper.MsgreplyMapper;
import com.nchu.friends.mapper.NotereplyMapper;
import com.nchu.friends.mapper.UserinfoMapper;
import com.nchu.friends.mapper.UsermsgMapper;
import com.nchu.friends.my.po.commentjson;
import com.nchu.friends.po.Msgreply;
import com.nchu.friends.po.MsgreplyExample;
import com.nchu.friends.po.Userinfo;
import com.nchu.friends.po.UserinfoExample;
import com.nchu.friends.po.Usermsg;
import com.nchu.friends.po.UsermsgExample;
import com.sun.org.apache.bcel.internal.generic.RETURN;

@Controller
public class cooperationController {
	
	@Autowired
	UserinfoMapper userinfoMapper;
	
	@Autowired
	HomenoteMapper homenoteMapper;
	
	@Autowired
	UsermsgMapper usermsgMapper;
	
	@Autowired
	NotereplyMapper notereplyMapper;
	@Autowired
	MsgreplyMapper msgreplyMapper;
	
	@RequestMapping("/postmsg")
	@ResponseBody
	public void postmsg(String msgbody,String username,String msgtitle){
		UserinfoExample example1 =new UserinfoExample();
		com.nchu.friends.po.UserinfoExample.Criteria criteria1=example1.createCriteria();
		criteria1.andUsernameEqualTo(username);
		
		List<Userinfo> userinfos=userinfoMapper.selectByExample(example1);
		Integer userid=userinfos.get(0).getUserid();
		
		Usermsg usermsg =new Usermsg();
		usermsg.setUserid(userid);
		usermsg.setMsgtitle(msgtitle);
		usermsg.setMsgbody(msgbody);
		usermsg.setLikenum(0);
		usermsg.setDislikenum(0);
		usermsg.setCommentnum(0);
		usermsg.setMsgdate(new Date());
		
		usermsgMapper.insert(usermsg);		
	}
	@RequestMapping("/supportmsg")
	@ResponseBody
	public Integer supportmsg(Integer msgid,String username,Integer likenum){
		
		UserinfoExample example1 =new UserinfoExample();
		com.nchu.friends.po.UserinfoExample.Criteria criteria1=example1.createCriteria();
		criteria1.andUsernameEqualTo(username);
		
		List<Userinfo> userinfos=userinfoMapper.selectByExample(example1);
		Integer userid=userinfos.get(0).getUserid();
		
		MsgreplyExample example =new MsgreplyExample();
		com.nchu.friends.po.MsgreplyExample.Criteria criteria=example.createCriteria();
		criteria.andMsgidEqualTo(msgid);
		criteria.andUseridEqualTo(userid);
		
		List<Msgreply> list= msgreplyMapper.selectByExample(example);
		
		if(list.size()>=1){
			for(int i=0;i<list.size();++i){
				if(list.get(i).getIsdislike()==true || list.get(i).getIslike()==true){
					return -1;
				}
			}
		}	
		
			UsermsgExample example2 =new UsermsgExample();
			com.nchu.friends.po.UsermsgExample.Criteria criteria2=example2.createCriteria();
			criteria2.andMsgidEqualTo(msgid);
			
			List<Usermsg> record = usermsgMapper.selectByExample(example2);
			if(likenum==null){
				record.get(0).setLikenum(1);
			}
			else{
				record.get(0).setLikenum(likenum+1);
			}
			
			
			usermsgMapper.updateByExample(record.get(0), example2);
			
			Msgreply msgreply =new Msgreply();
			msgreply.setMsgid(msgid);
			msgreply.setUserid(userid);
			msgreply.setIslike(true);
			msgreply.setIsdislike(false);
			
			msgreplyMapper.insert(msgreply);
		
		
		return likenum+1;
	}
	
	@RequestMapping("/losmsg")
	@ResponseBody
	public Integer caimsg(Integer msgid,String username,Integer dislikenum){
		
		UserinfoExample example1 =new UserinfoExample();
		com.nchu.friends.po.UserinfoExample.Criteria criteria1=example1.createCriteria();
		criteria1.andUsernameEqualTo(username);
		
		List<Userinfo> userinfos=userinfoMapper.selectByExample(example1);
		Integer userid=userinfos.get(0).getUserid();
		
		MsgreplyExample example =new MsgreplyExample();
		com.nchu.friends.po.MsgreplyExample.Criteria criteria=example.createCriteria();
		criteria.andMsgidEqualTo(msgid);
		criteria.andUseridEqualTo(userid);
		
		List<Msgreply> list= msgreplyMapper.selectByExample(example);
		
		if(list.size()>=1){
			for(int i=0;i<list.size();++i){
				if(list.get(i).getIsdislike()==true || list.get(i).getIslike()==true){
					return -1;
				}
			}
			
		}	
		
			UsermsgExample example2 =new UsermsgExample();
			com.nchu.friends.po.UsermsgExample.Criteria criteria2=example2.createCriteria();
			criteria2.andMsgidEqualTo(msgid);
			
			List<Usermsg> record = usermsgMapper.selectByExample(example2);
			
			if(dislikenum == null)
			{
				record.get(0).setDislikenum(1);
			}
				
			else
				record.get(0).setDislikenum(dislikenum+1);
			usermsgMapper.updateByExample(record.get(0), example2);
			
			Msgreply msgreply =new Msgreply();
			msgreply.setMsgid(msgid);
			msgreply.setUserid(userid);
			msgreply.setIsdislike(true);
			msgreply.setIslike(false);
			
			msgreplyMapper.insert(msgreply);
		
		
		return dislikenum+1;
	}
	
	@RequestMapping("/subcomment")
	@ResponseBody
	public Integer subcomment(String comment,Integer msgid,String username ){
		
		UserinfoExample example1 =new UserinfoExample();
		com.nchu.friends.po.UserinfoExample.Criteria criteria1=example1.createCriteria();
		criteria1.andUsernameEqualTo(username);
		
		List<Userinfo> userinfos=userinfoMapper.selectByExample(example1);
		Integer userid=userinfos.get(0).getUserid();
		
		MsgreplyExample example =new MsgreplyExample();
		com.nchu.friends.po.MsgreplyExample.Criteria criteria=example.createCriteria();
		criteria.andMsgidEqualTo(msgid);
		criteria.andUseridEqualTo(userid);
		
		List<Msgreply> list= msgreplyMapper.selectByExampleWithBLOBs(example);
		
		if(list.size()>0){					//判断该用户是否已经为该帖子点过赞或者踩或者已经评论过一次的话
			
			if(list.get(0).getComment()==null){ 	//判断是否以点过赞但是没有评论过，如果是，就把是点赞还是踩 
				list.get(0).setComment(comment);	
				msgreplyMapper.updateByExampleWithBLOBs(list.get(0), example);
			}

			else{									//否则，就新插入一行保存评论
				Msgreply msgreply=new Msgreply();
				msgreply.setComment(comment);
				msgreply.setIsdislike(list.get(0).getIsdislike());
				msgreply.setIslike(list.get(0).getIslike());
				msgreply.setMsgid(msgid);
				msgreply.setUserid(userid);
				
				msgreplyMapper.insert(msgreply);
			}
		}
		else{
			Msgreply msgreply=new Msgreply();
			msgreply.setComment(comment);
			msgreply.setIsdislike(false);
			msgreply.setIslike(false);
			msgreply.setMsgid(msgid);
			msgreply.setUserid(userid);
			msgreplyMapper.insert(msgreply);
		}
		
		UsermsgExample example2 =new UsermsgExample();
		com.nchu.friends.po.UsermsgExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andMsgidEqualTo(msgid);
		
		List<Usermsg> usermsgs=usermsgMapper.selectByExample(example2);
		Integer cnum=usermsgs.get(0).getCommentnum()+1;
		usermsgs.get(0).setCommentnum(cnum);
		
		usermsgMapper.updateByExample(usermsgs.get(0), example2);
		
		return cnum;
	}

	@RequestMapping("/getcomment")
	@ResponseBody
	public List<commentjson> getcomment(Integer msgid){
		
		List<commentjson> commentjson = new LinkedList<commentjson>();
		
		MsgreplyExample example2 =new MsgreplyExample();
		com.nchu.friends.po.MsgreplyExample.Criteria criteria2=example2.createCriteria();
		criteria2.andMsgidEqualTo(msgid);
		
		List<Msgreply> msgreplies =msgreplyMapper.selectByExampleWithBLOBs(example2);
		for(int i=0;i<msgreplies.size();++i){
			
			if(msgreplies.get(i).getComment()==null)
				continue;
			commentjson comment=new commentjson();
			UserinfoExample example =new UserinfoExample();
			com.nchu.friends.po.UserinfoExample.Criteria criteria=example.createCriteria();
			comment.setComment(msgreplies.get(i).getComment());
			
			criteria.andUseridEqualTo(msgreplies.get(i).getUserid());
			List<Userinfo> user1 =userinfoMapper.selectByExample(example);
			
			comment.setUsername(user1.get(0).getUsername());
			
			commentjson.add(comment);
		}
		
		
		return commentjson;
	}
	
	@RequestMapping("/getqqnumber")
	@ResponseBody
	public String getqqnumber(String name){
		
		UserinfoExample example1 =new UserinfoExample();
		com.nchu.friends.po.UserinfoExample.Criteria criteria1=example1.createCriteria();
		criteria1.andUsernameEqualTo(name);
		
		List<Userinfo> userinfos=userinfoMapper.selectByExample(example1);
		String userqq=userinfos.get(0).getUserqq();
		return userqq ;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/getIsSupported")
	@ResponseBody
	public Integer getIsSupported(String username,Integer msgid){
		UserinfoExample example1 =new UserinfoExample();
		com.nchu.friends.po.UserinfoExample.Criteria criteria1=example1.createCriteria();
		criteria1.andUsernameEqualTo(username);
		
		List<Userinfo> userinfos=userinfoMapper.selectByExample(example1);
		Integer userid=userinfos.get(0).getUserid();
		
		MsgreplyExample example =new MsgreplyExample();
		com.nchu.friends.po.MsgreplyExample.Criteria criteria=example.createCriteria();
		criteria.andMsgidEqualTo(msgid);
		criteria.andUseridEqualTo(userid);
		
		List<Msgreply> list= msgreplyMapper.selectByExample(example);
		
		for(int i=0;i<list.size();++i){
			if(list.get(i).getIslike()==true){
				return 1;
			}
			else if(list.get(i).getIsdislike()==true){
				return -1;
			}
			else {
				return 0;
			}
		}
		return 0;
	}
	

}
